package pageHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageHaloOglasi extends BaseTestHaloOglasi {

    public HomePageHaloOglasi(){
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[contains(text(),\"Uloguj se\")]")
    WebElement logInButton;

    public void logInButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(logInButton));
        logInButton.click();
    }
}
