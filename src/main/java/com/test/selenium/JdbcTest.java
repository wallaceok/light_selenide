package com.test.selenium;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class JdbcTest {
	// @Resource(name = "test2JdbcTemplate")
	// private JdbcTemplate jdbcTemplate;

	@Test
	public void testjdbc() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("test2JdbcTemplate");

		String sql = "SELECT  MAX(door_name) FROM  erp_agency_houses WHERE community_id = 6283";
		// List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		System.out.println(String.valueOf(count));

	}

	// @Test
	public void userCanLoginByUsername() {
		open("/login");
		$(By.name("user.name")).setValue("johny");
		$("#submit").click();
		$(".loading_progress").should(disappear); // Waits until element disappears
		$("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
	}
}
