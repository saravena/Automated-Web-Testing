import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.List;

public class Tests {

  static WebDriver driver = new HtmlUnitDriver();

  // Start at the homepage for herokuapp for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://cs1632ex.herokuapp.com/");
	}

  // Given that I am on the main page
  // When I view the title
  // Then I see that it contains the words "CS1632 D3"
  @Test
  public void testShowsCorrectTitle() {
      String title = driver.getTitle();
      assertTrue(title.contains("CS1632 D3"));
  }

  // Given that I am on the main page
  // When I view the first message
  // Then I see that it contains the words "Welcome, friend,"
  @Test
  public void testDisplaysCorrectMessage() {
    // Check that there is a "lead" elementText
    // that contains the text "Welcome, friend,"
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.className("lead"));
      String elementText = e.getText();
      assertTrue(elementText.contains("Welcome, friend,"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "CS1632 D3 Home" link
  // Then I see that the page redirects to the original page,"
  @Test
  public void testHomeLink() {
    // Check that there is a "CS1632 D3 Home" link
    // then click the link and confirm the URL
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("CS1632 D3 Home"));
      e.click();
      String currURL = driver.getCurrentUrl();
      assertTrue(currURL.contains("https://cs1632ex.herokuapp.com/"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page,"
  @Test
  public void testFactorialLink() {
    // Check that there is a "Factorial" link
    // then click the link and confirm the URL
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      String currURL = driver.getCurrentUrl();
      assertTrue(currURL.contains("https://cs1632ex.herokuapp.com/fact"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page,"
  @Test
  public void testFibonacciLink() {
    // Check that there is a "Fibonacci" link
    // then click the link and confirm the URL
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      String currURL = driver.getCurrentUrl();
      assertTrue(currURL.contains("https://cs1632ex.herokuapp.com/fib"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Hello" link
  // Then I see that the page redirects to the Hello page,"
  @Test
  public void testHelloLink() {
    // Check that there is a "Hello" link
    // then click the link and confirm the URL
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Hello"));
      e.click();
      String currURL = driver.getCurrentUrl();
      assertTrue(currURL.contains("https://cs1632ex.herokuapp.com/hello"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Cathedral Pics" link
  // Then I see that the page redirects to the Cathedral Pics page,"
  @Test
  public void testCathyLink() {
    // Check that there is a "Cathedral Pics" link
    // then click the link and confirm the URL
    // If the text does not exist, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Cathedral Pics"));
      e.click();
      String currURL = driver.getCurrentUrl();
      assertTrue(currURL.contains("https://cs1632ex.herokuapp.com/cathy"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page"
  // Entering 1 in the text box should print out the Factorial result of 1
  @Test
  public void testValidFactInput1() {
    // Check that there is a "Factorial" link
    // then click the link, enter 1, confirm the result
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      e = driver.findElement(By.xpath("//input[@type='text']"));
      e.sendKeys("1");
      WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Factorial of 1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page"
  // Entering 100 in the text box should print out the Factorial result of 1
  @Test
  public void testValidFactInput100() {
    // Check that there is a "Factorial" link
    // then click the link, enter 100, confirm the result
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      e = driver.findElement(By.xpath("//input[@type='text']"));
      e.sendKeys("100");
      WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page"
  // Entering 0 in the text box should print out 1 as a result
  @Test
  public void testInvalidFactInput0() {
    // Check that there is a "Factorial" link
    // then click the link, enter 0, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      e = driver.findElement(By.xpath("//input[@type='text']"));
      e.sendKeys("0");
      WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Factorial of 0 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page"
  // Entering -1 in the text box should print out 1 as a result
  @Test
  public void testInvalidFactNegInput() {
    // Check that there is a "Factorial" link
    // then click the link, enter -1, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      e = driver.findElement(By.xpath("//input[@type='text']"));
      e.sendKeys("-1");
      WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Factorial of -1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Factorial" link
  // Then I see that the page redirects to the Factorial page"
  // Entering 1.1 in the text box should print out 1 as a result
  @Test
  public void testInvalidFactFloatInput() {
    // Check that there is a "Factorial" link
    // then click the link, enter 1.1, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Factorial"));
      e.click();
      e = driver.findElement(By.xpath("//input[@type='text']"));
      e.sendKeys("1.1");
      WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Factorial of 1.1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page"
  // Entering 1 in the text box should print out the Fibonacci result of 100
  @Test
  public void testValidFibInput1() {
    // Check that there is a "Fibonacci" link
    // then click the link, enter 1, confirm the result
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      e = driver.findElement(By.id("tb1"));
      e.sendKeys("1");
      WebElement submit = driver.findElement(By.id("sub"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Fibonacci of 1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page"
  // Entering 100 in the text box should print out the Fibonacci result of 100
  @Test
  public void testValidFibInput100() {
    // Check that there is a "Fibonacci" link
    // then click the link, enter 100, confirm the result
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      e = driver.findElement(By.id("tb1"));
      e.sendKeys("100");
      WebElement submit = driver.findElement(By.id("sub"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Fibonacci of 100 is 354224848179261915075!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page"
  // Entering 0 in the text box should print out 1 as a result
  @Test
  public void testInvalidFibInput0() {
    // Check that there is a "Fibonacci" link
    // then click the link, enter 0, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      e = driver.findElement(By.id("tb1"));
      e.sendKeys("0");
      WebElement submit = driver.findElement(By.id("sub"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Fibonacci of 0 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page"
  // Entering -1 in the text box should print out 1 as a result
  @Test
  public void testInvalidFibNegInput() {
    // Check that there is a "Fibonacci" link
    // then click the link, enter -1, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      e = driver.findElement(By.id("tb1"));
      e.sendKeys("-1");
      WebElement submit = driver.findElement(By.id("sub"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Fibonacci of -1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given that I am on the main page
  // When I click on the "Fibonacci" link
  // Then I see that the page redirects to the Fibonacci page"
  // Entering 1.1 in the text box should print out 1 as a result
  @Test
  public void testInvalidFibFloatInput() {
    // Check that there is a "Fibonacci" link
    // then click the link, enter 1.1, confirm the result is 1
    // If the result does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Fibonacci"));
      e.click();
      e = driver.findElement(By.id("tb1"));
      e.sendKeys("1.1");
      WebElement submit = driver.findElement(By.id("sub"));
      submit.click();
      WebElement result = driver.findElement(By.className("jumbotron"));
      String res = result.getText();
      assertTrue(res.contains("Fibonacci of 1.1 is 1!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given I am on the main page
  // When I click on the "Hello" link
  // Then I see that the page redirects to the Hello page
  // where a message displays
  @Test
  public void testHelloMessage() {
    // Check that there is a "Hello" link
    // then click the link, and confirm the message
    // If the message does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Hello"));
      e.click();
      e = driver.findElement(By.className("jumbotron"));
      String message = e.getText();
      assertTrue(message.contains("Hello CS1632, from Prof. Laboon!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given I am on the main page
  // When I click on the "Hello" link
  // Then I see that the page redirects to the Hello page
  // Adding a trailing value "Sabrina" in the URl should change the message.
  @Test
  public void testTrailValString() {
    // Check that there is a "Hello" link
    // then click the link, and confirm the message
    // Add a trailing value "Sabrina" and confirm the new message.
    // If the message does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Hello"));
      e.click();
      String url = driver.getCurrentUrl();
      String newurl = url+"/Sabrina";
      driver.get(newurl);

      e = driver.findElement(By.className("jumbotron"));
      String message = e.getText();
      assertTrue(message.contains("Hello CS1632, from Sabrina!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given I am on the main page
  // When I click on the "Hello" link
  // Then I see that the page redirects to the Hello page
  // Adding a trailing value "123" in the URl should change the message.
  @Test
  public void testTrailValNum() {
    // Check that there is a "Hello" link
    // then click the link, and confirm the message
    // Add a trailing value "123" and confirm the new message.
    // If the message does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Hello"));
      e.click();
      String url = driver.getCurrentUrl();
      String newurl = url+"/123";
      driver.get(newurl);

      e = driver.findElement(By.className("jumbotron"));
      String message = e.getText();
      assertTrue(message.contains("Hello CS1632, from 123!"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given I am on the main page
  // When I click on the "Hello" link
  // Then I see that the page redirects to the Hello page
  // Adding a trailing value "#$%^&*" in the URl should change the message.
  @Test
  public void testTrailValRandChars() {
    // Check that there is a "Hello" link
    // then click the link, and confirm the message
    // Add a trailing value "#$%^&*" and confirm the new message.
    // If the message does not appear, the test fails
    try {
      WebElement e = driver.findElement(By.linkText("Hello"));
      e.click();
      String url = driver.getCurrentUrl();
      String newurl = url+"/#$%^&*";
      driver.get(newurl);

      e = driver.findElement(By.className("jumbotron"));
      String message = e.getText();
      assertTrue(message.contains("Hello CS1632, from /#$%^&*"));
    } catch (NoSuchElementException ex) {
      fail();
    }
  }

  // Given I am on the main page
  // When I click on the "Cathedral Pics" link
  // Then I see that the page redirects to the Cathy page
  // All images should be displayed
  @Test
  public void testImagesAreDisplayed() {
    List<WebElement> e = driver.findElements(By.tagName("img"));

    for (WebElement image : e) {
      if (!image.isDisplayed())
        fail();
    }
  }
}
