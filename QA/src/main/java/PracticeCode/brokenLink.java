package PracticeCode;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLink {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		openBrowser();
	}
	private static void openBrowser() throws InterruptedException, MalformedURLException, IOException {
		String path = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", path + "\\src\\test\\resources\\binaries\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		System.out.println("Broken LInk Code");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Size of Full Links: " + links.size());

		List<WebElement> activeLinks = new ArrayList<WebElement>();

		for (int i = 0; i <= links.size() - 1; i++) {
			if (links.get(i).getAttribute("href") != null) {
				activeLinks.add(links.get(i));
				System.out.println(activeLinks.get(i).getAttribute("href"));
			}
		}
		System.out.println("Active Link availabe: " + activeLinks.size());

		for (int j = 0; j <= activeLinks.size() - 1; j++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String ResponseMessage = connection.getResponseMessage();
			connection.disconnect();
			System.out.println("The link" + activeLinks.get(j).getAttribute("href") + "--->" + ResponseMessage);
		}

		driver.quit();

	}
}
