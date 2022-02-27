package pageYopmail;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPageYopmail extends BaseTestHaloOglasi {

    public InboxPageYopmail() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "refresh")
    WebElement refreshButton;
    @FindBy(xpath = "//strong[contains(text(),\"Aktiviraj nalog\")]")
    WebElement activateAccountButton;

    public void refreshButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(refreshButton));
        refreshButton.click();
    }

    public void activateAccountButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(activateAccountButton));
        activateAccountButton.click();
    }
}