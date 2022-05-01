import org.openqa.selenium.chrome.ChromeDriver;

public class Imports {
    public static ChromeDriver Opendriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/danieltom/Downloads/BrowerDrivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        return driver;
    }
    public static void main(String[] args) {

    }
}