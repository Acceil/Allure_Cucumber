package appline.stepdefs;

import appline.pages.MainPage;
import io.cucumber.java.en.When;

public class MainPageSteps {
    private final MainPage mainPage = new MainPage();

    @When("Переходим во Вклады")
    public void toContributions() {
        mainPage.goToContributions();
    }
}
