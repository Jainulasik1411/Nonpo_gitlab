pipeline {
    agent any
tools {
    jdk 'JAVA_HOME'       // must match the Name from Jenkins
    maven 'MAVEN_HOME'    // make sure Maven name also exists
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
