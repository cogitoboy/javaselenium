package perficient.java_selenium.pages;

import java.net.MalformedURLException;
import java.net.URI;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PerficientHomePageTest  {

	private WebDriver driver;
	
	@BeforeEach
	void setUp() throws MalformedURLException {
		
		
		var options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		driver = 
				new RemoteWebDriver(
					URI.create("http://"+ System.getenv("HOST_NAME") + ":4444/").toURL(),
					options
						);
		
	}
	
	@AfterEach
	void tearDown() {
	   driver.quit();
	}
	
	
	@Test 
	void open() {
		
		 var url = "https://www.perficient.com/";
		 
			
		 driver.get(url);
		 
		 
	}
	
}
