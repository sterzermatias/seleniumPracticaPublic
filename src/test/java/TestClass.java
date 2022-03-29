import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestClass {
    private static final String pathDriver = "D:\\D-Users\\D-Matias\\Documents\\IntelliJ Projects\\selenium\\src\\test\\resources\\chromedriver\\chromedriver.exe";
    private  static final String  tipoDriver = "webdriver.chrome.driver";
    private WebDriver driver;
    private String URL = "https://espanol.yahoo.com";

    @BeforeClass
    public static  void setUpBeforeClass()
    {
        System.out.println("INICIO TEST");
        System.setProperty(tipoDriver,pathDriver);
    }

    @Before
    public void setUp(){
        System.out.println("INICIO setUpVoid");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        WebElement txtSearch = driver.findElement(By.id("ybar-sbq"));
        txtSearch.clear();
        txtSearch.sendKeys("selenium");
        txtSearch.submit();
        };

    @Test
    public void testSearch() throws InterruptedException {
        String tittle2 = driver.getTitle();
        /*System.out.println(tittle2);*/
       Assert.assertTrue("valida que contiene el texto ENVIADO",tittle2.contains("selenium"));
    };
    @After
    public void tearDown(){
        driver.quit();
    };
     @AfterClass
    public static void  tearDownAfterClass(){
         System.out.println("Finalizan tests");
     };
}
