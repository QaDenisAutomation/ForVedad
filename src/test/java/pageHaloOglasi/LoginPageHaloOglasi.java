package pageHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageHaloOglasi extends BaseTestHaloOglasi {

    public LoginPageHaloOglasi(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".no-account-reg-link")
    WebElement registrujSeButton;
    @FindBy (id = "EMailOrUsername")
    WebElement userName;
    @FindBy(id = "Password")
    WebElement userPassword;
    @FindBy(css = ".btn-main.login-button.login-user")
    WebElement ulogujMeButton;

    public LoginPageHaloOglasi registrujSeButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(registrujSeButton));
        registrujSeButton.click();
        return this;
    }

    public LoginPageHaloOglasi userName(String username){
        wdWait.until(ExpectedConditions.visibilityOf(userName));
        userName.clear();
        userName.sendKeys(username);
        return this;
    }
    public LoginPageHaloOglasi userPassword(String userpassword){
        wdWait.until(ExpectedConditions.visibilityOf(userPassword));
        userPassword.clear();
        userPassword.sendKeys(userpassword);
        return this;
    }
    public LoginPageHaloOglasi ulogujMeButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(ulogujMeButton));
        ulogujMeButton.click();
        return this;
    }
}
