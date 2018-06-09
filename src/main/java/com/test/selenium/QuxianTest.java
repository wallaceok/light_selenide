package com.test.selenium;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;


public class QuxianTest {
	@Test
	public void userCanLoginByUsername() {
		Configuration.browser ="chrome";
		System.setProperty("webdriver.chrome.driver", "D:\\work\\com.test.selenium\\drivers\\chromedriver.exe");
	  open("http://qa.1fangxin.cn/login");
	  $(By.id("mobile")).setValue("15890000000");
	  $(By.id("password")).setValue("123456");
	  $(By.xpath("html/body/div[1]/div/div/div[2]/form/button")).click();
	  
//	  人员权限
//	  open("http://qb1-member.fx.com/organization/role/3/permission/edit#/so-tab");
	  open("http://qa.1fangxin.cn/organization/agent/5144/permission/edit#/st-tab");
	  
	  //选项index
	  int  index = 0;
	  
	  @SuppressWarnings("rawtypes")
	  Map  xpathMap = new HashMap();
	  
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[1]/a",".//*[@id='g.source-list0']//select"); //��ԴȨ��
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[2]/a", ".//div[@id='scroll-container-client']//select"); //��ԴȨ��
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[4]/a", ".//*[@id='scroll-container-bargain']//select"); //��ͬȨ��
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[5]/a", ".//*[@id='scroll-container-statistics']//select");//ͳ��
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[6]/a", ".//*[@id='scroll-container-personnel']//select");//����
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[7]/a", ".//*[@id='scroll-container-salary']//select");//����
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[8]/a", ".//*[@id='scroll-container-finance']//select");//����
//	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[10]/a", ".//*[@id='scroll-container-warrant']//select");//Ȩ֤
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[12]/a", ".//*[@id='scroll-container-daily']//select");//�ձ�
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[14]/a", ".//*[@id='scroll-container-newsource']//select");//�·�
	  xpathMap.put(".//*[@id='permissionForm']/div/div[1]/ul/li[15]/a", ".//*[@id='scroll-container-announcement']//select");//����
	  
	  Iterator map1it=xpathMap.entrySet().iterator();
	  while(map1it.hasNext()) {
		  Map.Entry<String, String> entry=(Entry<String, String>) map1it.next();
	      System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
	      
	      this.clickSelectOption(index,entry.getKey(),entry.getValue());
	   }
	  sleep(5000);
	  
	}
	
	public void clickSelectOption(int index,String optionXpath,String optionSelectXpath) {
		
		$(By.xpath(optionXpath)).click();
		sleep(2000);
		
		ListIterator<SelenideElement> llses =  $$(By.xpath(optionSelectXpath)).listIterator();
		  
		  while(llses.hasNext()) {
			  SelenideElement se = llses.next();
			  se.selectOption(index);
		  } 
		  
		  
	  }
}
