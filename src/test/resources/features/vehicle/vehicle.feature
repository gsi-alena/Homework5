#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Vehicles and Insurance List
  As a: GoHeavy Admin / Fleet Owner
  I want to: Add vehicles
  So that: I can add vehicles

Background: 
    Given Any user is logged as fleet owner
  
  Scenario: Add Vehicle
    Given The user is in Vehicles and Insurance List view
    And Clicks on the AddVehicle button
    When User insert valid data in step one Vehicle Info
    And Clicks on the step one Next button 
    When User insert valid data in step two Vehicle Features
    And Clicks on the step two Next button 
    When User insert valid data in step three Driving Requirements
    And Clicks on the Done button 
    Then The system saves the new vehicle information
    And The system displays popup with success message "<A new  Vehicle was successfully created.>"
    
    


      
