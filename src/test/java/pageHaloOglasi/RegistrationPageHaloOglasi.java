package pageHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPageHaloOglasi extends BaseTestHaloOglasi {

    public RegistrationPageHaloOglasi(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[contains(text(),\"Fizičkog lica\")]")
    WebElement fizickoLiceCheckbox;
    @FindBy(id = "UserName")
    WebElement korisnickoImeInputField;
    @FindBy(id = "Email")
    WebElement emailInputField;
    @FindBy(id = "Password")
    WebElement passwordInputField;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordInputField;
    @FindBy(css = ".button-reg.save.save-entity.person-face.btn-main")
    WebElement registrujMeButton;

    public RegistrationPageHaloOglasi fizickoLiceCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(fizickoLiceCheckbox));
        if (!fizickoLiceCheckbox.isSelected()) {
            fizickoLiceCheckbox.click();
        }
        return this;
    }

    public RegistrationPageHaloOglasi korisnickoImeInputField(String ime) {
        wdWait.until(ExpectedConditions.visibilityOf(korisnickoImeInputField));
        korisnickoImeInputField.clear();
        korisnickoImeInputField.sendKeys(ime);
        return this;
    }

    public RegistrationPageHaloOglasi emailInputField(String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.clear();
        emailInputField.sendKeys(email);
        return this;
    }

    public RegistrationPageHaloOglasi passwordInputField(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        return this;
    }

    public RegistrationPageHaloOglasi confirmPasswordInputField(String confirmPassword) {
        wdWait.until(ExpectedConditions.visibilityOf(confirmPasswordInputField));
        confirmPasswordInputField.clear();
        confirmPasswordInputField.sendKeys(confirmPassword);
        return this;
    }

    public RegistrationPageHaloOglasi registrujMeButton() {
        wdWait.until(ExpectedConditions.visibilityOf(registrujMeButton));
        registrujMeButton.click();
        return this;
    }
}
