Feature: Account Settings
  As a: GoHeavy Admin / Fleet Owner / Dispatcher / Document Approver/Retailer Admin/Store Admin/ Store User/Customer				
  I Want To: edit profile information				
  So That: I can update my user profile.

  Background: 
    Given Any user is logged

 #Scenario 1
  #Scenario: Update Settings
   # Given The user is in  Account Settings view
   # When User insert valid data
   # And clicks on the "Update" button
   # Then The system saves the user profile information
   # And The system displays popup with success message: "Your profile was successfully updated"

#Scenario 3
Scenario Outline: Edit with invalid data
Given The user is in  Account Settings view
When The user insert no valid data "<Data>" in field "<Field>"
Then The system displays an error message "<Message>"
Examples:
|Field| Data|Message|
|First Name|%|Only letters and the special characters (' -) are allowed. 50 characters maximum|
#|Last Name|%|Only letters and the special characters (' -) are allowed. 50 characters maximum|
#|Email|.|Please, enter a valid email address|
#|Mobile|2|Please, enter a valid mobile number|
#|Address|%|The only special characters allowed are (. - , '). 50 characters maximum|
#|City|%|The only special characters allowed are (- '). 50 characters maximum|
#|Zip Code|1|Please, enter a valid ZIP code|
  