package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class IndexPage extends BasePage {

	WebDriver driver;
	String category_name;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement categorydata_Element;
	@FindBy(how = How.XPATH, using = "//input[@value = 'Add category']")
	WebElement addCategory_Element;
	@FindBy(how = How.NAME, using = "category")
	WebElement category_dropdown_Element;
	@FindBy(how = How.NAME, using = "due_month")
	WebElement due_month_dropdown_Element;

	public void insertCategoryData(String data) {
		category_name = data+ generateRandomNum(99);
		categorydata_Element.sendKeys(category_name);
	}
	public void insertDuplicateData(String data) {
		category_name = data;
		categorydata_Element.sendKeys(category_name);
	}

	public void clickAddCategory() {
		addCategory_Element.click();
	}

//	Test 1: Validate a user is able to add a category and once the category is added it should display.
	public void validateIsCategoryAdded() {
		if(isPresentInDropDown(category_dropdown_Element, category_name))
			System.out.println("Category Data is Added");
	}
	
	/*
	 * Test 2: Validate a user is not able to add a duplicated category. If it does
	 * then the following message will display:
	 * "The category you want to add already exists: <duplicated category name>."
	 */
	public void validateCategoryAlreadyExists() {
		if(driver.getPageSource().contains("The category you want to add already exists:")) {
			System.out.println("The category you want to add already exists: " + category_name);
		}
		
	}
	
	public void validateAllMonthsArePresentInDueDateDropdown() {
		if(isPresentInDropDown(due_month_dropdown_Element, "Jan")
				&& isPresentInDropDown(due_month_dropdown_Element, "Feb")
				&& isPresentInDropDown(due_month_dropdown_Element, "Mar")
				&& isPresentInDropDown(due_month_dropdown_Element, "Apr")
				&& isPresentInDropDown(due_month_dropdown_Element, "May")
				&& isPresentInDropDown(due_month_dropdown_Element, "Jun")
				&& isPresentInDropDown(due_month_dropdown_Element, "Jul")
				&& isPresentInDropDown(due_month_dropdown_Element, "Aug")
				&& isPresentInDropDown(due_month_dropdown_Element, "Oct")
				&& isPresentInDropDown(due_month_dropdown_Element, "Nov")
				&& isPresentInDropDown(due_month_dropdown_Element, "Dec")) {
			System.out.println("All Months are Present in DueDate Dropdown");
		}
			
	}

	public boolean existsElement(String id) {
		try {
			driver.findElement(By.name(id));
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		return true;
	}

}
