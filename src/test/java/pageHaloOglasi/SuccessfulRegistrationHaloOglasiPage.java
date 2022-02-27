package pageHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class SuccessfulRegistrationHaloOglasiPage extends BaseTestHaloOglasi {

    public SuccessfulRegistrationHaloOglasiPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),\"Registracija je uspela!\")]")
    WebElement uspjesnaRegistracijaMessage;
    @FindBy(xpath = "//span[contains(text(),\"Vaš nalog je uspešno aktiviran!\")]")
    WebElement activateMessageSuccess;
    @FindBy(xpath = "//a[contains(text(),\"Prijava\")]")
    WebElement prijavaButton;

    public boolean uspjesnaRegistracijaMessage() {
        wdWait.until(ExpectedConditions.visibilityOf(uspjesnaRegistracijaMessage));
        return uspjesnaRegistracijaMessage.isDisplayed();
    }

    public String uspjesnaRegistracijaMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(uspjesnaRegistracijaMessage));
        return uspjesnaRegistracijaMessage.getText();
    }

    public boolean activateMessageSuccess() {
        wdWait.until(ExpectedConditions.visibilityOf(activateMessageSuccess));
        return activateMessageSuccess.isDisplayed();
    }

    public String activateMessageSuccessGetText() {
        return activateMessageSuccess.getText();
    }

    public void prijavaDugme() {
        wdWait.until(ExpectedConditions.elementToBeClickable(prijavaButton));
        prijavaButton.click();
    }
    public void switchToNewTab(int tabNumber){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String > numberOfTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(numberOfTabs.get(tabNumber));
    }
}
