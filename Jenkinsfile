node {
	def MAVEN_HOME = tool "Maven_HOME"
    def JAVA_HOME = tool "JAVA_HOME"
    env.PATH="${env.PATH}:${MAVEN_HOME}/bin:${JAVA_HOME}/bin"
    
    def GIT_URL='https://github.com/ramnar/starwars.git'
	def OS_PROJECT_NAME='demo-devops'
	def REPO_NAME='starwars'
    
   stage('First Time Deployment'){
        script{
            openshift.withCluster() {
                openshift.withProject("${OS_PROJECT_NAME}") {
                    def bcSelector = openshift.selector( "bc", "${REPO_NAME}")
                    def bcExists = bcSelector.exists()
                    if (!bcExists) {
                        openshift.newApp("redhat-openjdk18-openshift:1.1~${GIT_URL}","--strategy=source")
			sh 'sleep 135'    
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
		    sh 'sleep 135' 
                }
            }
        }
	}
   
        
}
