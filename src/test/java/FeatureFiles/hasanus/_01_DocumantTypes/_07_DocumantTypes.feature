Feature: Documant Types functionaliitiy

  Background: Login Functionalitiy
    Given Naviagate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly

  Scenario: Documant Types
    And Click on the element in left nav
      | setupOne      |
      | parameters    |
      | documentTypes |
    And Click on the element in the Dialog
      | addButton |
    And User sending the keys in Dialog content
      | nameInput | hasan |

    And Click on the element in the Dialog
      | stageSelect |
      | stageStudentSelect |
      | newDocument |

    And Click on the element in the Dialog
      | saveButton |
    And Success message should be displayed