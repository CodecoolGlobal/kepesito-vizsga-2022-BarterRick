import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataListFilter extends BasePage {
    public DataListFilter(WebDriver driver) {
        this.driver = driver;
    }

    public String url = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    public By nameCards = By.xpath("//div[contains(@class,\"items\")]");
    public List<String> nameList;

    public void Navigate(){
        driver.navigate().to(url);
    }

    public List<String> GetNames(){
        List<WebElement> nameCardList;
        nameCardList = driver.findElements(nameCards);
        for (WebElement nameCard :nameCardList
             ) { WebElement card = nameCard.findElement(By.xpath("./h5"));
            String name = card.getText();
            name.replace("Name: ","");
            List<String> nameList = new ArrayList<>();
            nameList.add(name);
        }
        return nameList;
    }

}