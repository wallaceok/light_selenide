package com.test.selenium.fx.autoUI.source;

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
public class BSourceAddTest {

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
	
	
	public static String  uuid=null;

	/**
	 * 房源添加和搜索
	 */
	@Test
	public void aSourceAddAndSearchTest() {
//		// 房源添加
		SourceDetailPage baseDetailPage = open("http://app-member.fx.com/source", SourceDetailPage.class);
//		baseDetailPage.addSource();

		sleep(2000);
		// 房源搜索按楼盘
		SourceListPage sourceListPage = open("http://app-member.fx.com/source", SourceListPage.class);
		int num = sourceListPage.searchSource();

		// 连接查询自动化楼盘的房源条数
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("test2JdbcTemplate");
		String sql = "SELECT COUNT(1) FROM  erp_sources WHERE  community_id =6283";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		// 断言数据库房源条数和页面获取条数是否一致
		Assert.assertEquals(count, num);
		
		
		uuid = baseDetailPage.createFollow();
		
		System.out.println(uuid);

	}
	
	@Test
	public void bCreateFollowTest2() {
		String status=null;
		SourceFollowPage sourceFollowPage=open("http://app-member.fx.com/trace?category=sources",SourceFollowPage.class);
		if(uuid!=null) {
			status= sourceFollowPage.auditing(uuid);
			//断言状态是否显示 有效
			Assert.assertEquals("有效", status);
			
			status = sourceFollowPage.noAuditing();
			//断言状态是否显示 无效
			Assert.assertEquals("无效", status);
		}else {
			System.out.println("未获房源编号");
		}
		
		
	}
	
	
	
	

}
