package com.test.selenium.fx.autoUI.source;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;


public class AreaManagerPage {
	// 省份选择
	@FindBy(xpath = ".//*[@id='province']")
	public SelenideElement provinceSelect;
	// 城市选择
	@FindBy(xpath = ".//*[@id='city']")
	public SelenideElement citySelect;
	// 搜索区域名称
	@FindBy(xpath = ".//input[@id='district']")
	public SelenideElement districtText;
	// 查询按钮
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_search']")
	public SelenideElement searchButton;
	// 清空按钮
	@FindBy(xpath = ".//*[@class='searchdroplist-clear classic-clear-wrap-btn']")
	public SelenideElement cleanButton;

	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_add']")
	public SelenideElement areaAddButton;
	// 区域名称
	@FindBy(xpath = ".//*[@id='title']")
	public SelenideElement areaNameText;
	// 省份选择框
	@FindBy(xpath = ".//*[@id='add_province']")
	public SelenideElement addProvinceSelect;
	// 城市选择框
	@FindBy(xpath = ".//*[@id='add_city']")
	public SelenideElement addCitySelect;
	// 排序文本框
	@FindBy(xpath = ".//*[@class='form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-min ng-valid-max ng-valid-required']")
	public SelenideElement orderText;
	// 是否开放
	@FindBy(xpath = ".//*[@id='open_status']")
	public SelenideElement openStatusCB;

	// 保存区域按钮
	@FindBy(xpath = ".//*[@class='ladda-button btn btn-primary']")
	public SelenideElement save;
	// 审核 第一个按钮
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='审核']")
	public SelenideElement autdingLink;
	// 编辑第一个按钮
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='编辑']")
	public SelenideElement editLink;
	// 反审第一个按钮
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='反审']")
	public SelenideElement noAutdingLink;
	// 删除第一个按钮
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/a[text()='删除']")
	public SelenideElement deleteLink;
	// 是否审核列 的未审核状态
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/small[text()='未审核']")
	public SelenideElement notExamineLable;
	// 是否审核列 的未审核状态
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/small[text()='已审核']")
	public SelenideElement examineLable;
	// 是否开放的状态 已开放
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/small[text()='已开放']")
	public SelenideElement openedLable;
	// 是否开放的状态 未开放
	@FindBy(xpath = ".//*[@class='community-status ng-scope']/small[text()='未开放']")
	public SelenideElement closeLable;
	// 列表上的区域名称
	@FindBy(xpath = ".//*[@class='ui-grid-cell-contents ng-binding ng-scope']")
	public SelenideElement onListAreaName;
	
//	 @FindBy(xpath = "")
//	 public SelenideElement deleteLin1k;
	 
	// @Test
	String areaNameContent = "auto" + (int) ((Math.random() * 9 + 1) * 100000);

	public void createArea() {
		areaAddButton.click();

		areaNameText.setValue(areaNameContent);
		addProvinceSelect.selectOption(16);
		addCitySelect.selectOption(1);
		orderText.setValue("1");
		openStatusCB.click();
		// 点击保存
		save.click();
		sleep(2000);

	}

	// 点击审核按钮 刚才添加的内容
	public void searchArea() {

		districtText.setValue(areaNameContent);
		searchButton.click();
	}

	// 点击审核按钮
	public String autdingAction() {
		// 点击审核按钮
		autdingLink.click();
		return examineLable.getText();
	}

	// 点击反审按钮
	public String examineAction() {
		// 点击反审按钮
		noAutdingLink.click();
		return notExamineLable.getText();
	}

	public String editArea() {
		editLink.click();
		areaNameText.setValue(areaNameContent + "编辑后");
		save.click();
		return onListAreaName.getText();
	}

	// 点击反审按钮
	public void deleteArea() {
		// 点击反审按钮
		sleep(1000);
		deleteLink.click();
		sleep(1000);
		$(By.xpath(".//button[@class='confirm']")).click();
		
	}
}
