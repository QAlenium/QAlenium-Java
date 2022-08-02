@Api @HappyPath @Regression
Feature: Api call
  As a candidate for this role
  I want to call some apis
  In order to pass the exam

  Background: Candidate gets the url to call
    Given I have the endpoint "https://api.zippopotam.us/us/33162"
    Then I should be able to call it

  Scenario: Successful http calls
    When I perform a "GET" in the given api
    Then I am able to validate a "200" status code
    And my output payload must be equals to "payload-sortie.json"

  Scenario Outline: Failed http calls
    When I perform a "<http_method>" in the given api
    And I use "<parameter>" as parameter
    Then I am able to validate a "<status_code>" status code
    Examples:
      | http_method     | status_code                       | parameter                         |
      | GET             | 200                               |                                   |
      | POST            | 405                               | {}                                |
      | PUT             | 405                               | {}                                |
      | DELETE          | 405                               |                                   |
      |                 | Invalid HTTP Method               | {}                                |
      |                 | Invalid HTTP Method               |                                   |