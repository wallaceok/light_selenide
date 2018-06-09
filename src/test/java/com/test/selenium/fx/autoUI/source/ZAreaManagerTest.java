package com.test.selenium.fx.autoUI.source;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.codeborne.selenide.Configuration;
import com.test.selenium.fx.autoUI.HomePage;
import com.test.selenium.fx.autoUI.LoginPages;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ZAreaManagerTest {

	
//	@BeforeClass
//	public static void test() {
//		Configuration.browser = "chrome";
//		System.setProperty("webdriver.chrome.driver", "D:\\work\\com.test.selenium\\drivers\\chromedriver.exe");
//
//		LoginPages login = open("http://app-member.fx.com/login", LoginPages.class);
//		HomePage homePage = login.loginSuccess();
//		// 检查是否登录成功
//		homePage.getCompanyName().shouldHave(text("21世纪不动产郑州分公司"));
//	}
	
	/**
	 * 创建区域
	 */
	@Test
	public void aCreateAreaTest() {
		
		AreaManagerPage areaManagerPage = open("http://app-member.fx.com/dictionary/district",AreaManagerPage.class);
		
		areaManagerPage.createArea();
		
		areaManagerPage.searchArea();
		//审核
		areaManagerPage.autdingAction();
		//反审
		areaManagerPage.examineAction();
		//编辑
		areaManagerPage.editArea();
		sleep(2000);
		areaManagerPage.deleteArea();
		
	}
}
