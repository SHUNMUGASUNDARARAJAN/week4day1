package week4Day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> leafground=driver.getWindowHandles();
		System.out.println(leafground.size());
		
		List<String> first=new ArrayList<String>(leafground);
		driver.switchTo().window(first.get(2));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(first.get(0));
    	driver.close();
    	driver.switchTo().window(first.get(1));
    	driver.close();
		driver.switchTo().window(first.get(2));
		
		
		
		
		
		
		
	}

}
