package pageYopmail;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageYopmail extends BaseTestHaloOglasi {

    public HomePageYopmail() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "ycptinput")
    WebElement yopMailEmailInputField;

    public void yopMailEmailInputField(String mailinatoremail) {
        wdWait.until(ExpectedConditions.visibilityOf(yopMailEmailInputField));
        yopMailEmailInputField.clear();
        yopMailEmailInputField.sendKeys(mailinatoremail);
    }
    public void yopMailEmailInputFieldKeyboardKeys(Keys button){
        wdWait.until(ExpectedConditions.visibilityOf(yopMailEmailInputField));
        yopMailEmailInputField.sendKeys(button);
    }
}