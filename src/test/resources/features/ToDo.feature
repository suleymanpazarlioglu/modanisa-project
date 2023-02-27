Feature:ToDo app feature
  Scenario: As a user check the todo operations
    Given Empty ToDo list
    When I write "buy some milk" to <text box> and press <enter>
    Then I should see "buy some milk" item in ToDo list