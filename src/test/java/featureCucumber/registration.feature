Feature: check on free price of documents
  I Want To Check That document is free


  Scenario Outline: check document free
    Given The User In Home LevelSet Home Page
    When The User click on Create a Document Link
    And He click on document product name   "<productName>"
    Then The price of the product  is free "<productName>"


Examples:
  | productName |
  | ahmed20-Day Preliminary Notice |
  | Notice of Intent to Lien|
  | Lien / Bond Claim|
  | Lien Waiver|