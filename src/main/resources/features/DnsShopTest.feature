Feature: Check filtration and characteristics on DNS smartphone page
  Scenario Outline: verify characteristics of Samsung smartphone are as set in filtration
    Given I go to dns-shop website
    When I take a screenshot with filepath <filepath> and filename start-page-test-1
    And I go to smartphone section
    And I take a screenshot with filepath <filepath> and filename smartphone-section-test-1
    And I apply smartphone filters for Samsung
    And I sort list of smartphones from expensive to cheapest
    And I choose the first smartphone from the list
    And I take a screenshot with filepath <filepath> and filename selected-samsung-smartphone
    Then I verify smartphone <builtInMemory> specifications for Samsung
    And I close browser

    Examples:
    |                              filepath                                            | builtInMemory |
    | C:\Users\asus\Desktop\тестовое задание webdriver\src\main\resources\Screenshots\ |      256      |

  Scenario Outline: verify characteristics of Apple smartphone are as set in filtration
    Given I go to dns-shop website
    When I take a screenshot with filepath <filepath> and filename start-page-test-2
    And I go to smartphone section
    And I take a screenshot with filepath <filepath> and filename smartphone-section-test-2
    And I apply smartphone filters for Apple
    And I sort list of smartphones from expensive to cheapest
    And I choose the first smartphone from the list
    And I take a screenshot with filepath <filepath> and filename selected-apple-smartphone
    Then I verify smartphone <ramMemory> specifications for Apple
    And I close browser

    Examples:
    |                              filepath                                            | ramMemory |
    | C:\Users\asus\Desktop\тестовое задание webdriver\src\main\resources\Screenshots\ |     4     |