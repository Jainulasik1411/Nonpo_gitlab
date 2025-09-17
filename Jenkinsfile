pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'       // must match the Name from Jenkins
        maven 'MAVEN_HOME'    // must match the Name from Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Asik14/Nonpo_regression.git'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps {
                bat "mvn test"
                junit '**/target/surefire-reports/*.xml' // Publish test reports
            }
        }

        stage('Deploy to AWS') {
            steps {
                echo "Deploying to AWS..."
                // Example AWS commands (replace with your actual deployment steps)
                // bat "aws s3 cp target/yourapp.jar s3://your-bucket/"
                // bat "aws ecs update-service --cluster your-cluster --service your-service --force-new-deployment"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            cleanWs()
        }

        success {
            echo "Pipeline succeeded! 🎉"
        }

        failure {
            echo "Pipeline failed! ❌"
        }
    }
}
