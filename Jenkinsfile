pipeline {
    agent { label 'jdk21-node' }   // run on the agent with JDK21 installed

    tools {
        maven 'MAVEN_HOME'
        jdk 'jdk21'
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
                sh "mvn test -Dsurefire.suiteXmlFiles=testng.xml"
            }
        }
    }

    post {
        always {
            // Publish TestNG/JUnit results
            junit 'target/surefire-reports/*.xml'
        }
    }
}
