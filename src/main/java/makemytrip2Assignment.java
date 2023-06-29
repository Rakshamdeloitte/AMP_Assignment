package javapackageautomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class makemytrip2Assignment{
    public static void main(String[] args) throws InterruptedException {
  
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        
        WebDriver driver = new ChromeDriver();

       
        driver.get("https://www.makemytrip.com/");

        // Removing popup
//        driver.switchTo().alert().dismiss();
//        id = webklipper-publisher-widget-container-notification-close-div
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/span")).click();
//        // Login
        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[4]"));
        loginLink.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("rakshanivasinim@gmail.com");

        WebElement continueButton = driver.findElement(By.xpath("//button[@data-cy='continueBtn']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("Mari@1234");
//        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button"));
        loginButton.click();
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/div/span")).click();


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
//        fromInput.clear();
//        fromInput.sendKeys("Bangalore");
        driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-3\"]/div/div[1]/p[1]"));

        WebElement toInput = driver.findElement(By.id("toCity"));
        toInput.clear();
        toInput.sendKeys("Hyderabad");

        // Selecting days
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(30);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String futureDateStr = futureDate.format(formatter);

        WebElement departureDateInput = driver.findElement(By.xpath("//input[@id='departure']"));
        departureDateInput.clear();
        departureDateInput.sendKeys(futureDateStr);

        // Selecting Adult count 2, children 3, infant 1, and class as Business
        WebElement travellerInput = driver.findElement(By.id("travellers"));
        travellerInput.click();

        WebElement adultsCount = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/ul[1]/li[2]"));
        adultsCount.click();

        WebElement childrenCount = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/div/div[1]/ul/li[4]"));
        childrenCount.click();
        childrenCount.click();
        childrenCount.click();

        WebElement infantsCount = driver.findElement(By.xpath("//ul[@class='guestCounter  makeFlex column']/li[3]//span[@class='appendBottom5']"));
        infantsCount.click();

        WebElement travelClass = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[5]/div[1]/div[1]/ul[2]/li[3]"));
        travelClass.click();

        // Clicking search
        WebElement searchButton = driver.findElement(By.xpath("//a[contains(@class,'primaryBtn')]"));
        searchButton.click();

        // Selecting filter.
        WebElement airasiaFilter = driver.findElement(By.xpath("//p[contains(text(),'AirAsia')]"));
        airasiaFilter.click();

       
        Thread.sleep(5000);

        // Print 
        List<WebElement> airlines = driver.findElements(By.xpath("//span[@class='airways-name ']"));
        List<WebElement> durations = driver.findElements(By.xpath("//span[@class='block append_bottom3 duration']"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='makeFlex spaceBetween']//p[@class='blackText fontSize18 blackFont white-space-no-wrap']"));

        int count = airlines.size();

        for (int i = 0; i < count; i++) {
            String airline = airlines.get(i).getText();
            String duration = durations.get(i).getText();
            String price = prices.get(i).getText();

            System.out.println("Airline: " + airline);
            System.out.println("Duration: " + duration);
            System.out.println("Price: " + price);
            System.out.println("--------------------------");
        }

        // Assert
        if (count > 1) {
            System.out.println("Count of results is greater than 1 - Assertion passed");
        } else {
            System.out.println("Count of results is not greater than 1 - Assertion failed");
        }

      
        driver.quit();
    }
}