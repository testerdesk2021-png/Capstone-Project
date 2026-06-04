# Selenium Automation Framework using POM+TestNG+Maven

##Project Description
This project is a Selenium - java  based Automation Framework using Maven and TestNg.It follows Page Object Model(POM).

##Tools & Technologies used
-Java
-Selenium WebDriver
-TestNG
-IntelliJ
-Maven

##Project Structure
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CHeckoutPage.java
│   │   │   │   └── HomePage.java
│   │   │   │
│   │   │   ├── utils
│   │   │   │   ├── ConfigReader.java
│   │   │   │   ├── DriverFactory.java
│   │   │   │   └── WaitUtils.java
│   │   │   └── |--ScreenshotUtil.java
│
│   │   │   ├── resources
│   │   │   │   └── config.properties
│
│   ├── test
│   │   ├── java
│   │   │   ├── base
│   │   │   │   ├── BaseTest.java
│   │   │   ├── testcases
│   │   │   │   ├── AddMultipleProductsTest.java
│   │   │   │   ├── AddToCartTest.java
│   │   │   │   ├── NavigationTest.java
│   │   │   │   ├── PlaceOrderTest.java
│   │   │   │   ├── ProductCountTest.java
│   │   │   │   ├── SearchProductTest.java
│
├── target
├── ├── Surefire-reports
├── pom.xml
├── README.md
├── testng.xml

##Testcases covered
1.Search Product Testcase
2.Add to Cart testcase
3.Add Multiple products to cart testcase
4.Placeorder testcase
5.Navigation Testcase
6.ProductCount Testcase

##How to run Testcases

###Using maven:
use command: mvn clean test

###Using TestNG:
-Rightclick on testng.xml
-Click Run

##Reports
-Surefire-Reports :
target/surefire-reports/index.html

##Application under test
https://rahulshettyacademy.com/seleniumPractise/#/

##Author
Haarika


