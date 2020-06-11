package appline.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='service__title']/a[@href='/contributions/']")
    WebElement toContributions;

    public void goToContributions() {
        moveToElement(toContributions);
        waitUntilClickable(toContributions).click();
    }
}