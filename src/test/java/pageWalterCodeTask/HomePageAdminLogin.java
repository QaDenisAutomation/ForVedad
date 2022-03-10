package pageWalterCodeTask;

import baseWalterCodeTask.BaseTestWalterCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageAdminLogin extends BaseTestWalterCode {

    public HomePageAdminLogin() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary")
    WebElement letMeHackButton;
    @FindBy(id = "username")
    WebElement userNameInputField;
    @FindBy(id = "password")
    WebElement passwordInputField;
    @FindBy(id = "doLogin")
    WebElement loginButton;

    public HomePageAdminLogin letMeHackButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(letMeHackButton));
        letMeHackButton.click();
        return this;
    }

    public HomePageAdminLogin userNameInputField(String username){
        wdWait.until(ExpectedConditions.visibilityOf(userNameInputField));
        userNameInputField.clear();
        userNameInputField.sendKeys(username);
        return this;
    }
    public HomePageAdminLogin passwordInputField(String password){
        wdWait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
        return this;
    }
    public HomePageAdminLogin loginButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }

}
