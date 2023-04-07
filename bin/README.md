# taskSelenuim

This is a repo of the Two GUI tasks (ExpandCart) 

using Maven, Data Driven Test, Page object model , TestNG  

**INTRO **

This project is implemented using Page Object Model,under this model, for each web page in the application, there should be a corresponding Page Class This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.There is a clean separation between test code and page specific code. for each web page there is a corresponding test page that can perform assertions on the website page.

This is a maven project you must download maven from marketplace to use it 

Steps to use the project:
1. Download maven from marketplace
2. clone the project or download it 
3. make sure that you install all jar file using maven dependices 

This project is implemented using Data-Driven Testing
You can Edit test data of these test cases from testData.properites from src/main/Data/testData.properites

First Test   

            Navigate to "https://www.google.com/ncr" 
            
            Search for "selenium webdriver" 
            
            Check that the First result text contains "Selenuim - Web Browser Automation" 
               
                        Page Class: Src/main/java/Pages/Task1Page 
                        
                        Test Class: Src/test/java/Tests/Task1Test
Second Test

            Apps page-->

            Navigate to "https://play.google.com/store/apps" 
            
            Click on "Apps" 
            
            Assert That you are in the apps page
            
            Educational page-->
            
            Navigate to "https://play.google.com/store/apps" 
            Click on Categories 
            Click on Educational 
            
            Assert That you are in the Educational apps page

                        Page Class: Src/main/java/Pages/Task2Page 
                        
                        Test Class: Src/test/java/Tests/Task2Test