import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.network.Network;

public class ChromeTest {

	public static void main(String[] args) {
		 
        // pass the path of the chromedriver location in the second argument
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swanand\\Downloads\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
 
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request Method : " + request.getRequest().getMethod());
            System.out.println("Request URL : " + request.getRequest().getUrl());
            System.out.println("Request headers: " + request.getRequest().getHeaders().toString());
            System.out.println("Request body: " + request.getRequest().getPostData().toString());
        });
 
        driver.get("https://www.makemytrip.com");
 
    }
}
