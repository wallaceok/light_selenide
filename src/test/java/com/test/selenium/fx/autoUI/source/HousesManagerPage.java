package com.test.selenium.fx.autoUI.source;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HousesManagerPage {

	//楼盘
	@FindBy(xpath = ".//*[@id='search-community']/input")
	public SelenideElement houseNameText;
	
	@FindBy(xpath=".//*[@id='search']")
	public SelenideElement searchbutton;
	
	
	//新增楼盘
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_add']")
	public SelenideElement newHouseButton;
	//楼盘详情
	@FindBy(xpath = ".//input[@placeholder='请输入楼盘名称']")
	public SelenideElement newHouseNameText;
	//所属区县
	@FindBy(xpath = ".//select[@ng-change='selectDistrict()']")
	public SelenideElement districtSelect;
	
	//商圈选择
	@FindBy(xpath = ".//*[@ng-options='business.id as business.name for business in businesses ']")
	public SelenideElement tradingAreaSelect;
	
	//进入设置地图界面
	@FindBy(xpath = ".//*[@ng-click='map()']")
	public SelenideElement mapButton;
	
	//地图区域
	@FindBy(xpath = ".//*[@id='map']/div[1]/div[1]")
	public SelenideElement mapArea;
	//地图位置保存
	@FindBy(xpath = ".//*[@class='ladda-button btn btn-primary btn-sm']")
	public SelenideElement mapSave;
	
	@FindBy(xpath=".//*[@id='community']/div[1]/div/div/div/div[3]/button")
	public SelenideElement save;
	
	//新增窗口的关闭按钮
	@FindBy(xpath = ".//button[@class='close']")
	public SelenideElement newWindowCloseButton;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']//a[text()='审核']")
	public SelenideElement audtingLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']//a[text()='编辑']")
	public SelenideElement editLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']//a[text()='删除']")
	public SelenideElement deleteLink;
	
	@FindBy(xpath = ".//*[@class='community-status ng-scope']//a[text()='取审']")
	public SelenideElement cancleAudtingLink;
	
	@FindBy(xpath = ".//button[@class='confirm']")
	public SelenideElement confirm;
//	
//	@FindBy(xpath = "")
//	public SelenideElement citySelect1;
	
	String houseNameContent = "auto" + (int) ((Math.random() * 9 + 1) * 100000);
	public void addHouse() {
		
		newHouseButton.click();
		newHouseNameText.setValue(houseNameContent);
		districtSelect.selectOption(1);
		tradingAreaSelect.selectOption(1);
		mapButton.click();
		sleep(3000);
		mapArea.click(200,200);
		sleep(3000);
		mapSave.click();
		sleep(1000);
		save.click();
		//关闭窗口
		newWindowCloseButton.click();
	}
	
	public void searchHouse() {
		houseNameText.setValue(houseNameContent);
		searchbutton.click();
	}
	
	public void audtingHouse() {
		audtingLink.click();
	}
	public void cancleAudtingHouse() {
//		this.searchHouse();
		cancleAudtingLink.click();
	}
	public void editHouse() {
//		this.searchHouse();
		editLink.click();
		newHouseNameText.setValue(houseNameContent+"编辑后");
		save.click();
		newWindowCloseButton.click();
	}
	public void deleteHouse() {
//		this.searchHouse();
		deleteLink.click();
		sleep(2000);
		confirm.click();
		sleep(2000);
	}
	
	
}
