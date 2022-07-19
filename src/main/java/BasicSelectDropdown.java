import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicSelectDropdown extends BasePage {
    public BasicSelectDropdown(WebDriver driver) {this.driver=driver;}

    public String url = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    public By dropDownMenu = By.id("select-demo");
    public By lastDay = By.xpath("//*[@id=\"select-demo\"]/option[text()=\"Saturday\"]");
    public By textResult = By.cssSelector(".selected-value");

    public void Navigate(){
        driver.navigate().to(url);
    }

    public void SelectLastDay(){
        WebElement menu = driver.findElement(dropDownMenu);
        menu.click();
        WebElement saturday = driver.findElement(lastDay);
        saturday.click();
    }

    public String GetResult(){
        WebElement result = driver.findElement(textResult);
        String text = result.getText();
        return text;
    }
}
