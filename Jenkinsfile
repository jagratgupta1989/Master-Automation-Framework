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
                   allure includeProperties: false, results: [[path: 'target/allure-results']], commandline: 'AllureCommandline'
                   junit '**/target/surefire-reports/*.xml'

                   script {
                       def summaryFilePath = 'target/allure-results/widgets/summary.json'

                       if (fileExists(summaryFilePath)) {
                           def summaryFile = readFile summaryFilePath
                           def summary = readJSON text: summaryFile
                           def passed = summary.statistic.passed
                           def failed = summary.statistic.failed
                           def broken = summary.statistic.broken
                           def skipped = summary.statistic.skipped
                           def total = summary.statistic.total

                           def emailBody = """
                           <html>
                           <body>
                               <h2>✅ Jenkins Build Report</h2>
                               <p><b>Build Status:</b> ${currentBuild.currentResult}</p>
                               <p><b>Allure Report Link:</b> <a href="${env.BUILD_URL}allure" target="_blank">View Allure Report</a></p>
                               <h3>Test Summary</h3>
                               <table border="1" cellpadding="5">
                                   <tr><th>Total</th><th>Passed</th><th>Failed</th><th>Broken</th><th>Skipped</th></tr>
                                   <tr><td>${total}</td><td>${passed}</td><td>${failed}</td><td>${broken}</td><td>${skipped}</td></tr>
                               </table>
                           </body>
                           </html>
                           """

                           emailext (
                               subject: "✅ Jenkins Build ${currentBuild.fullDisplayName} - Allure Test Summary",
                               body: emailBody,
                               recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                               to: 'your.email@example.com',
                               mimeType: 'text/html'
                           )

                       } else {
                           // Simple email when no test results are available
                           def simpleBody = """
                           <html>
                           <body>
                               <h2>⚠️ Jenkins Build Report</h2>
                               <p><b>Build Status:</b> ${currentBuild.currentResult}</p>
                               <p><b>No Allure test results found.</b></p>
                               <p>Please verify if tests were executed properly.</p>
                           </body>
                           </html>
                           """

                           emailext (
                               subject: "⚠️ Jenkins Build ${currentBuild.fullDisplayName} - No Test Results Found",
                               body: simpleBody,
                               recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                               to: 'your.email@example.com',
                               mimeType: 'text/html'
                           )
                       }
                   }
           }
    }
}