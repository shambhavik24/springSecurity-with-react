pipeline {
    agent any

    stages {
        stage('Build & Test') {
            steps {
                git 'https://github.com/shambhavik24/springSecurity-with-react.git'
                sh './mvnw clean install'
            }
        }

        stage('Package') {
            steps {
                sh './mvnw package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts 'target/*.jar'
            }
        }
    }
}
