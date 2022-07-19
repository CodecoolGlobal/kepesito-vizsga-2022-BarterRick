import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TableData extends BasePage{

    public TableData(WebDriver driver){this.driver=driver;}

    public String url ="https://demo.seleniumeasy.com/table-data-download-demo.html";
    public By names = By.xpath("//tbody/tr/td[1]");

    public void Navigate(){
        driver.navigate().to(url);
    }

    public void SaveNamesToFile() throws Exception{
        List<WebElement> tableElements = driver.findElements(names);
        List<String> nameList = new ArrayList<>();
        BufferedWriter writer = new BufferedWriter(new FileWriter("names.txt"));
        for (WebElement listItem: tableElements
             ) {
            String name = listItem.getText();
            writer.write(name);
        }
            writer.close();
    }
    public List<String> ReadNamesFromFile(String filename) throws Exception{
        List<String> result = new ArrayList<>();
        result = Files.readAllLines(Paths.get(filename));
        return result;
    }
}
