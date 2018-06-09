package com.test.selenium.fx.autoUI.source;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

/**
 * 商圈管理
 * 
 * @author Administrator
 *
 */
public class TradingAreaPage {
	// 省份选择
	@FindBy(xpath = ".//select[@ng-change='selectProvince()']")
	public SelenideElement provinceSelect;
	
	// 城市选择
	@FindBy(xpath = ".//select[@ng-change='selectCity()']")
	public SelenideElement citySelect;
	//区域选择
	@FindBy(xpath = ".//select[@ng-options='v.id as v.name for v in districts']")
	public SelenideElement areaSelect;
	//区域搜索框
	@FindBy(xpath = ".//*[@id='search-warrant-name']")
	public SelenideElement businessSearchText;
	
	//搜索按钮
	@FindBy(xpath = ".//button[@ng-click='getBusiness()']")
	public SelenideElement searchButton;
	//审核链接
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='审核']")
	public SelenideElement audtingLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='编辑']")
	public SelenideElement editLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='删除']")
	public SelenideElement deleteLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='反审']")
	public SelenideElement noAudtingLink;
	
	//未审核
	@FindBy(xpath = ".//*[@class='approve_status ng-scope']/small[text()='未审核']")
	public SelenideElement noAudtingLable;
	
	
	@FindBy(xpath = ".//*[@class='approve_status ng-scope']/small[text()='已审核']")
	public SelenideElement audtinged;
	
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_add']")
	public SelenideElement addBusinessButton;
	
	//新增 详情中 商圈名称 
	@FindBy(xpath = ".//*[@id='name']")
	public SelenideElement businessName;
	
	
	@FindBy(xpath = ".//*[@id='province']")
	public SelenideElement newProvinceSelect;
	
	@FindBy(xpath = ".//*[@id='city']")
	public SelenideElement newCitySelect;
	
	@FindBy(xpath = ".//*[@id='district']")
	public SelenideElement newDistrict;
	
	@FindBy(xpath = ".//*[@id='order']")
	public SelenideElement newOrderText;
	
	@FindBy(xpath = ".//*[@id='open_status']")
	public SelenideElement openStatus;
	
	@FindBy(xpath = ".//*[@id='description']")
	public SelenideElement note;
	
	@FindBy(xpath = ".//*[@class='ladda-button btn btn-primary btn-sm']")
	public SelenideElement save;
	
	@FindBy(xpath = ".//button[@class='confirm']")
	public SelenideElement confirmButton;
	
	String businessNameContent = "auto" + (int) ((Math.random() * 9 + 1) * 100000);
	
	public void addBusiness() {
		addBusinessButton.click();
		
		businessName.setValue("auto"+businessNameContent);
		sleep(1000);
		newDistrict.selectOption(1);
		sleep(1000);
		openStatus.click();
		
		save.click();
		
	}
	
	public void searchBusiness() {
		businessSearchText.setValue("auto"+businessNameContent);
		
		searchButton.click();
	}
	
	public void  audtingClick() {
		audtingLink.click();
		
	}
	
	public void noAudtingClick() {
		noAudtingLink.click();
	}
	
	public void editBusiness() {
		editLink.click();
		
		
		businessName.setValue("auto"+businessNameContent+"编辑后");
		
		save.click();
	}
	
	public void delete() {
		sleep(1000);
		deleteLink.click();
		sleep(1000);
		confirmButton.click();
	}
	
	
	
}
