def CONTAINER_NAME="sampleservice"
def CONTAINER_TAG="latest"
def DOCKER_HUB_USER="ramnar"
def HTTP_PORT="8090"

node {
       stage('Initialize'){
        def dockerHome = tool 'myDocker'
        def mavenHome  = tool 'myMaven'
        env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    }
    
    stage('Checkout') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build') {
        /* This builds the actual image; synonymous to
         * docker build on the command line */
         sh  "mvn clean install"
    }

    stage("Image Prune"){
        deleteOldImage(CONTAINER_NAME)
    }

    stage('Image Build'){
        buildImage(CONTAINER_NAME, CONTAINER_TAG)
    }
    
    stage('Push to Docker Registry'){
            withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                pushToRegistry(CONTAINER_NAME, CONTAINER_TAG, USERNAME, PASSWORD)
            }
    }
    
    stage('Run App'){
        runApp(CONTAINER_NAME, CONTAINER_TAG, DOCKER_HUB_USER, HTTP_PORT)
    }

}

def deleteOldImage(containerName){
    try {
        sh "docker image prune -f" /*Delete the docker image*/
        sh "docker stop $containerName" /*Stop running docker containers*/
    } catch(error){}
}

def buildImage(containerName, tag){
    sh "docker build -t $containerName:$tag --pull --no-cache ." /*build docker image, pull latest image from repo, donot use cache*/
    echo "Image build complete"
}

def pushToRegistry(containerName, tag, dockerHubUser, dockerPassword){
    sh "docker login -u $dockerHubUser -p $dockerPassword" /*login to docker registry*/
    sh "docker tag $containerName:$tag $dockerHubUser/$containerName:$tag"/*label docker image with localname and registry name*/
    sh "docker push $dockerHubUser/$containerName:$tag"  /*push to docker registry*/
    echo "Image push complete"
}

def runApp(containerName, tag, dockerHubUser, httpPort){
    sh "docker pull $dockerHubUser/$containerName" /*pull image from to docker registry*/
    sh "docker run -d --rm -p $httpPort:$httpPort --name $containerName $dockerHubUser/$containerName:$tag" /*run docker container in detached mode, map ports, automatically remove when it exits */
    echo "Application started on port: ${httpPort} (http)"
}
