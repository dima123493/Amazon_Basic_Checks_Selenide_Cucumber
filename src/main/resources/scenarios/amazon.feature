Feature: Amazon testing using Cucumber

  Scenario: Product name is input in the search bar field and the "search" button is clicked
    Given Open website "https://www.amazon.com"
    When Input product name "Windows 11 Home (Digital Download)" into the search bar
    And Click the "Search" button
    Then Product "Windows 11 Home (Digital Download)" is displayed on the web page

  Scenario: User can increase amount of products to order
    When Open website "https://www.amazon.com/Windows-11-Home-Digital-Download/dp/B09WCHGP12/ref=sr_1_2?keywords=Windows+11+Home+%28Digital+Download%29&qid=1663423214&sr=8-2"
    And Increase amount of product to 2
    And Add this product to cart
    Then Verify that appropriate amount of products are added to the cart

  Scenario: User can not create duplicated account on the website
    When Registration page "https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fref%3Dnav_ya_signin&prevRID=1BPH7BKWE61R4SAM0STR&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0" is opened
    And Credentials are added to the fields and the Continue button is clicked
    Then Verify that user with same credentials already exists

  Scenario: Reminder about length of password is visible
    When Registration page "https://www.amazon.com/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=usflex&mobileBrowserWeblabTreatment=C&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fref%3Dnav_ya_signin&prevRID=1BPH7BKWE61R4SAM0STR&openid.assoc_handle=usflex&openid.mode=checkid_setup&desktopBrowserWeblabTreatment=C&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0" is opened
    Then Verify that there is a reminder that "Passwords must be at least 6 characters."

  Scenario: User can change country of delivery
    When Open website "https://www.amazon.com"
    And User can choose new location
    Then Verify that location has changed

  Scenario: "Sign in securely" button is displayed
    When Open website "https://www.amazon.com"
    Then Verify that "Sign in securely" button is displayed

  Scenario: User can change sorting method to "Price: Low to High"
    When Open website "https://www.amazon.com/s?i=fashion-womens-intl-ship&bbn=16225018011&rh=n%3A16225018011%2Cn%3A1040660%2Cn%3A1045024&pd_rd_r=9dbe0ce9-c09c-4967-b2e4-8d941bb5b17e&pd_rd_w=RMzKn&pd_rd_wg=jMOVG&pf_rd_p=6a92dcea-e071-4bb9-866a-369bc067390d&pf_rd_r=T7EC3THBF8N8MNATBQ7A&qid=1646786470&rnid=1040660&ref=pd_gw_unk"
    And Change sorting method
    Then Verify that method changed

  Scenario: User can choose brand called "Calvin Klein"
    When Open website "https://www.amazon.com/s?i=fashion-womens-intl-ship&bbn=16225018011&rh=n%3A16225018011%2Cn%3A1040660%2Cn%3A1045024&pd_rd_r=9dbe0ce9-c09c-4967-b2e4-8d941bb5b17e&pd_rd_w=RMzKn&pd_rd_wg=jMOVG&pf_rd_p=6a92dcea-e071-4bb9-866a-369bc067390d&pf_rd_r=T7EC3THBF8N8MNATBQ7A&qid=1646786470&rnid=1040660&ref=pd_gw_unk"
    And Choose brand
    Then Verify that brand has changed

  Scenario: User can find information considering its question about the product
    When Open website "https://www.amazon.com/AmazonBasics-Performance-Alkaline-Batteries-Count/dp/B00MNV8E0C/ref=lp_16225009011_1_2?th=1"
    And Find answer on the following question "Where are these batteries manufactured?"
    Then Verify that answer equals "All I know is it said Amazon basic batteries"

  Scenario: User can not participate in "Giveaway" contest
    When Open website "https://www.amazon.com/gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc"
    Then Verify that "Giveaway" text is not presented on the webpage

