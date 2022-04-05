Feature: This feature will test ClickUp API

  Scenario: Add a new folder in ClickUp space adding list with a new task then removing task
    Given ClickUp Space exists
    When I create a new folder with name "Automobile"
    Then I verify that folder name is updated to "Automobile"
    Then I add new List to the folder with name "Mustang"
    When I check that List name is "Mustang" and it is added to correct folder
    Then I add a new task to the list
    Then I verify that task name is correct
    Then I remove Task created in the list
    Then I check that task is successfully removed