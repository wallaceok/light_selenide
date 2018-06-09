package com.test.selenium.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;

public class SearchResultsPage {
	public ElementsCollection getResults() {
	    return $$(By.xpath(".//*[contains(@class, 'c-container')]"));
	  }
	  public SelenideElement getResult(int index) {
	    return $(By.xpath(".//*[contains(@class, 'c-container')]"), index);
	  }
}
