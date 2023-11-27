# new feature
# Tags: optional

Feature: An User edits the date in a pending meeting

  As an user
  I want to be able to the edit a current meeting
  So that I can update the meeting details as needed

  Scenario: Edit an Existing Meeting
    Given I am on the meeting details page
    When I select a new meeting date
    And I reschedule the meeting
    And I confirm the new meeting
    Then I validate that the meeting is Successfully Rescheduled