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

     Scenario Outline: Enter value and click on Start button
       Given Page is already loaded
       When Enter <timeinseconds> in text box and click on Start
       Then Verify the counter which is reducing by 1

       Examples:
       |timeinseconds|
       |25  |




       Scenario: After the timer is over validate popup is coming
         Given Timer is already Over
         Then Verify the PopUp is coming and click on OK Button
         Then Validate Time expired message







