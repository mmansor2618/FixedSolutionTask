# FixedSolutionTask
This is a repo of the GUI task (Fixed Solution Task)

using Maven, Data Driven Test, Page object model , TestNG

**INTRO **

This project is implemented using Page Object Model,under this model, for each web page in the application, there should be a corresponding Page Class This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.There is a clean separation between test code and page specific code. for each web page there is a corresponding test page that can perform assertions on the website page.

This is a maven project you must download maven from marketplace to use it

Steps to use the project:

Download maven from marketplace clone the project or download it make sure that you install all jar file using maven dependices This project is implemented using Data-Driven Testing You can Edit test data of these test cases from crud.properties from src/Dat/crud.properties

I faced issue running project on browser because link for task browser treats it as inscurec link so i donlowaded source code for project and i add these fiels
into automation project and using visual studio code and using extension in it I managed to run project using IP
all this information is explained in video for task

First Testcase

1- open List page 

2- Click on Add Recipe

3- fill data for recipe name and ingredient

4- assert that added recipe appearing on the list

Second Testcase

1- open List page 

2- Click on the added Recipe

3- update data for recipe name and ingredient

4- assert that the update is appearing on list and assert that ingredient data is appearing correct after update

Third Testcase

1- while opening the update pop up for checking ingredient

2- Click on delete

3- assert that the deleted reciep is not appearing on the list


Page Class: src/main/java/Pages/CrudPage

Test Class: src/test/java/Tests/CrudTest

