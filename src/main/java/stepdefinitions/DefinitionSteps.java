package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    PageFactoryManager pageFactoryManager;
    ShoppingBagPage shoppingBagPage;
    SearchResultsPage searchResultsPage;
    SignInPage signInPage;
    ForgotPasswordPage forgotPasswordPage;
    ProductPage productPage;
    SaleSunglassesPage saleSunglassesPage;
    SavedItemsPage savedItemsPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }


    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.isHeaderVisible());
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        Assert.assertTrue(homePage.isFooterVisible());
    }

    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        Assert.assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        Assert.assertTrue(homePage.isSignInButtonVisible());
    }

    @And("User checks shopping bag button visibility")
    public void checkShoppingBagButtonVisibility() {
        Assert.assertTrue(homePage.isShoppingBagButtonVisible());
    }

    @When("User opens shopping bag")
    public void openShoppingBag() {
        homePage.clickShoppingBagButton();
        shoppingBagPage = pageFactoryManager.getShoppingBagPage();

    }

    @Then("User checks empty bag title visibility")
    public void checkShoppingBagTitleVisibility() {
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingBagPage.getEmptyBagTitle());
        Assert.assertTrue(shoppingBagPage.isEmptyBagTitleVisible());
    }


    @And("User makes search by keyword {string}")
    public void makeSearchByKeyword(String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks first product of search results")
    public void clickFirstProductOfSearchResults() {
        searchResultsPage.clickSearchResultsOnFirstProduct();
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User clicks add to bag button on product")
    public void clickAddToCartButtonOnProduct() {
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToBagButton();

    }

    @And("User checks that add to bag popup visible")
    public void checkAddToBagPopupVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToBagPopup());
        Assert.assertTrue(productPage.isAddToBagPopupVisible());
    }

    @And("User clicks main page button")
    public void clickMainPageButton() {
        productPage.clickMainPageButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that amount of products in shopping bag are {string}")
    public void checkThatAmountOfProductsInShoppingBag(final String expectedAmount) {
        Assert.assertEquals(homePage.getAmountOfProductsInShoppingBag(), expectedAmount);
    }

    @And("User clicks Men button")
    public void clickMenButton() {
        homePage.clickMenButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
    }

    @And("User moves to Sale button")
    public void clickSaleButton() {
        homePage.moveToSaleButton();
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSalePopUp());
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSaleSunglassesButton());
    }

    @And("User checks Sale pop up visibility")
    public void checkSalePopUpVisibility() {
        Assert.assertTrue(homePage.isSalePopUpVisible());
    }

    @And("User clicks Sale sunglasses button")
    public void clickSaleSunglassesButton() {
        homePage.clickSaleSunglassesButton();
        saleSunglassesPage = pageFactoryManager.getSaleSunglassesPage();
        saleSunglassesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks sale products have saleIcon")
    public void checkSaleProductsHaveSaleIcon() {
        saleSunglassesPage.checkSaleProductListHasSaleIcon();
    }

    @And("User clicks 'Sign In' button")
    public void clickSignInButton() {
        homePage.clickSignInButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInPopUp());
    }

    @And("User checks sign in popup visibility")
    public void checkSignInPopupVisibility() {
        Assert.assertTrue(homePage.isSignInPopUpVisible());
    }

    @And("User clicks 'Sign In' button at sign in popup")
    public void clickSignInButtonAtSignInPopup() {
        homePage.clickSignInButtonAtPopUp();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User checks filter’s field visibility")
    public void checkFilterSFieldVisibility() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertTrue(searchResultsPage.isFiltersFieldVisible());
    }

    @And("User clicks 'SaleNewSeason' filter field")
    public void clickSaleNewSeasonFilterField() {
        searchResultsPage.clickFilterFieldButton();
    }

    @And("User clicks 'NewSeason' button")
    public void clickNewSeasonButton() {
        searchResultsPage.clickFilterButton();
    }

    @And("User checks email and password fields visibility")
    public void checkEmailFieldVisibility() {
        Assert.assertTrue(signInPage.isEmailFieldVisible());
        Assert.assertTrue(signInPage.isPasswordFieldVisible());
    }
    @Then("User checks that current url contains {string}")
    public void checkThatCurrentUrlContainsFilterWord(final String currUrl) {
        assertTrue(driver.getCurrentUrl().contains(currUrl));

    }



    @And("User enter {string}")
    public void enterEmail(final String email) {
        signInPage.enterEmail(email);
    }

    @And("User clicks 'Sign In' button at sign in page")
    public void clickSignInButtonAtSignInPage() {
        signInPage.clickSignInButton();
    }

    @And("User checks that email error is visible")
    public void checkThatEmailErrorIsVisible() {
        Assert.assertTrue(signInPage.isEmailErrorVisible());
    }

    @And("User checks that password error is visible")
    public void checkThatPasswordErrorIsVisible() {
        Assert.assertTrue(signInPage.isPasswordErrorVisible());
    }

    @And("User checks 'forgot password' button visibility")
    public void checkForgotPasswordButtonVisibility() {
        Assert.assertTrue(signInPage.isForgotPasswordVisible());
    }

    @When("User clicks 'Forgot password'")
    public void clickForgotPassword() {
        signInPage.clickForgotPasswordButton();
        forgotPasswordPage = pageFactoryManager.getForgotPasswordPage();
        forgotPasswordPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks email field visibility")
    public void checkEmailFieldVisibilityAtResetPasswordPage() {
        Assert.assertTrue(forgotPasswordPage.isEmailFieldVisible());
    }

    @And("User checks 'reset password' button visibility")
    public void checkResetPasswordButtonVisibility() {
        Assert.assertTrue(forgotPasswordPage.isResetPasswordButtonVisible());
    }

    @And("User clicks Save button on five product")
    public void clickSaveButtonOnFiveProduct() {
        searchResultsPage.scrollPageToElement(searchResultsPage.getSaveButtonOnFiveProduct());
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getSaveButtonOnFiveProduct());
        searchResultsPage.clickSaveButtonOnFiveProduct();
    }

    @And("User clicks Saved items button")
    public void clickSavedItemsButton() {
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.scrollPageToElement(searchResultsPage.getSavedItemsButton());
        searchResultsPage.clickSavedItemsButton();
        savedItemsPage = pageFactoryManager.getSavedItemsPage();
    }

    @And("User checks that amount of saved items are {string}")
    public void checkAmountOfSavedItems(String expectedAmount) {
        savedItemsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        savedItemsPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        savedItemsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, savedItemsPage.getImageItem());
        Assert.assertEquals(savedItemsPage.getAmountOfSavedItems(), expectedAmount);
    }

    @And("User checks that message saying that no results is shown")
    public void userChecksNoResultsMessageIsShown() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.isNoSearchResultsMessageShown());
    }

    @Then("User checks that amount of products in search page are {string}")
    public void checkThatAmountOfProductsInSearchPageAreAmountOfElements(final String amountOfElements) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        assertEquals(Integer.parseInt(amountOfElements), searchResultsPage.getAmountOfProducts());
    }
}
