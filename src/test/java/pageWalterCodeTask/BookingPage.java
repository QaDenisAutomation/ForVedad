package pageWalterCodeTask;

import baseWalterCodeTask.BaseTestWalterCode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPage extends BaseTestWalterCode {

    public BookingPage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[text() = \"Book this room\"])[2]")
    WebElement bookThisRoomButton;
    @FindBy(xpath = "//a[text() = \"09\"]")
    WebElement day13;
    @FindBy(xpath = "//a[text() = \"11\"]")
    WebElement day17;
    @FindBy(name = "firstname")
    WebElement firstNameInputField;
    @FindBy(name = "lastname")
    WebElement lastNameInputField;
    @FindBy(name = "email")
    WebElement emailInputField;
    @FindBy(name = "phone")
    WebElement phoneInputField;
    @FindBy(xpath = "//button[text() = \"Next\"]")
    WebElement nextButton;
    @FindBy(css = ".btn.btn-outline-primary.float-right.book-room")
    WebElement finalBookRoomButton;
    @FindBy(css = ".alert.alert-danger")
    WebElement unsuccessfulAlertBookMessage;


    public BookingPage selectingBookingDate() {
        //wdWait.until(ExpectedConditions.elementToBeClickable(day13));
        //wdWait.until(ExpectedConditions.elementToBeClickable(day17));
        //actions.dragAndDrop(day13, day17).perform();
        actions.moveToElement(day13).clickAndHold().moveToElement(day17).release().perform();
        //actions.dragAndDrop(day13,day17).build().perform();
        //actions.moveToElement(day14).pause(10).clickAndHold(day14).pause(1).moveByOffset(1,0).moveToElement(day17).moveByOffset(1,0).pause(1).release().perform();
        //actions.clickAndHold(day14).perform();
        //actions.moveToElement(day17).release().perform();
        // actions.moveToElement(day14).clickAndHold().moveToElement(day17).release().perform();
        // actions.click(day14).keyDown(Keys.CONTROL).click(day17).keyUp(Keys.CONTROL).build().perform();

        return this;
    }

    public BookingPage bookThisRoomButtonClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(bookThisRoomButton));
        bookThisRoomButton.click();
        return this;
    }

    public BookingPage firstNameInputField(String firstname) {
        wdWait.until(ExpectedConditions.visibilityOf(firstNameInputField));
        firstNameInputField.clear();
        firstNameInputField.sendKeys(firstname);
        return this;
    }

    public BookingPage lastNameInputField(String lastname) {
        wdWait.until(ExpectedConditions.visibilityOf(lastNameInputField));
        lastNameInputField.clear();
        lastNameInputField.sendKeys(lastname);
        return this;
    }

    public BookingPage emailInputField(String email) {
        wdWait.until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.clear();
        emailInputField.sendKeys(email);
        return this;
    }

    public BookingPage phoneInputField(String phone) {
        wdWait.until(ExpectedConditions.visibilityOf(phoneInputField));
        phoneInputField.clear();
        phoneInputField.sendKeys(phone);
        return this;
    }

    public BookingPage finalBookRoomButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(finalBookRoomButton));
        finalBookRoomButton.click();
        return this;
    }

    public BookingPage nextButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        return this;
    }

    public boolean unsuccessfulAlertBookMessage() {
        wdWait.until(ExpectedConditions.visibilityOf(unsuccessfulAlertBookMessage));
        return unsuccessfulAlertBookMessage.isDisplayed();
    }

    public String unsuccessfulAlertBookMessageGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(unsuccessfulAlertBookMessage));
        return unsuccessfulAlertBookMessage.getText();

    }
}
