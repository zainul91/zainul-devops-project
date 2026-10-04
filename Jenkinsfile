pipeline { 
    agent { 
        label 'Slave2' 
    } 
 
    stages { 
 
        stage('Maven Build') { 
            steps { 
                withEnv([ 
                    'JAVA_HOME=C:\\Program Files\\Java\\jdk-17.0.2', 
                    'PATH+JAVA=C:\\Program Files\\Java\\jdk-17.0.2\\bin' 
                ]) { 
                    bat ''' 
                        echo JAVA_HOME=%JAVA_HOME% 
                        java -version 
                        mvn -version 
                        mvn clean package 
                    ''' 
                } 
            } 
        } 
 
        stage('Docker Build') { 
            steps { 
                bat 'docker build -t zainul-devops-app .' 
            } 
        } 
 
        stage('Docker Run') { 
            steps { 
                bat 'docker run --rm --name zainul-devops-container zainul-devops-app' 
            } 
        } 
 
    } 
}