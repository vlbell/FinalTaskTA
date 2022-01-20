package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='ERlP6Bx']")
    private List<WebElement> searchResults;
    @FindBy(xpath = "//span[@class='_30BqGyh']//ancestor::button")
    private List<WebElement> saveButtonList;
    @FindBy(xpath = "//a[@icontype='heartUnfilled']")
    private WebElement savedItemsButton;
    @FindBy(xpath = "//h2[contains(text(), 'NOTHING MATCHES')]")
    private WebElement noResultsMessage;
    @FindBy(xpath = "//div[@aria-label='Filters']")
    private WebElement filtersField;
    @FindBy(xpath = "//div[contains(text(),'Sale / New' )]")
    private WebElement filterFieldButton;
    @FindBy(xpath = "//div[@data-auto-id='refinementItem']//div[contains(text(),'New Season' )]")
    private WebElement filterButton;
    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> amountOfProducts;

    public void clickFilterButton() {
        filterButton.click();
    }

    public boolean isNoSearchResultsMessageShown() {
        return noResultsMessage.isDisplayed();
    }

    public void clickFilterFieldButton() {
        filterFieldButton.click();
    }

    public void clickSearchResultsOnFirstProduct() {
        searchResults.get(0).click();
    }

    public boolean isFiltersFieldVisible() {
        return filtersField.isDisplayed();
    }

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSaveButtonOnFiveProduct() {
        return saveButtonList.get(4);
    }

    public void clickSaveButtonOnFiveProduct() {
        saveButtonList.get(4).click();
    }

    public WebElement getSavedItemsButton() {
        return savedItemsButton;
    }

    public List<WebElement> getSearchResultsList() {
        return amountOfProducts;
    }

    public int getAmountOfProducts() {
        return getSearchResultsList().size();
    }

    public void clickSavedItemsButton() {
        savedItemsButton.click();
    }

}
