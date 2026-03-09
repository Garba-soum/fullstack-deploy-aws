pipeline {
    agent any

    stages {
        stage('Build Backend Image') {
            steps {
                sh 'docker build -t backend ./Backend'
            }
        }

        stage('Build Frontend Image') {
            steps {
                sh 'docker build -t frontend ./Frontend'
            }
        }

        stage('Deploy Containers') {
            steps {
                sh 'docker compose down || true'
                sh 'docker compose up -d'
            }
        }
    }
}