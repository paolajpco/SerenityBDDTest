Feature: Test Put method in Sample Users REST API testing

  Scenario: PUT User
    Given Paola set PUT user service api endpoint
    When I set request HEADER
    And Send PUT HTTP request
    Then I receive valid HTTP response code 200


  Scenario: PUT User invalid
    Given Paola set PUT user service api endpoint
    When I set request HEADER
    And Send PUT HTTP request
    Then I receive invalid HTTP response code 400

