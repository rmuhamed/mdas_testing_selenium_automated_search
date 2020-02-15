Feature: Find available flights

  Narrative:
  In order to find available flights
  As a client of https://vueling.com/es
  I want to be able to search flights

  Scenario: Initial search
    Given I'm in the main page
    When I try to find a flight
      | origin     | destination | outbound_date   | passengers |
      | MAD        | ALC         | TODAY           |      1     |
    Then I get available flight
