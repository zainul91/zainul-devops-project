pipeline {
    agent any

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

    }
}