package uiTests;

import config.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SignInPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.testingisgood.constants.ElementsVisibilityParameters.YES;
import static ru.testingisgood.constants.PlatformLinks.SIGN_IN_PAGE;


public class SignInPageTests extends BaseUiTest {

    public static final String INVALID_USER_LOGIN = "test";
    public static final String INVALID_USER_PASSWORD = "root";

    @BeforeEach
    public void openPage() {
        open(SIGN_IN_PAGE);
        new SignInPage().isSignInWelcomeTextDisplayed();
    }

    @Test
    @DisplayName("Проверка отображения ошибки при попытки авторизации с невалидной парой логин+пароль")
    public void checkErrorMessageDisplayedAfterAuthWithInvalidCredentials() {
        new SignInPage()
                .signInOperation(INVALID_USER_LOGIN, INVALID_USER_PASSWORD)
                .isErrorMessageDisplayed(YES);
    }
}
