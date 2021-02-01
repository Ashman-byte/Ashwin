@complete
Feature: Navigate into napa websites and automate the requested functionalities

@napa01
Scenario: Navigate into the given website and enter the provided details to expose search results
Given user gets into the website
And user clicks on autocare center nearby
And user enters pincode
When user clicks search
Then search results should be displayed  

@napa02
Scenario: Navigate and enter the relevant details to get the dollar estimation
Given user navigates to napaonline website
And user clicks on get an estimate button
And user fills in the vehicle details
And user enters the pincode 
And user clicks on the select vehicle and continue button
And user selects brakes and brakes and pad replacement
When user clicks on get an estimate 
Then dollar estimation should be displayed

@napa03
Scenario: Log into napaprolink with provided credentials and do the followings
Given user navigates to the napaprolink wesite
And user logs in with the provided credentials
And user searches for the provided vehicle model
And user adds the necessary search terms and searches for the product
And user clicks on a product 
And user adds the item to the cart
When user clicks checkout 
Then user should be able to see price and our added item in cart on next page

@napa04
Scenario: Navigate to napapunchout website , generate VIN and check whether VIN details are displayed
Given user navigates into napapunchout website
And user enters the tracs id
And user clicks login
And user navigates to vingenerator
And user copies the VIN
And user navigates back to napapunchout and copies VIN 
When user clicks vehicle history
Then VIN details should be displayed

@napa05
Scenario: Navigate to napapunchout.ca/punchoutweb/ and do the relevant functions.
Given user navigates to napapunchout website
And user clicks new cart
And user clicks punchout
And select click to change the napa store and change it to training and demo for stores  
And type in the number  in the search bar
And click search by keyword
And user adds quantity for oil filter and adds item to cart
And user clicks on open under shopping cart
When user clicks on checkout
Then user should see a page with details of what he purchased
