package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedItemsPage extends BasePage {
    @FindBy(xpath = "//div[@class='itemCount_3vWat']")
    private WebElement amountOfItems;
    @FindBy(xpath = "//div[@class='itemCount_3vWat']")
    private WebElement imageItem;

    public WebElement getImageItem() {
        return imageItem;
    }

    public String getAmountOfSavedItems() {
        return amountOfItems.getText();
    }

    public SavedItemsPage(WebDriver driver) {
        super(driver);
    }
}
