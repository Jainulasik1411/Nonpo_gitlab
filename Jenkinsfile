pipeline {
    agent any

    tools {
        jdk 'Java 21'       // Must match exactly the JDK name in Jenkins
        maven 'MAVEN_HOME'  // Must match exactly the Maven name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Asik14/Nonpo_regression.git'
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
                junit '**/target/surefire-reports/*.xml' // Publish test reports
            }
        }

        stage('Deploy to AWS') {
            when {
                expression { return false } // Set to true when you want to deploy
            }
            steps {
                echo "Add AWS deployment commands here"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
