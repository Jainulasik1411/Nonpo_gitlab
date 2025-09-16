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
                    url: 'https://github.com/your-username/Nonpo_regression.git'
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                sh "mvn tes
