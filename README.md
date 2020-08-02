# covid-checker
This project is an app for helping employees check in to work.

## Instructions for importing application to Eclipse

Step 1: Download the GitHub repository as a zip file.
Step 2: Unzip the file.
Step 3: Click "file" on Eclipse and select "import".
Step 4: Import the entire folder to your Eclipse.
Step 5: Click "Run" to run the application.

## What is special about this application?
This application helps employees check in to work, tracks sick employees and stores health data using 256-bit AES cryptography - an industry standard technique for preventing unwanted data access.

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
[](https://raw.githubusercontent.com/rongrongwei/covid-checker/master/readme_img/main_page.png)

Sign in(Button)-Takes user to a sign in page and will ask user for username and password, then it will take the user to a survey page to answer some questions.



Create New(Button)-Takes administrator to a password page first, if the password is corrcet it will take the administrator to a page that they can add new check in loactions and new survey questions. The new number of locations and questions will be storing in a text file for future update purposes.

Administration(Button)-Takes administrator to a page that will show them the survey results.



