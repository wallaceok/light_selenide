package com.test.selenium.fx.autoUI;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

public class HomePage {
	@FindBy(xpath=".//*[@id='controlpanel']/div/div[1]/div[1]/div/p[2]")
	private SelenideElement companyName;
	
	
	 public SelenideElement getCompanyName() {
		    return companyName.waitUntil(text("21世纪不动产郑州分公司"), 3000);
	 }
}
