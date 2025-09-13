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
                allure(
                            includeProperties: false,
                            results: [[path: 'target/allure-results']],
                            reportBuildPolicy: 'ALWAYS',
                            commandline: 'AllureCommandline'
                        )
                junit '**/target/surefire-reports/*.xml'
                script {
                                def summaryFile = readFile 'target/allure-results/widgets/summary.json'
                                def summary = readJSON text: summaryFile
                                def passed = summary.statistic.passed
                                def failed = summary.statistic.failed
                                def broken = summary.statistic.broken
                                def skipped = summary.statistic.skipped
                                def total = summary.statistic.total

                                def emailBody = """
                                <html>
                                <head>
                                    <style>
                                        body { font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px; }
                                        .container { background-color: #fff; padding: 20px; border-radius: 8px; }
                                        h2 { color: #2E86C1; }
                                        table { width: 50%; border-collapse: collapse; margin-top: 15px; }
                                        th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
                                        th { background-color: #2E86C1; color: white; }
                                        .pass { color: green; font-weight: bold; }
                                        .fail { color: red; font-weight: bold; }
                                    </style>
                                </head>
                                <body>
                                    <div class="container">
                                        <h2>🚀 Jenkins Build Report</h2>
                                        <p><b>Build Status:</b> ${currentBuild.currentResult}</p>
                                        <p><b>Allure Report Link:</b> <a href="${env.BUILD_URL}allure" target="_blank">View Allure Report</a></p>

                                        <h3>📊 Test Summary</h3>
                                        <table>
                                            <tr>
                                                <th>Total Tests</th>
                                                <th>Passed</th>
                                                <th>Failed</th>
                                                <th>Broken</th>
                                                <th>Skipped</th>
                                            </tr>
                                            <tr>
                                                <td>${total}</td>
                                                <td class="pass">${passed}</td>
                                                <td class="fail">${failed}</td>
                                                <td>${broken}</td>
                                                <td>${skipped}</td>
                                            </tr>
                                        </table>
                                    </div>
                                </body>
                                </html>
                                """

                                emailext (
                                    subject: "Jenkins Build ${currentBuild.fullDisplayName} - Allure Test Summary",
                                    body: emailBody,
                                    recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                                    to: 'your.email@example.com',
                                    mimeType: 'text/html'
                                )
                }
            }
        }
}