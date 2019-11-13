pipeline {
    agent any
    stages {
        stage('Build') {
            def mvnHome = tool name: 'maven-3', type: 'maven'
            steps {
                echo 'Building..'
                sh '${mvnHome}/bin/mvn mvn --version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}