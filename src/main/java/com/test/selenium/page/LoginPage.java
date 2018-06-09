
package com.test.selenium.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
	
	public SearchResultsPage searchFor(String text) {
	    $(By.id("kw")).val(text).pressEnter();
	    return page(SearchResultsPage.class);
	  }

}
