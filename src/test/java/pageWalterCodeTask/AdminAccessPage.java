package pageWalterCodeTask;

import baseWalterCodeTask.BaseTestWalterCode;
import javafx.scene.control.CheckBox;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageHaloOglasi.RegistrationPageHaloOglasi;

import javax.swing.*;
import java.util.ArrayList;

public class AdminAccessPage extends BaseTestWalterCode {

    public AdminAccessPage(){

        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "roomNumber")
    WebElement roomNumber;
    @FindBy(id = "type")
    WebElement typeDropDown;
    @FindBy(id = "accessible")
    WebElement accessibleDropDown;
    @FindBy(id = "roomPrice")
    WebElement roomPrice;
    @FindBy(id = "wifiCheckbox")
    WebElement wifiCheckbox;
    @FindBy(id = "tvCheckbox")
    WebElement tvCheckbox;
    @FindBy(id = "safeCheckbox")
    WebElement safeCheckbox;
    @FindBy(id = "viewsCheckbox")
    WebElement viewsCheckbox;
    @FindBy(id = "createRoom")
    WebElement createRoomButton;

    public AdminAccessPage roomNumber(String roomNo){
        wdWait.until(ExpectedConditions.visibilityOf(roomNumber));
        roomNumber.clear();
        roomNumber.sendKeys(roomNo);
        return this;
    }
    public AdminAccessPage typeDropDown(){
        wdWait.until(ExpectedConditions.visibilityOf(typeDropDown));
        Select drop = new Select(typeDropDown);
        drop.selectByIndex(2);
        return this;
    }
    public AdminAccessPage accessibleDropDown(){
        wdWait.until(ExpectedConditions.visibilityOf(accessibleDropDown));
        Select drop = new Select(accessibleDropDown);
        drop.selectByIndex(1);
        return this;
    }
    public AdminAccessPage roomPrice(String price){
        wdWait.until(ExpectedConditions.visibilityOf(roomPrice));
        roomPrice.clear();
        roomPrice.sendKeys(price);
        return this;
    }
    public AdminAccessPage tvCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(tvCheckbox));
        if (!tvCheckbox.isSelected()) {
            tvCheckbox.click();
        }
        return this;
    }
    public AdminAccessPage safeCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(safeCheckbox));
        if (!safeCheckbox.isSelected()) {
            safeCheckbox.click();
        }
        return this;
    }
    public AdminAccessPage wifiCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(wifiCheckbox));
        if (!wifiCheckbox.isSelected()) {
            wifiCheckbox.click();
        }
        return this;
    }
    public AdminAccessPage viewsCheckbox() {
        wdWait.until(ExpectedConditions.elementToBeClickable(viewsCheckbox));
        if (!viewsCheckbox.isSelected()) {
            viewsCheckbox.click();
        }
        return this;
    }
    public AdminAccessPage createRoomButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(createRoomButton));
        createRoomButton.click();
        return this;
    }
    public AdminAccessPage openRoomBookingPage(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        WebDriver window = driver.switchTo().window(tabs.get(1));
        driver.get("https://automationintesting.online/#/");
        return this;
    }
}
