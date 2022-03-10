package testWalterCodeTask;

import baseWalterCodeTask.BaseTestWalterCode;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pageWalterCodeTask.AdminAccessPage;
import pageWalterCodeTask.BookingPage;
import pageWalterCodeTask.HomePageAdminLogin;

public class TestRunWalterCode extends BaseTestWalterCode {

        HomePageAdminLogin homePageAdminLogin;
        AdminAccessPage adminAccessPage;
        BookingPage bookingPage;

        @Before
        public void SetUpTestRun(){

            homePageAdminLogin = new HomePageAdminLogin();
            adminAccessPage = new AdminAccessPage();
            bookingPage = new BookingPage();

        }

        @Test
        public void testCreateAndBookRooms(){

            homePageAdminLogin
                    .letMeHackButtonClick()
                    .userNameInputField("admin")
                    .passwordInputField("password")
                    .loginButton();
            adminAccessPage
                    .roomNumber("102")
                    .typeDropDown()
                    .accessibleDropDown()
                    .roomPrice("200")
                    .wifiCheckbox()
                    .safeCheckbox()
                    .tvCheckbox()
                    .viewsCheckbox()
                    .createRoomButtonClick()
                    .openRoomBookingPage();
            bookingPage
                    .bookThisRoomButtonClick()
                    .firstNameInputField("Denis")
                    .lastNameInputField("Denza")
                    .emailInputField("den@den.den")
                    .phoneInputField("1234567891235")
                    .selectingBookingDate()
                    .finalBookRoomButton();
            assertTrue(bookingPage.unsuccessfulAlertBookMessage());
            assertEquals("must not be null\n" +
                    "must not be null", bookingPage.unsuccessfulAlertBookMessageGetText());

        }
}
