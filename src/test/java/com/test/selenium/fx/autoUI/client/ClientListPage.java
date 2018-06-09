package com.test.selenium.fx.autoUI.client;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

public class ClientListPage {
	
	//新增客源按钮
	@FindBy(xpath = ".//*[@id='mainBoard']/div/div[1]/div/div/div/div/div/div[1]/div[1]/div[1]/div[1]/button")
	public SelenideElement addClientButton;
	//查询按钮
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_search']")
	public SelenideElement searchButton;
	//清空客源搜索条件
	@FindBy(xpath = ".//*[@id='search-clear']/div/span")
	public SelenideElement cleanButton;
	//选择类型条件 
	@FindBy(xpath = ".//*[@id='search-brain-power']/a")
	public SelenideElement classSelect;
	//客源编号和手机号或姓名输入搜索条件
	@FindBy(xpath = ".//*[@id='search-input-uuid']")
	public SelenideElement magicText;
	//求购新增入口
	@FindBy(xpath = ".//*[@ng-click=\"addBuyerFirst('求购')\"]")
	public SelenideElement addBuyerButton;
	//求租新增入口
	@FindBy(xpath = ".//*[@ng-click=\"addBuyerFirst('求租')\"]")
	public SelenideElement RentingButton;
	//基本title信息
	@FindBy(xpath = ".//*[@class='modal-title' and text()='添加客源--基本信息']")
	public SelenideElement newTitleCheckPoint;
	//来源选择框
	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/form/div/div[1]/div/div/select")
	public SelenideElement newSourceSelect;
	
	@FindBy(xpath = ".//*[@class='set-select ng-pristine ng-valid ng-not-empty ng-valid-required ng-touched']")
	public SelenideElement newClassSelect;
	
	
	@FindBy(xpath = ".//*[@placeholder='姓名']")
	public SelenideElement clientNameText;
	
	@FindBy(xpath = ".//*[@placeholder='手机号码或固话']")
	public SelenideElement moblieText;
	
	@FindBy(xpath = ".//*[@class='ladda-button btn btn-sm erp-btn_success ng-scope']")
	public SelenideElement nextButton;
	//详情里的  区域选择框
	@FindBy(xpath = ".//*[@placeholder='请选择区域']")
	public SelenideElement areaSelect;
	
	@FindBy(xpath = ".//*[text()='管城']")
	public SelenideElement areaChildSelect;
	
	@FindBy(xpath = ".//div[@title='报价']/input")
	public SelenideElement baojiaText;
	
	@FindBy(xpath = ".//div[@title='底价']/input")
	public SelenideElement dijiaText;
	//建筑类型
	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/div/div/form/div[1]/div[2]/div[4]/div[3]/div/button")
	public SelenideElement builtClassButton;
	
	@FindBy(xpath=".//*[@id='main-window']/div[1]/div/div/div/div[2]/div/div/form/div[1]/div[2]/div[4]/div[3]/div/div/div/table/tbody/tr[1]/td/ul/li[1]")
	public SelenideElement builtClassOption;
	@FindBy(xpath = ".//*[@class='ladda-button btn btn-sm erp-btn_success']")
	public SelenideElement saveButton;
	
	
	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
//	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
//	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
//	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
//	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
//	
//	@FindBy(xpath = "")
//	public SelenideElement provinceSelect;
	
	int ramdom = (int) ((Math.random() * 9 + 1) * 10000000);
	public void createClientTest() {
		
		addClientButton.click();
		
		addBuyerButton.click();
		sleep(1000);
		newSourceSelect.selectOption(2);
//		newClassSelect.selectOption(2);
		clientNameText.setValue("auto"+ramdom);
		sleep(1000);
		moblieText.setValue("135"+ramdom);
		nextButton.click();
		
		sleep(1000);
		
		areaSelect.click();
		sleep(1000);
		areaChildSelect.click();
		areaSelect.click();
		baojiaText.setValue("12");
		dijiaText.setValue("15");
		
		builtClassButton.click();
		builtClassOption.click();
		saveButton.click();
		
	}
}
