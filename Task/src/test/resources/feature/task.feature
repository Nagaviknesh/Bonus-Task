@TaskFeature
Feature: Find the  app name
  Background: Cloud control app
  Scenario Outline: Find app name which has version as null
    Given MicroService Version
#    When Enter environment name as <value>
#    git Then app name displayed
    Examples:
      | value |
      | "Qa1" |
      | "QA2" |



  Scenario Outline: Search and find if 2 fields are having a version mismatch
    When user gives the environments as <string> and <string2>
    Then find the app name having a mismatch of versions between the given environments
    Examples:
      | string | string2 |
      | "Qa1"  | "QA2"   |
