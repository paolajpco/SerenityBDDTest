Feature: Test Delete method in Sample Users REST API testing

  Scenario: Delete User
    Given Paola set DELETE users service api endpoint
    When I set DELETE HTTP request
    Then I receive valid HTTP response code 200

  Scenario: Delete User invalid
    Given Paola set DELETE users service api endpoint
    When I set DELETE HTTP request
    Then I receive invalid HTTP response code 400