package pageAutomationPractice1;

import baseAutomationPractice1.BaseTestAutomationPractice1;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchItemAddingToCart extends BaseTestAutomationPractice1 {

    public SearchItemAddingToCart() { PageFactory.initElements(driver, this); }

    @FindBy(id = "search_query_top")
    WebElement searchField;
    @FindBy(className = "icon-th-list")
    WebElement listViewButton;
    @FindBy(xpath = "(//span[contains(text(), 'Add to cart')])[2]")
    WebElement printedDressAddingToCart;
    @FindBy(xpath = "//span[contains(text(), 'Proceed to checkout')]")
    WebElement proceedToCheckoutButton;

    public SearchItemAddingToCart searchFieldInput(String searchEntry){
        wdWait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys(searchEntry);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
    public SearchItemAddingToCart listViewButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(listViewButton));
        listViewButton.click();
        return this;
    }
    public SearchItemAddingToCart printedDressAddingToCartClick(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        wdWait.until(ExpectedConditions.elementToBeClickable(printedDressAddingToCart));
        printedDressAddingToCart.click();
        return this;
    }
    public SearchItemAddingToCart proceedToCheckoutButtonClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        return this;
    }

}

