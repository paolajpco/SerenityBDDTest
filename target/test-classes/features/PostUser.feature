Feature: Test Post in Sample Users REST API testing

  Scenario: Add User
    Given Paola set POST users service api endpoint
    When I set request HEADER
    And Send POST HTTP request
    Then I receive valid HTTP response code 200

  Scenario: Add User invalid
    Given Paola set POST users service api endpoint
    When I set request HEADER
    And Send POST HTTP request
    Then I receive invalid HTTP response code 400

