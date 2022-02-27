package testHaloOglasi;

import baseHaloOglasi.BaseTestHaloOglasi;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import page.HaloOglasiRegistration;
import pageHaloOglasi.*;
import pageYopmail.HomePageYopmail;
import pageYopmail.InboxPageYopmail;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HaloOglasiTest extends BaseTestHaloOglasi {

    HomePageHaloOglasi homePageHaloOglasi;
    LoginPageHaloOglasi loginPageHaloOglasi;
    HaloOglasiRegistration haloOglasiRegistration;
    RegistrationPageHaloOglasi registrationPageHaloOglasi;
    SuccessfulRegistrationHaloOglasiPage successfulRegistrationHaloOglasiPage;
    HomePageYopmail homePageYopmail;
    InboxPageYopmail inboxPageYopmail;
    UserProfilePageHaloOglasi userProfilePageHaloOglasi;

    Random random = new Random();
    String korisnickoIme = "duquaumossomi-" + random.nextInt(999999);
    String korisnickiEmail = korisnickoIme + "@yopmail.com";
    String korisnickiPassword = "KobeBryant" + random.nextInt(999999);
    String successfulRegistrationMessage = "Registracija je uspela!";
    String successfulActivationMessage = "Vaš nalog je uspešno aktiviran!";


    @Before
    public void setUpHaloOglasiTest() {

        homePageHaloOglasi = new HomePageHaloOglasi();
        loginPageHaloOglasi = new LoginPageHaloOglasi();
        haloOglasiRegistration = new HaloOglasiRegistration();
        registrationPageHaloOglasi = new RegistrationPageHaloOglasi();
        successfulRegistrationHaloOglasiPage = new SuccessfulRegistrationHaloOglasiPage();
        homePageYopmail = new HomePageYopmail();
        inboxPageYopmail = new InboxPageYopmail();
        userProfilePageHaloOglasi = new UserProfilePageHaloOglasi();
    }

    @Test
    public void haloOglasiRegistrationTest() throws InterruptedException {

        homePageHaloOglasi.logInButton();
        loginPageHaloOglasi.registrujSeButton();
        registrationPageHaloOglasi
                .fizickoLiceCheckbox()
                .korisnickoImeInputField(korisnickoIme)
                .emailInputField(korisnickiEmail)
                .passwordInputField(korisnickiPassword)
                .confirmPasswordInputField(korisnickiPassword)
                .registrujMeButton();
        assertTrue(successfulRegistrationHaloOglasiPage.uspjesnaRegistracijaMessage());
        assertEquals(successfulRegistrationMessage, successfulRegistrationHaloOglasiPage.uspjesnaRegistracijaMessageGetText());
        driver.get("https://yopmail.com/en/");
        homePageYopmail.yopMailEmailInputField(korisnickiEmail);
        homePageYopmail.yopMailEmailInputFieldKeyboardKeys(Keys.ENTER);
        Thread.sleep(15000);
        inboxPageYopmail.refreshButton();
        driver.switchTo().frame("ifmail");
        inboxPageYopmail.activateAccountButton();
        successfulRegistrationHaloOglasiPage.switchToNewTab(1);
        assertTrue(successfulRegistrationHaloOglasiPage.activateMessageSuccess());
        assertEquals(successfulActivationMessage, successfulRegistrationHaloOglasiPage.activateMessageSuccessGetText());
        successfulRegistrationHaloOglasiPage.prijavaDugme();
        loginPageHaloOglasi
                .userName(korisnickiEmail)
                .userPassword(korisnickiPassword)
                .ulogujMeButton();
        Thread.sleep(5000);
        userProfilePageHaloOglasi.mojProfil();
        assertTrue(userProfilePageHaloOglasi.nameUserCheck());
        assertEquals(korisnickoIme,
                userProfilePageHaloOglasi.nameUserCheckGetText());
        assertTrue(userProfilePageHaloOglasi.emailUserCheck());
        assertEquals("email: " + korisnickiEmail,
                userProfilePageHaloOglasi.emailUserCheckGetText());
        }
    }

