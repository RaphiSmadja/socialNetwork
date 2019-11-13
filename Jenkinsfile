pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                withMaven(maven: 'maven_3_6_2') {
                    sh 'mvn --version'
                    sh 'mvn clean compile'
                }
            }
        }
    }
}