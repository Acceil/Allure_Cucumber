package appline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContributionsPage extends BasePage {
    private static final String currency = "//span[contains(text(), '%s')]";
//    private static final String money = "//input[@name='%s']";
//    private static final String period = "//ul/li[contains(text(), '%s')]";

    @FindBy(xpath = "//div[contains(text(), 'месяц')]")
    WebElement monthList;

    @FindBy(xpath = "//input[@name='amount']")
    WebElement amount;

    @FindBy(xpath = "//input[@name='replenish']")
    WebElement replenish;

    @FindBy(xpath = "(//div[@class='jq-checkbox calculator__check'])[2]")
    WebElement checkBox;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement earned;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement replenished;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement result;

    @FindBy(xpath = "//div[@class='service__title']/a[@href='/contributions/']")
    WebElement toContributions;

    public void goToContributions() {
        moveToElement(toContributions);
        waitUntilClickable(toContributions).click();
    }

    public void chooseCurrency(String currencyName) {
        By locator = By.xpath(String.format(currency, currencyName));
        WebElement currencyEl = driver.findElement(locator);
        moveToElement(currencyEl);
        doubleClick(currencyEl);
    }

    public void input(String fieldName, String value) {
        switch (fieldName) {
            case "Сумма вклада":
                input(amount, value);
                break;

            case "Ежемесячное пополнение":
                input(replenish, value);
                break;

            case "На срок":
                monthList.click();
                monthList.findElement(By.xpath("//ul/li[contains(text(), '" + value + "')]")).click();
                break;

            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    private void input(WebElement field, String value) {
        moveToElement(field);
        waitUntilClickable(field).click();
        field.sendKeys(value);
        customWait();
    }

    public String getValues(String fieldName) {
        switch (fieldName) {
            case "Начислено %":
                return earned.getText();

            case "Пополнение за 9 месяцев":
                return replenished.getText();

            case "К снятию через 9 месяцев":
                return result.getText();
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void selectCheckBox() {
        waitUntilClickable(checkBox).click();
        customWait();
    }


//    public void input(String fieldName, String amount) {
//        By locator = By.xpath(String.format(money, fieldName));
//        WebElement price = driver.findElement(locator);
//        moveToElement(price);
//        waitUntilClickable(price).sendKeys(amount);
//    }


//    public void setPeriod(String month) {
//        waitUntilClickable(monthList).click();
//        By locator = By.xpath(String.format(period, month));
//        WebElement setMonth = driver.findElement(locator);
//        waitUntilClickable(setMonth).click();
//    }

//    public boolean checkSum(String calculationTitle, String expected){
//        customWait();
//        By locator = By.xpath(String.format(money, calculationTitle));
//        WebElement cash = driver.findElement(locator);
//        return cash.getText().equals(expected);
//    }
}
