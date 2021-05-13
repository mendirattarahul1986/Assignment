Feature: Check whether website is working
  Scenario: Check whether website is working
  Given open the brower with URL
  When Maximize the browser Window
  Then Verify the page is loaded completely.
  Then  verify the title of the page.

 Scenario: Check Whether the text box is editable
   Given Page is already loaded
   When check the box is editable
   Then Verify the box is editable

   Scenario: Click on Start button without any value
     Given  Page is already loaded
     When click on Start button
     Then Verify the timer is not started

     Scenario: Enter value and click on Start button
       Given Page is already loaded
       When Enter 25 in text box and click on Start
       Then Verify the next page is loading
       Then Verify the counter which is reducing by 1

       Scenario: After the timer is over validate popup is coming
         Given Timer is already working
         When Timer reduce to Zero
         Then Verify the PopUp is coming
         Then Click on OK
         Then Validate Time expired message







