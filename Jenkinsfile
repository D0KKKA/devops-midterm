pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
    }

    environment {
        IMAGE_NAME = 'kukurekin-danil-student-api:v1.0-37554'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Student: Kukurekin Danil, group it2-2312, ID 37554'
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean bootJar'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'PATH=/Applications/Docker.app/Contents/Resources/bin:/usr/local/bin:$PATH /usr/local/bin/docker build -t $IMAGE_NAME .'
            }
        }
        stage('Verify') {
            steps {
                sh 'PATH=/Applications/Docker.app/Contents/Resources/bin:/usr/local/bin:$PATH /usr/local/bin/docker image inspect $IMAGE_NAME > /dev/null'
                echo 'Docker image verified successfully'
            }
        }
    }
}
