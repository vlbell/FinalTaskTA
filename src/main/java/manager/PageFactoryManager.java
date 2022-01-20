package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public ShoppingBagPage getShoppingBagPage() {
        return new ShoppingBagPage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public ForgotPasswordPage getForgotPasswordPage() {
        return new ForgotPasswordPage(driver);
    }

    public SaleSunglassesPage getSaleSunglassesPage() {
        return new SaleSunglassesPage(driver);
    }

    public SavedItemsPage getSavedItemsPage() {
        return new SavedItemsPage(driver);
    }
}
