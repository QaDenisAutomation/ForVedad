package pageHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserProfilePageHaloOglasi extends BaseTestHaloOglasi {

    public UserProfilePageHaloOglasi(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header-label")
    WebElement mojProfil;
    @FindBy(className = "user-display-name")
    WebElement nameUserCheck;
    @FindBy(className = "user-email")
    WebElement emailUserCheck;

    public void mojProfil(){
        wdWait.until(ExpectedConditions.elementToBeClickable(mojProfil));
        actions.moveToElement(mojProfil).perform();
    }

    public boolean nameUserCheck(){
        wdWait.until(ExpectedConditions.visibilityOf(nameUserCheck));
        return nameUserCheck.isDisplayed();
    }
    public String nameUserCheckGetText(){
        return nameUserCheck.getText();
    }
    public boolean emailUserCheck(){
        wdWait.until(ExpectedConditions.visibilityOf(emailUserCheck));
        return emailUserCheck.isDisplayed();
    }
    public String emailUserCheckGetText(){
        return emailUserCheck.getText();
    }
}
