package uiTests;

import config.BaseUiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObject.SignUpPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.testingisgood.constants.ElementsVisibilityParameters.NO;
import static ru.testingisgood.constants.ElementsVisibilityParameters.YES;
import static ru.testingisgood.constants.PlatformLinks.SIGN_UP_PAGE;

public class SignUpPageTestsParametrized extends BaseUiTest {

    @BeforeEach
    public void openPage() {
        open(SIGN_UP_PAGE);
        new SignUpPage().isWelcomeTextDisplayed();
    }

    @ParameterizedTest(name = "Проверка отображения текста ошибки о невалидном значении в поле email ({0})")
    @ValueSource(strings = {"test@", "test@ya", "test@ta."})
    public void currentErrorMessageTextAfterInputInvalidEmail(String email) {
        new SignUpPage()
                .setDataFromEmailInput(email)
                .isInvalidEmailErrorDisplayed(YES)
                .isContinueButtonEnabled(NO);
    }

}
