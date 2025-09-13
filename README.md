# Master-Automation-Framework
This Repository is used to develop industry level framework.
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
│   │   │       └── constants/
│   │   │          └── FrameWorkConstants
│   │   │       └── driver/
│   │   │          └── Driver
│   │   │          └── DriverManager
│   │   │       └── enums/
│   │   │          └── ConfigProperties
│   │   │          └── WaitStrategy
│   │   │       └── factories/
│   │   │          └── DriverFactory
│   │   │          └── ExplicitWaitFactory
│   │   │       └── logger/
│   │   │          └── ExtentLogger
│   │   │       └── pages/
│   │   │          └── BasePage
│   │   │          └── CartPage
│   │   │          └── ConfirmationPage
│   │   │          └── DashBoardPage
│   │   │          └── LoginPage
│   │   │          └── PaymentPage
│   │   │       └── reports/
│   │   │          └── ExtentManager
│   │   │          └── ExtentReport
│   │   │       └── utils/
│   │   │          └── ExcelUtils
│   │   │          └── PropertyUtils
│   │   │          └── ScreenshotUtils
│   │   └── resources/
│   │       └── archetype-resources
│   │       └── META-INF.maven
│   └── test/
│       ├── java/
│       │   ├── API.com.jarhub/
│       │   │   └── 
│       │   └── UI.com.jarhub/
│       │       └── listeners
│       │           └── Listener
│       │       └── tests
│       │           └── BaseTest
│       │           └── LoginTest
│       │           └── ProductionOrderTest
│       └── resources/
│           └── config
│               └── config.properties
├── .gitignore
├── README.md
├── pom.xml
├── testng.xml

**💻 Tech Stack**
- Java 21
- Selenium 4
- Rest Assured
- TestNG
- Maven
- Allure & Extent Reports
- Apache POI

**🧩 Design Patterns Used**
- Page Object Model (POM)
- Factory Design Pattern 
- Singleton for Driver Management 
- Enum for Config Keys 
- Listener Pattern for Logging & Screenshot


## 🚀 Getting Started

1. Clone the repo:
```bash
git clone https://github.com/jagratgupta1989/Master-Automation-Framework.git

2. Run tests:
mvn clean test


**🛠️ Reporting**
Allure and Extent reports Both support this framework.

**🙋‍♂️ Developed with ❤️ by:**
Jagrat Gupta

**📞 Need Help or 1:1 Mentorship?**
Let's connect via Topmate for automation consultation or framework deep dives.

**🙌 Contribution**
Feel free to fork the repo and raise a pull request if you'd like to contribute!






