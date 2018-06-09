package com.test.selenium.fx.autoUI;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Condition.text;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.codeborne.selenide.Configuration;

public class ALoginTest {
	
	
	@BeforeClass
	public static void test() {
		Configuration.browser = "chrome";
		System.setProperty("webdriver.chrome.driver", "D:\\work\\com.test.selenium\\drivers\\chromedriver.exe");
		
		LoginPages login = open("http://app-member.fx.com/login", LoginPages.class);
		sleep(1000);
		HomePage homePage = login.loginSuccess();
		sleep(1000);
		// 检查是否登录成功
		homePage.getCompanyName().shouldHave(text("21世纪不动产郑州分公司"));
	}

	@Test
	public void test1() {
		
		
		sleep(3000);
	}
	
	@Test
	public void Test() {
		
	}

}
