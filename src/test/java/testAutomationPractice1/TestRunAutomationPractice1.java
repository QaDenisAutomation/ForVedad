package testAutomationPractice1;

import baseAutomationPractice1.BaseTestAutomationPractice1;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pageAutomationPractice1.CartCheckoutPage;
import pageAutomationPractice1.SearchItemAddingToCart;

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

}
