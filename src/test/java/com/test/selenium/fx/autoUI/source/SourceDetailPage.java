package com.test.selenium.fx.autoUI.source;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class SourceDetailPage {

	@FindBy(xpath = ".//*[@id='fangxin']/ul[1]/li[2]/ul/li[1]/a")
	public SelenideElement soruceList;

	// 房源添加按钮
	@FindBy(xpath = ".//button[@class='btn btn-sm erp-btn_add']")
	public SelenideElement sourceAdd;

	// 添加房源-基本信息
	// 添加房源窗口的小区 文本柜
	//
	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/form/table/tbody/tr[1]/td[2]/div/div/span")
	public SelenideElement villageFieldClick;

	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/form/table/tbody/tr[1]/td[2]/div/input[1]")
	public SelenideElement villageFieldText;
	// 选择小区
	@FindBy(xpath = ".//*[@id='ui-select-choices-row-0-0']/span")
	public SelenideElement selectVillage;
	// 新增房源的 栋信息框
	@FindBy(xpath = ".//*[@id='ridgepole_name']")
	public SelenideElement ridgepoleName;
	// 新增房源的 单元信息框
	@FindBy(xpath = ".//*[@id='unity_name']")
	public SelenideElement unityName;
	// 新增房源的 层信息框
	@FindBy(xpath = ".//*[@id='floor_name']")
	public SelenideElement floorName;
	// 新增房源的 总层信息框
	@FindBy(xpath = ".//*[@id='total_floor']")
	public SelenideElement totalFloor;
	// 新增房源的 房间号信息框
	@FindBy(xpath = ".//*[@id='door_name']")
	public SelenideElement doorName;
	// 新增房源的 业主姓名信息框
	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/form/table/tbody/tr[3]/td[2]/div[1]/input")
	public SelenideElement ownerName;
	// 新增房源的 业主手机号信息框
	@FindBy(xpath = ".//*[@id='main-window']/div[1]/div/div/div/div[2]/form/table/tbody/tr[4]/td[2]/div[1]/input")
	public SelenideElement mobileNum;
	// 核盘并开盘
	@FindBy(xpath = ".//*[@class='btn btn-sm erp-btn_audit ladda-button']")
	public SelenideElement newSourceDetail;

	/**
	 * 以下是开盘详情元素集合
	 */
	@FindBy(xpath = ".//input[@placeholder='卧室']")
	public SelenideElement bedRoom;
	// 面积
	@FindBy(xpath = ".//input[@placeholder='建筑']")
	public SelenideElement area;

	/**
	 * 售价
	 */
	@FindBy(xpath = ".//div[@class='form-group input-group form-sj' and @title='报价']/input")
	public SelenideElement price;

	/**
	 * 底价
	 */
	@FindBy(xpath = ".//div[@class='form-group input-group form-sj3' and @title='底价']/input")
	public SelenideElement floorPrice;

	// 出售开盘
	@FindBy(xpath = ".//*[@id='source-detail']/div/form/div[1]/div/div/div[2]/div[4]/div/div/div[1]/button")
	public SelenideElement quotationA;
	// 出租开盘
	@FindBy(xpath = ".//*[@id='source-detail']/div/form/div[1]/div/div/div[2]/div[5]/div/div/div[1]/button")
	public SelenideElement quotationB;
	// 保存按钮
	@FindBy(xpath = ".//*[@id='source-detail']/div/form/div[5]/div/button[3]")
	public SelenideElement save;
	/**
	 * 跟进按钮
	 */
	@FindBy(xpath = ".//*[@id='source-detail']/div/form/div[4]/div/div/div/div/div[2]/button")
	public SelenideElement follow;

	@FindBy(xpath = ".//*[@id='create-trace-option']")
	public SelenideElement normalFollow;

	// 跟进方式
	@FindBy(xpath = ".//select[@class='form-control select-sm ng-pristine ng-untouched ng-scope ng-empty ng-invalid ng-invalid-required']")
	public SelenideElement followMode;

	@FindBy(xpath = ".//*[@class='form-group-right-content']/textarea")
	public SelenideElement followContent;

	@FindBy(xpath = ".//button[@class='btn btn-sm erp-btn_success ladda-button']")
	public SelenideElement followSubmit;

	// 列表集合
	@FindBy(xpath = ".//*[@class='ui-grid-canvas']/div/div")
	public SelenideElement sourcelist;

	// 搜索出几条数据
	@FindBy(xpath = ".//*[@id='gird_sources']/div[2]/div/div[1]/label")
	public SelenideElement sourceNum;
	
	@FindBy(xpath=".//label[@id='label-uuid']")
	public SelenideElement uuid;

	public void addSource() {

		// 获取自动化楼盘门号最大的是多少 用于doorName 然后加1
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("test2JdbcTemplate");
		String sql = "SELECT  MAX(door_name) FROM  erp_agency_houses WHERE community_id = 6283";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		this.sourceAdd.click();
		this.villageFieldClick.click();
		this.villageFieldText.setValue("自动化");
		this.selectVillage.click();
		this.ridgepoleName.setValue("1");
		this.unityName.setValue("1");
		this.floorName.setValue("1");
		this.totalFloor.setValue("10");
		this.doorName.setValue(String.valueOf(count + 1));
		this.ownerName.setValue("李不中");
		this.mobileNum.setValue("13678945671");
		this.newSourceDetail.click();
		sleep(3000);
		this.bedRoom.setValue("1");
		this.area.setValue("20");
		this.price.setValue("20");
		this.floorPrice.setValue("16");
		this.quotationA.click();
		sleep(1000);
		this.save.click();

	}

	public String createFollow() {
		//让鼠标离开 表头 避免悬浮，影响点击
		sourceNum.click();
		
		
		sourcelist.$("div", 1).doubleClick();
		
		sleep(3000);
		
		String uid = uuid.getText();

		follow.waitUntil(text("创建跟进"), 3000).click();

		normalFollow.click();

		followMode.selectOption(1);

		followContent.setValue("创建跟进自动添加");
		
		
		followSubmit.click();
		
		return uid;

	}

}
