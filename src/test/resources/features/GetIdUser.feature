Feature: Test method get id in Sample Users REST API testing

  Scenario: Get Users for ID
    Given Paola set GET users service api endpoint
    When I set request HEADER
    And I send id user
    And Send GET HTTP request
    Then I receive valid HTTP response code 200

  Scenario: Get Users for ID invalid
    Given Paola set GET users service api endpoint
    When I set request HEADER
    And I send id user
    And Send GET HTTP request
    Then I receive invalid HTTP response code 400