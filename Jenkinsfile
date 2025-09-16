pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'   // Jenkins Maven installation name
        jdk 'JDK17'          // Jenkins JDK installation name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Asik14/Nonpo_regression.git'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'   // Publish TestNG/JUnit results
        }
    }
}
