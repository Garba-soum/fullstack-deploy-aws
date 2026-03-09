pipeline {

    agent any

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/Garba-soum/fullstack-deploy-aws.git'
            }
        }

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