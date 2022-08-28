package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	public void selectFromDropdown(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public boolean isPresentInDropDown(WebElement element, String visibleText) {

		Select select = new Select(element);
		List<WebElement> dropdown_data = select.getOptions();
		for (WebElement i : dropdown_data) {
			if (i.getText().equals(visibleText))
				return true;
		}
		return false;
	}

	public int generateRandomNum(int maxBound) {

		Random rand = new Random();
		int randomnum = rand.nextInt(maxBound);
		return randomnum;
	}

}
