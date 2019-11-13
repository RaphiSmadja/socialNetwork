pipeline {
    agent any

    stages {
        stage('Build') {
            withMaven(maven: 'maven-3') {
                  // Run the maven build
                  sh "mvn clean install"

                } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs & SpotBugs reports...
            steps {
                echo 'Building..'
                mvn compile
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