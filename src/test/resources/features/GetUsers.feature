Feature: Test Get method in Sample Users REST API testing

  Scenario: Get data Users
    Given Paola set GET users service api endpoint
    When I set request HEADER
    And Send GET HTTP request
    Then I receive valid HTTP response code 200

  Scenario: Get data Users invalid
    Given Paola set GET users service api endpoint
    When I set request HEADER
    And Send GET HTTP request
    Then I receive invalid HTTP response code 400