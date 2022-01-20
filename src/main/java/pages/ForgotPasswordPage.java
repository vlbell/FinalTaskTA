package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {
    @FindBy(xpath = "//input[@class='qa-email-textbox']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement restPasswordButton;

    public boolean isEmailFieldVisible() {
        return emailField.isDisplayed();
    }

    public boolean isResetPasswordButtonVisible() {
        return restPasswordButton.isDisplayed();
    }

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
}
