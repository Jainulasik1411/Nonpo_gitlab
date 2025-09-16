pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'   // Jenkins Maven installation name
        jdk 'jdk 21'          // Use the JDK installed in Jenkins
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

