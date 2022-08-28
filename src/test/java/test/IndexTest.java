package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.IndexPage;
import util.BrowserFactory;

public class IndexTest {

	WebDriver driver;
	IndexPage indexPage;
	
//	Test 1: Validate a user is able to add a category and once the category is added it should display.
//	@Test
	public void validateAddCategory() {
		
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.insertCategoryData("check12");
		indexPage.clickAddCategory();
		indexPage.validateIsCategoryAdded();
		BrowserFactory.tearDown();
		
	}
	/*
	 * Test 2: Validate a user is not able to add a duplicated category. If it does then the following message will display:
	 *  "The category you want to add already exists: <duplicated category name>."
	 */
//	@Test
	public void usershouldNotBeAbleToAddDuplicateCategory() {
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.insertDuplicateData("check12");
		indexPage.clickAddCategory();
		indexPage.validateCategoryAlreadyExists();
		BrowserFactory.tearDown();
		
	}
	/*
	 * Test 3: Validate the month drop down has all the months (jan, feb, mar ...)
	 *  in the Due Date dropdown section.
	 */
	@Test
	public void userShouldBeableToRemoveAllItemsWithtoggleAllAndRemoveButton() {
		driver = BrowserFactory.init();
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.validateAllMonthsArePresentInDueDateDropdown();		
		BrowserFactory.tearDown();
	}

}
