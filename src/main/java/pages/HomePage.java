package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@data-testid='header']")
    private WebElement header;
    @FindBy(xpath = "//footer[@class='QgXuFU4']")
    private WebElement footer;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;
    @FindBy(xpath = "//button[@class='kH5PAAC _1KRfEms']")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@type='accountUnfilled']")
    private WebElement signInButton;
    @FindBy(xpath = "//span[@type='bagUnfilled']")
    private WebElement shoppingBagButton;
    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement shoppingBagProductsCount;
    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement menButton;
    @FindBy(xpath = "//nav[@class='_3EAPxMS']//span[text()='Sale']")
    private WebElement saleButton;
    @FindBy(xpath = "//div[@id='c223e1a9-dc0f-42f5-afca-5cf5988c716b']")
    private WebElement salePopUp;
    @FindBy(xpath = "//div[@id='c223e1a9-dc0f-42f5-afca-5cf5988c716b']//a[text()='SALE Sunglasses']")
    private WebElement saleSunglassesButton;
    @FindBy(xpath = "//div[@class='_10AVfLf _23LM9fc']")
    private WebElement signInPopUp;
    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButtonAtPopUp;

    public void moveToSaleButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(saleButton).build().perform();
    }

    public WebElement getSalePopUp() {
        return salePopUp;
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isHeaderVisible() {
        return header.isDisplayed();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isFooterVisible() {
        return footer.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public boolean isSignInButtonVisible() {
        return signInButton.isDisplayed();
    }

    public boolean isSalePopUpVisible() {
        return salePopUp.isDisplayed();
    }

    public void clickShoppingBagButton() {
        shoppingBagButton.click();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }


    public String getAmountOfProductsInShoppingBag() {
        return shoppingBagProductsCount.getText();
    }

    public boolean isShoppingBagButtonVisible() {
        return shoppingBagButton.isDisplayed();
    }

    public void clickMenButton() {
        menButton.click();
    }


    public WebElement getSaleSunglassesButton() {
        return saleSunglassesButton;
    }

    public void clickSaleSunglassesButton() {
        saleSunglassesButton.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignInPopUp() {
        return signInPopUp;
    }

    public boolean isSignInPopUpVisible() {
        return signInPopUp.isDisplayed();
    }

    public void clickSignInButtonAtPopUp() {
        signInButtonAtPopUp.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
