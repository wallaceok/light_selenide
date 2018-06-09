package com.test.selenium.fx.autoUI.source;

import static com.codeborne.selenide.Condition.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.sleep;

public class SourceListPage {
	// 房源列表连接
	@FindBy(xpath = ".//*[@id='fangxin']/ul[1]/li[2]/ul/li[1]/a")
	public SelenideElement soruceList;
	// 房源添加按钮
	@FindBy(xpath = ".//button[@class='btn btn-sm erp-btn_add']")
	public SelenideElement sourceAdd;
	// 房源分享按钮
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_audit ng-binding']")
	public SelenideElement sourceShare;
	// 房源查询按钮
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_search']")
	public SelenideElement sourceSearch;
	// 房源批量转移
	@FindBy(xpath = ".//*[@id='openTransferId']")
	public SelenideElement sourceBatdeal;

	// 房源搜索楼盘
	@FindBy(xpath = ".//*[@id='search-community']/div[1]/input")
	public SelenideElement houses;

	// 房源楼盘选择
	@FindBy(xpath = ".//*[@id='search-community']/div[2]/ul/li[1]/p[1]")
	public SelenideElement housesSelect;

	// 栋
	@FindBy(xpath = ".//*[@id='search-input-ridgepole']")
	public SelenideElement ridgepole;
	// 单元
	@FindBy(xpath = ".//*[@id='search-input-unity']")
	public SelenideElement unity;
	// 房号
	@FindBy(xpath = ".//*[@id='search-input-room']")
	public SelenideElement room;
	
	//列表集合
	@FindBy(xpath = ".//*[@class='ui-grid-canvas']/div/div")
	public SelenideElement sourcelist;

	// 搜索出几条数据
	@FindBy(xpath = ".//*[@id='gird_sources']/div[2]/div/div[1]/label")
	public SelenideElement sourceNum;

	// 搜索条数
	public int searchSource() {

		houses.click();
		houses.setValue("自动化");
		housesSelect.click();
		sourceSearch.click();
		sleep(2000);
		// 获取搜索出来多少条
		String regEx = "[^0-9]";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(sourceNum.getText());

		return Integer.valueOf(matcher.replaceAll("").trim());
	}
	
	
	

}
