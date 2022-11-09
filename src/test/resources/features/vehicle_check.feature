Feature: Vehicle details check

  @vcheck
  Scenario: Verify the details of the vehicle
    Given I navigate to the vehicle tax check application
    And I should see the home page title as "Car Tax Check | Free Car Check"
    And I should see the home page header as "Free Car Check"
    And I collect the valid vehicles registration numbers from the "input.txt" data file
    When I capture the vehicles data for the valid registered numbers
    Then I compare the captured vehicles data with the expected data from the "output.txt" data file