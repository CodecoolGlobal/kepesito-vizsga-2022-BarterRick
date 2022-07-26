import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    protected WebDriver driver;

    //Driver beállítása a tesztek előtt
    @BeforeEach
    public void Setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //Driver bezárása a tesztek után
    @AfterEach
    public void Close()
    {
        //Driver dispose
        driver.quit();
    }
    /*
    Tölts be a böngészőbe az alábbi oldalt: https://demo.seleniumeasy.com/basic-first-form-demo.html
    Írj tesztesetet két szám összegének ellenőrzésére a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. Az oldalon, a Two Input Fields” szekcióban két beviteli mezőjét töltsd ki tetszőleges számokkal, majd végezd el a számok összeadásának ellenőrzését kiolvasva az oldalon megjelenő összeget.
    Használj tetszőleges tesztadatot
     */
    @Test
    public void TestInput()
    {
        BasicFirstForm firstForm;
        firstForm = new BasicFirstForm(driver);
        firstForm.Navigate();
        firstForm.AddNumbers("8","13");
        String actual = firstForm.GetResult();
        Assertions.assertEquals("21",actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet a következők szerint: a Select List Demo szekció lenyíló mezőjében válaszd ki a hét utolsó napját és ellenőrizd, hogy az oldalon helyesen jelenik meg a kiválasztott érték
    Tesztadatként használd az hét utolsó napját
     */
    @Test
    public void SelectDayTest()
    {
        BasicSelectDropdown dropDown;
        dropDown = new BasicSelectDropdown(driver);
        dropDown.Navigate();
        dropDown.SelectLastDay();
        String actual = dropDown.GetResult();
        Assertions.assertEquals("Day selected :- Saturday",actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/bootstrap-modal-demo.html#
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetben ellenőrizd a modal alert ablak szöveges tartalmát összahasonlítva egy általad definiált elvárt eredménnyel. Nyisd meg a Single Modal ablakot, tárolt el az ablakon megjelenő szöveget egy változóba és zárd be az ablakot a bezárás gombbal
     */
    @Test
    public void AlertTest()
    {
        BootstrapModal alert;
        alert = new BootstrapModal(driver);
        alert.Navigate();
        alert.OpenModal();
        String actual = alert.GetTextFromModal();
        alert.CloseModal();
        Assertions.assertEquals("This is the place where the content for the modal dialog displays ",actual);
    }

    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/data-list-filter-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A teszteset ellenőrizze a névjegykártyák tartalmát.Olvasd ki a neveket a megjelenő névjegykártyákról és ellenőrzésként hasonlítsd össze egy elvárt eredményként megadott listával.
    Használj relatív útvonalat a névjegykártya név elemeinek kiolvasásához.
     */
    /*@Test
    public void NamecardTest()
    {
        DataListFilter namecard;
        namecard = new DataListFilter(driver);
        namecard.Navigate();
        List<String> actual = namecard.GetNames();
        List<String> expected = Arrays.asList("Tyreese Burn", "Brenda Tree", "Glenn Pho shizzle","Brian Hoyies","Glenn Pho shizzle","Arman Cheyia");
        Assertions.assertArrayEquals(expected,actual);
    }
*/
    /*
    Töltsd be az alábbi oldalt a böngészőbe: https://demo.seleniumeasy.com/table-data-download-demo.html
    Írj tesztesetet a mellékelt dokumentumban, majd a tesztlépések alapján írj automatizált tesztet. A tesztesetet ellenőrizze a táblázatból a neveket, amelyeket a táblázat első oszlop tartalmaz. Gyűjtsd össze a neveket és tárold le a names.txt fájlba majd a tesztesetben a fájl tartalmát hasonlítsd össze egy elvárt eredménnyel.
     */
    /*
    @Test
    public void TableTest() throws Exception
    {
        TableData table;
        table = new TableData(driver);
        table.Navigate();
        table.SaveNamesToFile();
        List<String> actual = table.ReadNamesFromFile("names.txt");
        List<String> expected = table.ReadNamesFromFile("expected.txt");
    }
    */

}
