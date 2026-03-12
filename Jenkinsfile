pipeline {
    agent any

    stages {
        stage('Build Images with Compose') {
            steps {
                sh 'docker-compose build --no-cache'
            }
        }

        stage('Deploy Containers') {
            steps {
                sh 'docker-compose down || true'
                sh 'docker-compose up -d --force-recreate'
            }
        }
    }
}