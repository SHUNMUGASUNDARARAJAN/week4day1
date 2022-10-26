package week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
        driver.findElement(By.id("username")).sendKeys("demosalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//td//img)[1]")).click();
		Set<String> mergeMethods =driver.getWindowHandles();
		List<String> page =new ArrayList<String>(mergeMethods);
		driver.switchTo().window(page.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		driver.switchTo().window(page.get(0));
		
		driver.findElement(By.xpath("(//td//img)[2]")).click();
		Set<String> mergeMethods2 =driver.getWindowHandles();
		List<String> page1=new ArrayList<String>(mergeMethods2);
		driver.switchTo().window(page1.get(1));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		driver.switchTo().window(page1.get(0));
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		System.out.println(text);
		
		alert.accept();
		System.out.println(driver.getTitle());
		
		
		
	}

}
