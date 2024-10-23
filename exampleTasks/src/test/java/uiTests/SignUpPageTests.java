package uiTests;

import config.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.SignUpPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.testingisgood.constants.ElementsVisibilityParameters.NO;
import static ru.testingisgood.constants.ElementsVisibilityParameters.YES;
import static ru.testingisgood.constants.PlatformLinks.SIGN_UP_PAGE;

public class SignUpPageTests extends BaseUiTest {

    public static final String validUserEmail = "tester112344@ya.ru";

    @BeforeEach
    public void openPage() {
        open(SIGN_UP_PAGE);
        new SignUpPage().isWelcomeTextDisplayed();
    }

    @Test
    @DisplayName("Проверка активации кнопки Continue при валидном значении в поле email")
    public void checkContinueButtonIsEnabledAfterInputValidDataInEmail() {
        new SignUpPage()
                .setDataFromEmailInput(validUserEmail)
                .isInvalidEmailErrorDisplayed(NO)
                .isContinueButtonEnabled(YES);
    }
}
