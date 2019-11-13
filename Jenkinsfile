pipeline {
    agent any
    stages {
        stage('Build') {

            steps {
                withMaven(maven : 'maven-3') {
                    echo 'Building..'
                    sh  'mvn --version'
                }
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