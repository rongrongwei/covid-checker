# covid-checker
## Project Details: 
Project Name: Covid-19 Temperature Checker  
Team Name: Group 3 (Coders Against COVID)
Team Members:  
- Rongrong Wei  
- Ethan Chen  
- Michelle Richardson (team lead)  
- Adam Alaniz  
- Jose Muniz  

Short description. This project is an app for helping employees check in to work.  
Known Bugs: Passwords are hardcoded and can't be changed by the user right now.  "New" page does not create content. No date / employee id validation in the sign-in form.  
Login Info: Default Password is "123"  
Requirements: Java8, JavaFX, SceneBuild (v3 or greater)  

Important notes: When testing this application the default password is always "123".  

## Instructions for importing application to Eclipse
Step 1: Dowload the archive file `covidAppFinalProject.zip` from the root directory of the project  
Step 2: Go to import in Eclipse and import an "existing project"  
Step 3: Use the Main.java file's main to run the application. (Don't run `TestDataStore.java` in the model package).

## What is special about this application?
This application helps employees check in to work, tracks sick employees and stores health data using 128-bit AES cryptography - an industry standard technique for preventing unwanted data access.

All data files with sensitive data in this application are stored in an unreadable format. For example, the survey data file looks like this:
```
(base) rongrongsMac:Final project rongrong$ cat surveyfile 
|??:xQ^???W??:??????m?s?ߕ??/??
                              ٪ݮ?q?]???X?M1?K?
T9??UI)%?H}k?YPE??X4s?6ߪR\Iٛ?????p??>
 ??$8E?? 
```

This cryptography implementation was developed using the java crypto and security libraries. 

## What does the application looks like?

Main page:
![img](https://raw.githubusercontent.com/rongrongwei/covid-checker/master/readme_img/main_page.png)

Sign in(Button)-Takes user to a sign in page and will ask user for username and password, then it will take the user to a survey page to answer some questions.
![img](https://raw.githubusercontent.com/rongrongwei/covid-checker/master/readme_img/survey.png)

Create New(Button)-Takes administrator to a password page first, if the password is correct it will take the administrator to a page that they can add new check in loactions and new survey questions. The new number of locations and questions will be storing in a text file for future update purposes. Note that this functionality has not been fully developed because of limited time.

Administration(Button)-Takes administrator to a page that will show them the survey results.
![img](https://raw.githubusercontent.com/rongrongwei/covid-checker/master/readme_img/adminView.png)


