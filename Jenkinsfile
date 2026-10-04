```groovy
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
 
        stage('Test') { 
            steps { 
                withEnv([ 
                    'JAVA_HOME=C:\\Program Files\\Java\\jdk-17.0.2', 
                    'PATH+JAVA=C:\\Program Files\\Java\\jdk-17.0.2\\bin' 
                ]) { 
                    bat 'mvn test' 
                } 
            } 
        } 
    
        stage('Docker Build') {    
            steps {    
                bat 'docker build -t zainul-devops-app .'    
            }    
        } 
 
        stage('Docker Push') { 
            steps { 
                withCredentials([ 
                    usernamePassword( 
                        credentialsId: 'dockerhub-credentials', 
                        usernameVariable: 'DOCKER_USERNAME', 
                        passwordVariable: 'DOCKER_PASSWORD' 
                    ) 
                ]) { 
                    bat ''' 
                        docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD% 
                        docker tag zainul-devops-app %DOCKER_USERNAME%/zainul-devops-app:latest 
                        docker push %DOCKER_USERNAME%/zainul-devops-app:latest 
                    ''' 
                } 
            } 
        } 
    
        stage('Docker Run') {    
            steps {    
                bat 'docker run --rm --name zainul-devops-container zainul-devops-app'    
            }    
        }  
  
        stage('Deploy') {  
            steps {  
                echo 'Application deployed successfully'  
            }  
        }  
    
    }    

    // GitHub Webhook Test
}
