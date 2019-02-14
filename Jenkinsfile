node {
	def MAVEN_HOME = tool "Maven_HOME"
    def JAVA_HOME = tool "JAVA_HOME"
    env.PATH="${env.PATH}:${MAVEN_HOME}/bin:${JAVA_HOME}/bin"
    
    def GIT_URL='REPOSITORY_URL'
	def REPO_NAME='REPOSITORY_NAME'
    
    stage('First Time Deployment'){
        script{
            openshift.withCluster() {
                openshift.withProject("${REPO_NAME}") {
                    def bcSelector = openshift.selector( "bc", "${REPO_NAME}")
                    def bcExists = bcSelector.exists()
                    if (!bcExists) {
                        openshift.newApp('https://github.com/ramnar/starwars.git')
                    } else {
                        sh 'echo build config already exists'  
                    } 
                }
            }
        }
    }
    
	stage ('Checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[ url: "${GIT_URL}"]]])
    }
    
	stage('Packaging') {   
        sh 'mvn -DskipTests package'     
    }
    
	stage("Dev - Building Application"){
        script{
            openshift.withCluster() {
                openshift.withProject("${REPO_NAME}"){
                    openshift.startBuild("${REPO_NAME}")   
                }
            }
        }
    }

    stage("Dev - Deploying Application"){
	   script{
            openshift.withCluster() {
                openshift.withProject("${REPO_NAME}"){
                    openshiftDeploy(deploymentConfig: "${REPO_NAME}")   
                }
            }
        }  
    }
        
}
