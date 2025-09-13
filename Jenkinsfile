pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/jagratgupta1989/Master-Automation-Framework.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
    post {
            always {
                echo 'Publishing Allure Report...'
                allure includeProperties: false, results: [[path: 'target/allure-results']]
                junit '**/target/surefire-reports/*.xml'
            }
        }
}