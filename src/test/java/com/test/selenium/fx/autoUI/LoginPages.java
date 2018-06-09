package com.test.selenium.fx.autoUI;

import static com.codeborne.selenide.Selenide.page;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenidePageFactory;

public class LoginPages {

	@FindBy(xpath = ".//*[@id='mobile']")
	private SelenideElement mobile;
	@FindBy(xpath = ".//*[@id='password']")
	private SelenideElement password;
	@FindBy(xpath = "//button[@class='btn btn-lg btn-block']")
	private SelenideElement submit;

	public HomePage loginSuccess() {

		mobile.setValue("13012345670");
		password.setValue("123456");
		submit.click();

		return page(HomePage.class);
	}

}
