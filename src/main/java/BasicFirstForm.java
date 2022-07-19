import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicFirstForm extends BasePage {
    public BasicFirstForm(WebDriver driver) {this.driver=driver;}

    public String url = "http://demo.seleniumeasy.com/basic-first-form-demo.html";
    public By firstNum = By.id("sum1");
    public By secondNum = By.id("sum2");
    public By getTotalButton = By.xpath("//button[text()=\"Get Total\"]");
    public By result = By.id("displayvalue");

    public void Navigate(){
        driver.navigate().to(url);
    }
    public void AddNumbers(String a,String b){
        WebElement firstNumber = driver.findElement(firstNum);
        firstNumber.sendKeys(a);
        WebElement secondNumber = driver.findElement(secondNum);
        secondNumber.sendKeys(b);
        WebElement totalButton = driver.findElement(getTotalButton);
        totalButton.click();
    }
    public String GetResult(){
        WebElement actual = driver.findElement(result);
        String actualResult = actual.getText();
        return actualResult;
    }
}

