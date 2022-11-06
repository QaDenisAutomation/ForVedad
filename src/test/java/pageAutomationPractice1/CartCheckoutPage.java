package pageAutomationPractice1;

import baseAutomationPractice1.BaseTestAutomationPractice1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartCheckoutPage extends BaseTestAutomationPractice1 {

    public CartCheckoutPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Proceed to checkout")
    WebElement proceedButtonToSignInSection;
    @FindBy(id = "email")
    WebElement emailLoginField;
    @FindBy(id = "passwd")
    WebElement passwordLoginField;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;
    @FindBy(name = "processAddress")
    WebElement proceedButtonToShippingSection;
    @FindBy(id = "uniform-cgv")
    WebElement checkboxTermsAndConditions;
    @FindBy(name = "processCarrier")
    WebElement proceedButtonToPaymentSection;
    @FindBy(className = "bankwire")
    WebElement bankWirePaymentbutton;
    @FindBy(className = "page-subheading")
    WebElement paymentBankWireInformation;
    @FindBy(xpath = "//span[contains(text(), 'I confirm my order')]")
    WebElement confirmingOrderButton;
    @FindBy(className = "cheque-indent")
    WebElement orderConfirmation;

    public CartCheckoutPage proceedButtonToSignInSectionClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedButtonToSignInSection));
        proceedButtonToSignInSection.click();
        return this;
    }

    public CartCheckoutPage emailLoginField(String email) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.visibilityOf(emailLoginField));
        emailLoginField.clear();
        emailLoginField.sendKeys(email);
        return this;
    }

    public CartCheckoutPage passwordLoginField(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordLoginField));
        passwordLoginField.clear();
        passwordLoginField.sendKeys(password);
        return this;
    }

    public CartCheckoutPage signInButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return this;
    }

    public CartCheckoutPage proceedButtonToShippingSectionClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedButtonToShippingSection));
        proceedButtonToShippingSection.click();
        return this;
    }

    public CartCheckoutPage checkboxTermsAndConditionsClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(checkboxTermsAndConditions));
        //if (!checkboxTermsAndConditions.isSelected()) {
        checkboxTermsAndConditions.click();
        // }
        return this;
    }

    public CartCheckoutPage proceedButtonToPaymentSectionClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedButtonToPaymentSection));
        proceedButtonToPaymentSection.click();
        return this;
    }

    public CartCheckoutPage bankWirePaymentbuttonClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(bankWirePaymentbutton));
        bankWirePaymentbutton.click();
        return this;
    }

    public boolean paymentBankWireInformation() {
        wdWait.until(ExpectedConditions.visibilityOf(paymentBankWireInformation));
        return paymentBankWireInformation.isDisplayed();
    }

    public String paymentBankWireInformationGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(paymentBankWireInformation));
        return paymentBankWireInformation.getText();
    }

    public CartCheckoutPage confirmingOrderButtonClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(confirmingOrderButton));
        confirmingOrderButton.click();
        return this;
    }

    public boolean orderConfirmation() {
        wdWait.until(ExpectedConditions.visibilityOf(orderConfirmation));
        return orderConfirmation.isDisplayed();
    }

    public String orderConfirmationGetText() {
        wdWait.until(ExpectedConditions.visibilityOf(orderConfirmation));
        return orderConfirmation.getText();
    }
}