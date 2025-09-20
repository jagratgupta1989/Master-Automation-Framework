🚀 MasterAutomationFramework

A unified automation framework for both UI 🖥️ and API 🌐 testing, designed to be scalable, maintainable, and production-ready. This framework integrates the best industry practices with robust reporting and CI/CD support.
📁 **Folder Structure (UI + API Automation Ready in Java)**

MasterAutomationFramework/
│── .allure
├── .idea
├── allure-results
├── extent-test-output
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.jarhub/
│   │   │       └── apipayloads/
│   │   │          └── Payloads
│   │   │       └── apiresources/
│   │   │          └── APIResources
│   │   │       └── constants/
│   │   │          └── FrameWorkConstants
│   │   │       └── driver/
│   │   │          └── APITestContext
│   │   │          └── Driver
│   │   │          └── DriverManager
│   │   │       └── enums/
│   │   │          └── ConfigProperties
│   │   │          └── WaitStrategy
│   │   │       └── factories/
│   │   │          └── DriverFactory
│   │   │          └── ExplicitWaitFactory
│   │   │       └── logger/
│   │   │          └── AllureLogger
│   │   │          └── ExtentLogger
│   │   │       └── pages/
│   │   │          └── BasePage
│   │   │          └── CartPage
│   │   │          └── ConfirmationPage
│   │   │          └── DashBoardPage
│   │   │          └── LoginPage
│   │   │          └── PaymentPage
│   │   │       └── pojo/
│   │   │          └── AddPlace
│   │   │          └── DeletePlace
│   │   │          └── Location
│   │   │          └── UpdatePlace
│   │   │       └── reports/
│   │   │          └── ExtentManager
│   │   │          └── ExtentReport
│   │   │       └── specbuilders/
│   │   │          └── RequestSpecifications
│   │   │          └── ResponseSpecifications
│   │   │       └── utils/
│   │   │          └── CommonUtils
│   │   │          └── ExcelUtils
│   │   │          └── JsonUtils
│   │   │          └── PropertyUtils
│   │   │          └── ScreenshotUtils
│   │   └── resources/
│   │       └── archetype-resources
│   │       └── META-INF.maven
│   └── test/
│       ├── java/
│       │   ├── API.com.jarhub/
│       │   │   └── BaseTest
│       │   │   └── CrudEndToEnd
│       │   │   └── CrudEndToEndWithPOJO
│       │   └── UI.com.jarhub/
│       │       └── listeners
│       │           └── AnnotationTransformer
│       │           └── Listener
│       │           └── RetryAnalyzer
│       │       └── tests
│       │           └── BaseTest
│       │           └── LoginTest
│       │           └── ProductionOrderTest
│       └── resources/
│           └── config
│               └── config.properties
│           └── Excel
│               └── testdata.xlsx
│           └── jsons
│               └── AddPlace.json
│               └── DeletePlace.json
│               └── login.json
│               └── UpdatePlace.json
├── .gitignore
├── GridJenkinsfile
├── Jenkinsfile
├── README.md
├── pom.xml
├── testng.xml

💻 Tech Stack
- ☕ Java 21
- 🖱️ Selenium 4
- 🌐 Rest Assured
- ✅ TestNG
- 📦 Maven
- 📊 Allure & Extent Reports
- 📑 Apache POI (Excel Handling)

✨ Features
- 🔗 Hybrid Automation → Supports both UI & API tests in one framework.
- 🧩 Modular Design → Page Object Model (POM) for UI + POJO for APIs.
- 🧪 Retry & Listeners → TestNG Listeners & RetryAnalyzer integrated.
- 📊 Rich Reporting → Allure & Extent Reports for detailed insights.
- 🛠️ Factories & Utils → DriverFactory, WaitFactory, ExcelUtils, JsonUtils and many more.
- 🔒 Configurable → Easy environment switching via config.properties.
- ⚡ Parallel Execution → Enabled via TestNG + Selenium Grid.
- 🔄 CI/CD Ready → Jenkinsfile & Grid support for pipelines.


▶️ Getting Started
🔧 Prerequisites
- Install Java 21+
- Install Maven 3+
- Install Allure CLI (for reports)

📥 Clone Repo
- git clone https://github.com/jagratgupta1989/MasterAutomationFramework.git
- cd MasterAutomationFramework

📦 Install Dependencies
- mvn clean install

🚀 Run Tests
- Run all tests: mvn test
- Run with specific suite: mvn clean test -DsuiteXmlFile=testng.xml

📊 Reports
- Allure Report : allure serve allure-results
- Extent Report : Generated under extent-test-output/ folder.

🔗 CI/CD Integration
- ✅ Ready-to-use Jenkinsfile for pipeline setup.
- ✅ Supports Selenium Grid for distributed parallel execution.

🤝 Contributing
- Contributions are welcome! Feel free to fork, create a feature branch, and raise a PR.

📬 Connect With Me
- 💼 LinkedIn - https://www.linkedin.com/in/jagratgupta1706/
- 🎥 YouTube – Jagrat Automation Repository






