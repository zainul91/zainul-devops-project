pipeline {
    agent any

    stages {

        stage('Maven Build') {
            steps {
                bat '''
                    echo JAVA_HOME=%JAVA_HOME%
                    where java
                    java -version
                    where mvn
                    mvn -version
                '''
            }
        }

    }
}