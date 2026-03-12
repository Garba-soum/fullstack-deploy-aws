pipeline {
    agent any

    stages {
        stage('Build Backend Image') {
            steps {
                sh 'docker build --no-cache -t backend ./Backend'
            }
        }

        stage('Build Frontend Image') {
            steps {
                sh 'docker build --no-cache -t frontend ./Frontend'
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