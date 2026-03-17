package Test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseUiTest {


    @Test
    @DisplayName("Transition bun button")
    @Description("Checking the transition to the bun button")
    public void testTransitionBunButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickBunButton();
        String text = mainConstructorPage.transitionBunButton();
        assertEquals ("Булки",text);
        System.out.println(text);
    }

    @Test
    @DisplayName("Transition sauce button")
    @Description("Checking the transition to the bun sauce")
    public void testTransitionSauceButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickSauceButton();
        String text = mainConstructorPage.transitionSauceButton();
        assertEquals ("Соусы",text);
        System.out.println(text);
    }

    @Test
    @DisplayName("Transition stuffing button")
    @Description("Checking the transition to the bun stuffing")
    public void testTransitionStuffingButton() {
        mainRegistrationPage.openPage();
        mainConstructorPage.clickStuffingButton();
        String text = mainConstructorPage.transitionStuffingButton();
        assertEquals ("Начинки",text);
        System.out.println(text);
    }
}
