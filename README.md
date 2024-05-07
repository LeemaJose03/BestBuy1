# BestBuyE-Commerce_Capstone_Project
<p align="Left"><img src="Images/BestBuyLogo.png" alt="screenshot" width="600"></p>
The goal of this project is to test the major functionalities of the Best Buy website. I have used Data-Driven testing to test Sign In and Sign up functionality with the Data provider. Also, this project covers the main features like Adding items to the cart and searching and adding items to the cart.

## Coding Style:
- I have used Java Programming language with POM(Page Object Model) design pattern with Selenium framework in this project.

## IDE/Language:
- IDE: Eclipse
- Language: Java
## Technology/Frameworks used:
- TestNG framework - Used for various purposes like Data provider and the prioritization of tests and suites.
- Extent reports library - Used for the detailed reporting of the test cases status with various information     like screenshots.
- Maven project - For the ease of handling the dependencies in one place.
- Selenium Java library - Selenium provides support for the automation of web browsers. It provides extensions to emulate user interaction with browsers, a distribution server for scaling browser allocation, and the infrastructure for implementations of the W3C WebDriver specification.
- Apache POI library- For the reading and writing the data in an Excel sheet.
- Maven Surefire plugin- For the building of a Maven build and for Jenkins CI/CD implementation for invoking the build by local host or remotely.
- Jenkins tool - For triggering the build eventually executing the tasks locally or remotely.
- WebDriverManager library - Automated driver management and other helper features for Selenium WebDriver in Java.

  ## Steps to create the project and adding dependencies:
- Step 1: Create a new project of type Maven in Eclipse IDE.
- Step 2: Then add a testNG library by navigating to the Java build path and adding the testNG library. Then Apply and close.
- Step 3: The next step is to add the important dependencies in the Pom.xml file(refer to the below dependencies screenshot).
- Step 4: Since we are following the POM design pattern we need to create four packages(refer to the below POM screenshot).
- Step 5: Finally, add the Maven sure surefire plugin in the Pom.xml file under tag <build></build>(refer to the below Maven surefire screenshot).
- Step 6: Create a new testng.xml file adding the test java classes to be executed under suite.
- Step 7: Run the project a testNG suite.

## Dependencies screenshot:
<p align="Left"><img src="Images/Dependencies1.png" alt="screenshot" width="600"></p>
<p align="Left"><img src="Images/Dependencies2.png" alt="screenshot" width="600"></p>
<p align="Left"><img src="Images/Dependencies3.png" alt="screenshot" width="600"></p>
<p align="Left"><img src="Images/Dependencies4.png" alt="screenshot" width="600"></p>

## POM file screenshot:
<p align="Left"><img src="Images/POM structure.png" alt="screenshot" width="400"></p>



## Test case Code Example:
- I have used constructor chaining here in order to access the methods of pages with single object creation.
- We are using try/catch to handle the exception that occurs in between the process of executing a test case.
- Finally, based on the validation if the test case is passed we report that test case as Pass/Fail in extent report.


## Test Scenarios covered:
URL is broken or not
-Top links are redirecting properly
-Bottom links are redirecting properly
-Login scenarios(Positive and Negative)
-SignUp scenarios(Positive and Negative)
-U.S. Country is selected and redirected properly
-Shopping an item by Brand is done properly
-Shopping an item by Department is done properly
-Searching and adding an item to the cart is done properly
-Order is added to cart and moved till the payment screen properly.

## Maven output Build success screenshot:
 
![Mavenoutput](https://github.com/Venkateshjm13/BestBuyE-Commerce_Capstone_Project/assets/158301208/7e9c1e95-7cb9-48dd-9868-fadacb9843e4)

## Jenkins output Build success screenshot:
![Jenkinsoutput](https://github.com/Venkateshjm13/BestBuyE-Commerce_Capstone_Project/assets/158301208/fcde6306-e6ef-4c1e-b8fc-8bc60a84f7b0)

## Extent report screenshots:
<p align="Left"><img src="Images/Extentreport1.png" alt="screenshot" width="600"></p>
<p align="Left"><img src="Images/Extentreport2.png" alt="screenshot" width="600"></p>
## People who worked on this project
```Venkatesh JM```
