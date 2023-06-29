package javapackageautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Amazon2Assignment {
public static void main(String[]args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    ChromeDriver driver= new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
  //Sign in
    driver.get("https://www.amazon.in/");
    driver.manage().window().maximize();
    
    driver.findElementByXPath("//*[@id=\"nav-signin-tooltip\"]/a/span").click();
    driver.findElementById("ap_email").sendKeys("rakshanivasinim@gmail.com");
    
    driver.findElementByClassName("a-button-input").click();
    driver.findElementByName("password").sendKeys("Marimuthu");
  
    driver.findElementById("signInSubmit").click();
//    Thread.sleep(20000);
       
    // clicking all 
    driver.findElementByXPath("//a//span[text()='All']").click();
    Thread.sleep(1000);
    WebElement Mens = driver.findElementByXPath("//div[@id='hmenu-content']//ul//li//a//div[contains(text(),'Men')]");
    Thread.sleep(1000);
    js.executeScript("arguments[0].scrollIntoView();",Mens);
//  WebElement Fashion = driver.findElementByXPath("//div[contains(text(),\\\"Men's Fashion\\\")]");
     Actions actions = new Actions(driver);
     actions.moveToElement(Mens).build().perform();

    //mens fashion
    driver.findElementByXPath("//div[@id='hmenu-content']//ul//li//a//div[contains(text(),'Men')]").click();
    //Shirts
    driver.findElementByXPath("/html/body/div[3]/div[2]/div/ul[10]/li[5]").click(); 
    
//  Actions actions = new Actions(driver);
//  WebElement Shirt = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[2]/ul/li[2]/span/div/a/div/img"));
    WebElement Shirt = driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[3]/div[2]/div/div[2]/div[2]/ul/li[1]/span/div/a/div/div"));
    Actions actions1= new Actions(driver);
    actions1.moveToElement(Shirt).build().perform();
    Thread.sleep(1000);
    
    driver.findElementByXPath("//*[@id=\"octopus-quick-look-btn\"]/span/input").click();
    //see product details
    WebElement productName = driver.findElement(By.xpath("//h1[@class='product-title']"));
    WebElement productPrice = driver.findElement(By.xpath("//span[@class='price']"));
    System.out.println("Product Name: " + productName.getText());
    System.out.println("Product Price: " + productPrice.getText());
    
    //size 'L'
   driver.findElementByXPath("//*[@id=\"native_dropdown_selected_size_name").click();
   driver.findElementByXPath("//*[@id=\"native_size_name_2");
   //color
   driver.findElementByXPath("//*[@id=\"a-autoid-13-announce\"]/div/div[1]/img").click();
   
   //Fetching product name, quantity, size, and price
   String prdname = productName.getText();
   String quantity = "1"; // Assuming the default quantity is 1
   String size = "L";
   String price = productPrice.getText();
   
  // Print fetched details
   System.out.println("Product Name: " + prdname);
   System.out.println("Quantity: " + quantity);
   System.out.println("Size: " + size);
   System.out.println("Price: " + price);
   
// Add to Cart and go to cart 
   driver.findElement(By.id("add-to-cart-button")).click();
  driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();

//bag count 1
   WebElement bagCount = driver.findElement(By.xpath("//*[@id=\"nav-cart-count\"]"));
   int count = Integer.parseInt(bagCount.getText());

   if (count == 1) {
       System.out.println("Bag count is 1 - Assertion passed");
   } else {
       System.out.println("Bag count is not 1 - Assertion failed");
   }
   driver.quit();
}
  
    
}