import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BootstrapModal extends BasePage{
    public BootstrapModal(WebDriver driver){this.driver=driver;}

    public String url = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";
    public By launchButton = By.xpath("//div[div[text()=\"Single Modal Example\"]]//a");
    public By modalBody = By.className("modal-body");
    public By modalClose = By.xpath("//a[text()=\"Close\"]");

    public void Navigate(){
        driver.navigate().to(url);
    }
    public void OpenModal(){
        WebElement button = driver.findElement(launchButton);
        button.click();
    }
    public String GetTextFromModal(){
        WebElement result = driver.findElement(modalBody);
        String text = result.getText();
        return text;
    }
    public void CloseModal(){
        WebElement closeButton = driver.findElement(modalClose);
        closeButton.click();
    }
}
