node {
	def MAVEN_HOME = tool "Maven_HOME"
    def JAVA_HOME = tool "JAVA_HOME"
    env.PATH="${env.PATH}:${MAVEN_HOME}/bin:${JAVA_HOME}/bin"
    
    def GIT_URL='REPOSITORY_URL'
	def OS_PROJECT_NAME='PROJECT_NAME'
	def REPO_NAME='REPOSITORY_NAME'
    
    stage('First Time Deployment'){
        script{
            openshift.withCluster() {
                openshift.withProject("${OS_PROJECT_NAME}") {
                    def bcSelector = openshift.selector( "bc", "${REPO_NAME}")
                    def bcExists = bcSelector.exists()
                    if (!bcExists) {
                        openshift.newApp("${GIT_URL}")
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
                openshift.withProject("${OS_PROJECT_NAME}"){
                    openshift.startBuild("${REPO_NAME}")   
                }
            }
        }
    }

    stage("Dev - Deploying Application"){
	   script{
            openshift.withCluster() {
                openshift.withProject("${OS_PROJECT_NAME}"){
                    openshiftDeploy(deploymentConfig: "${REPO_NAME}")   
                }
            }
        }  
    }
        
}
