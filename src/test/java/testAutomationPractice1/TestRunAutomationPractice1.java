package testAutomationPractice1;

import baseAutomationPractice1.BaseTestAutomationPractice1;
import static org.junit.Assert.*;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import pageAutomationPractice1.CartCheckoutPage;
import pageAutomationPractice1.SearchItemAddingToCart;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRunAutomationPractice1 extends BaseTestAutomationPractice1 {

        SearchItemAddingToCart searchItemAddingToCart;
        CartCheckoutPage cartCheckoutPage;

        @Before
        public void SetUpTestRun(){
            searchItemAddingToCart = new SearchItemAddingToCart();
            cartCheckoutPage = new CartCheckoutPage();
        }

        @Test
        public void BuyingProductSmokeTest(){

            searchItemAddingToCart
                    .searchFieldInput("dress")
                    .listViewButtonClick()
                    .printedDressAddingToCartClick()
                    .proceedToCheckoutButtonClick();

            cartCheckoutPage
                    .proceedButtonToSignInSectionClick()
                    .emailLoginField("duquaumossomi-3379@yopmail.com")
                    .passwordLoginField("Kobe8Bryant24")
                    .signInButtonClick()
                    .proceedButtonToShippingSectionClick()
                    .checkboxTermsAndConditionsClick()
                    .proceedButtonToPaymentSectionClick()
                    .bankWirePaymentbuttonClick();
            assertTrue(cartCheckoutPage.paymentBankWireInformation());
            assertEquals("BANK-WIRE PAYMENT.",cartCheckoutPage.paymentBankWireInformationGetText());
            cartCheckoutPage.confirmingOrderButtonClick();
            assertTrue(cartCheckoutPage.orderConfirmation());
            assertEquals("Your order on My Store is complete.",cartCheckoutPage.orderConfirmationGetText());
        }

        @Test
        public void checkingProductNumber() throws IOException {
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            driver.manage().window().setPosition(new Point(-2000, 0));

            List<WebElement> list1 = driver.findElements(By.cssSelector("ul.product_list.grid.row.homefeatured.tab-pane.active li"));
            assertEquals(list1.size(),6);
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(f, new File("C:/Users/Korisnik/Desktop/testscr.png"));
        }
}
