package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {
        var addCardButton = getUIMappingByKey("trello.boardPage.addCartToListButton");
        var button = driver.findElement(By.xpath(String.format(addCardButton, cardName)));
        button.click();
        var cardTextArea = getUIMappingByKey("trello.boardPage.cardTitle");
        var textBox = driver.findElement(By.xpath(String.format(cardTextArea, cardName)));
        textBox.sendKeys("Heelo");
    }

    public void moveCardToList(String cardName, String listName) {
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }
}
