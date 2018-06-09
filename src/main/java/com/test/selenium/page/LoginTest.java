package com.test.selenium.page;

import static com.codeborne.selenide.Selenide.open;

import org.junit.Before;
import org.junit.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;

public class LoginTest {
	
	@Before
	public void test() {
		Configuration.browser ="chrome";
		System.setProperty("webdriver.chrome.driver", "D:\\work\\com.test.selenium\\drivers\\chromedriver.exe");
	}
	

	
	@Test
	public void  testBaidu() {
		LoginPage page = open("https://baidu.com/", LoginPage.class);
	    SearchResultsPage results = page.searchFor("selenide");
	    
	    results.getResults().shouldHave(sizeGreaterThan(1));
	    results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
	}
}
