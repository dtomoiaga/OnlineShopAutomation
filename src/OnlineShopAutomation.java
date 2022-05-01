import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineShopAutomation {

    public static void main(String[] args) {

        // Import already defined ChromeDriver from the Imports class.

        ChromeDriver driver;
        driver = Imports.Opendriver();

        // Set a wait time globally so there is a pause after each action for the automated test to be followed more easily.

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Open web site and maximize window.

        driver.get("http://www.automationpractice.com");
        driver.manage().window().maximize();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Access the login page and create an account.

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[2]/input")).sendKeys("sarakiemare7@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Fill the account registration form.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[1]/div[1]/label/div/span/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[2]/input")).sendKeys("Tom");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[3]/input")).sendKeys("Daniel");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[5]/input")).sendKeys("12345");


        // Wrap my web elements (the drop down menus from the registration form) into Select object.

        Select dropdownDay = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select")));
        Select dropdownMonth = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[2]/div/select")));
        Select dropdownYear = new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select")));


        // Select items from the drop down menus (I only managed to select the items by index by manually counting the index).

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select")).click();
        dropdownDay.selectByIndex(30);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[2]/div/select")).click();
        dropdownMonth.selectByIndex(7);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select")).click();
        dropdownYear.selectByIndex(35);


        // Move on with the registration form.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[7]/div/span/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[8]/div/span/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[3]/input")).sendKeys("Sarakie SRL");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[4]/input")).sendKeys("Strada Sarakiei, Nr. 69");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[5]/input")).sendKeys("Sc. 1, Ap. 20");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[6]/input")).sendKeys("Turcinesti");


        // Here I have another drop down selector, I will handle it like the previous one.

        Select dropdownState = new Select(driver.findElement(By.id("id_state")));
        driver.findElement(By.id("id_state")).click();
        dropdownState.selectByIndex(4);


        // Move on with the registration form

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[8]/input")).sendKeys("21753");


        // Another drop down selector, I will handle it like the previous ones.

        Select dropdownCountry = new Select(driver.findElement(By.id("id_country")));
        driver.findElement(By.id("id_country")).click();
        dropdownCountry.selectByIndex(1);

        // Move on with the registration form.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[10]/textarea")).sendKeys("Nu mai fiti saraci! Va doresc OK!");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[12]/input")).sendKeys("0749 89 89 89");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[13]/input")).sendKeys("0748 98 98 98");


        // Here is a text box with text in it that has to be deleted first.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")).sendKeys("Strada Sarakiei, Nr. 69");

        // Finish the registration process.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div[4]/button/span")).click();


        // Sign out and sign back it to check if the account creation was successful.


        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();


        // First I will input the wrong email and the correct password. I'll add a wait after each login attempt.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")).sendKeys("sarakiemaree7@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")).sendKeys("12345");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")).clear();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Then the correct email and wrong password.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")).sendKeys("sarakiemare7@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")).sendKeys("12346");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")).clear();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Then the correct email and password and the login is successful.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")).sendKeys("sarakiemare7@gmail.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")).sendKeys("12345");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")).click();


        // Next I will create a wish list.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/ul/li/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/form/fieldset/div/input[2]")).sendKeys("Personal Wishlist");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/form/fieldset/p/button/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/ul/li[2]/a/span")).click();

        // I will start adding items to that wish list. To make things complicated I will hover over menu items and select sub-items of those menus.

        WebElement women = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a"));
        Actions hover1 = new Actions(driver);
        hover1.moveToElement(women).build().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[1]/ul/li[1]/a")).click();

        WebElement tshirt = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img"));
//		Actions hover2 = new Actions(driver);
        hover1.moveToElement(tshirt).build().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[3]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();


        driver.navigate().refresh();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement womenAgain = driver.findElement(By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a"));
        Actions hover1again = new Actions(driver);
        hover1again.moveToElement(womenAgain).build().perform();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[2]/ul/li[3]/a")).click();

        // There are 3 items here, I will add two of them to the wish list and one of them to the cart. Mouse hover needed for all three.

        WebElement dress1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img"));
        Actions hover3 = new Actions(driver);
        hover3.moveToElement(dress1).build().perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[3]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();

        WebElement dress2 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
        Actions hover4 = new Actions(driver);
        hover4.moveToElement(dress2).build().perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[3]/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/a")).click();

        WebElement dress3 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[1]/div/a[1]/img"));
        Actions hover5 = new Actions(driver);
        hover5.moveToElement(dress3).build().perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[1]/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")).click();


        // Next I will navigate to my wish list and add the items from the list to the cart and also change the item quantity.

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/ul/li/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[5]/a")).click();

        driver.findElement(By.id("quantity_1_0")).clear();
        driver.findElement(By.id("quantity_1_0")).sendKeys("3");

        Select dropdownState2 = new Select(driver.findElement(By.id("priority_1_0")));
        driver.findElement(By.id("priority_1_0")).click();
        dropdownState2.selectByIndex(0);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("quantity_6_0")).clear();
        driver.findElement(By.id("quantity_6_0")).sendKeys("2");

        Select dropdownState3 = new Select(driver.findElement(By.id("priority_6_0")));
        driver.findElement(By.id("priority_6_0")).click();
        dropdownState3.selectByIndex(2);

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/ul/li[1]/div/div[2]/div/div[2]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/ul/li[2]/div/div[2]/div/div[2]/a/span")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/ul/li[1]/div/div[1]/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span/i")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[2]/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")).click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().back();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[5]/a")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/ul/li[2]/div/div[1]/div/a/img")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/input")).sendKeys("3");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/div/div[3]/textarea")).sendKeys("Hai va rog eu nu mai fiti saraki! Ok? Ok!");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/div/span/input")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/form/p/button/span")).click();


        // Now that the order is completed I will navigate back to my account to check it.

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a/span")).click();


        // I will see the order details and download the invoice.

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/table/tbody/tr/td[7]/a[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/table/tbody/tr/td[6]/a")).click();


    }

}

