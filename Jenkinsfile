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
            steps {
                echo "Deploying to AWS..."
                // Example AWS command (replace with your actual deployment commands)
                // sh "aws s3 cp target/yourapp.jar s3://your-bucket/"
                // sh "aws ecs update-service --cluster your-cluster --service your-service --force-new-deployment"
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
