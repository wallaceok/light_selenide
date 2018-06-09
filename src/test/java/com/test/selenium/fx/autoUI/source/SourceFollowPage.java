package com.test.selenium.fx.autoUI.source;

import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenideElementIterator;
import com.codeborne.selenide.impl.SelenideFieldDecorator;

import static com.codeborne.selenide.Selenide.sleep;

public class SourceFollowPage {
	// 搜索按钮
	@FindBy(xpath = ".//*[@id='search']")
	public SelenideElement searchButton;
	// 清空搜索按钮
	@FindBy(xpath = ".//*[@id='search-trace-clear']")
	public SelenideElement searchClearButton;

	// 搜索uuid文本框
	@FindBy(xpath = ".//*[@id='search-uuid']")
	public SelenideElement searchUuidText;

	// 搜索key文字
	@FindBy(xpath = ".//*[@id='search-key']")
	public SelenideElement searchKeyText;

	// 按状态搜索
	@FindBy(xpath = ".//*[@id='search-status']")
	public SelenideElement searchStatusSelect;
	// 搜索类型选择框
	@FindBy(xpath = ".//*[@id='search-type']")
	public SelenideElement searchTypeSelect;

	// 搜索房客源和不限 选项
	@FindBy(xpath = ".//*[@id='search-category']")
	public SelenideElement searchCategorySelect;
	// 搜索租售状态选项
	@FindBy(xpath = ".//*[@id='search-lease']")
	public SelenideElement searchLease;

	@FindBy(xpath = ".//a[@class='erp-state_operate ng-scope']/span[text()='有效']")
	public SelenideElement effectiveAuditingLinkSet;

	@FindBy(xpath = ".//a[@class='erp-state_operate ng-scope' and text()='置顶']")
	public SelenideElement setTopLinkSet;

	@FindBy(xpath = ".//a[@class='erp-state_operate ng-scope' and text()='取消置顶']")
	public SelenideElement cancelSetTopLinkSet;

	@FindBy(xpath = ".//a[@class='erp-state_operate ng-scope']/span[text()='无效']")
	public SelenideElement invalidAuditingLinkSet;

	// 检查点 查看有效
	@FindBy(xpath = ".//*[@class='common-padding-top text-center ng-scope']/span[text()='有效']")
	public SelenideElement effectiveStatusCheck;
	// 反审操作连接
	@FindBy(xpath = ".//*[@class='erp-state_operate ng-scope']/span[text()='反审']")
	public SelenideElement noAuditing;
	//反审 后状态 检查点
	 @FindBy(xpath=".//*[@class='common-padding-top text-center ng-scope']/span[text()='无效']")
	 public SelenideElement noAuditingCheck;
	//
	// @FindBy(xpath="")
	// public SelenideElement ass;

	/**
	 * 有效审核
	 * 
	 * @param uuid
	 * @return
	 */
	public String auditing(String uuid) {

		// 搜索
		searchUuidText.setValue(uuid);

		searchButton.click();

		sleep(1000);
		// 点击列表中第一个有效按钮 因为刚创建的就在第一个
		effectiveAuditingLinkSet.click();

		sleep(3000);

		return effectiveStatusCheck.getText();
	}

	/**
	 * 反审操作
	 * 
	 * @return 返回
	 */
	public String noAuditing() {

		sleep(1000);
		// 点击列表中第一个有效按钮
		noAuditing.click();

		sleep(3000);

		return noAuditingCheck.getText();
	}
}
