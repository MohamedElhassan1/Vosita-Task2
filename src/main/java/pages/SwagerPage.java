package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagerPage extends PageBase {
    public SwagerPage(WebDriver driver) {super(driver);}
    @FindBy(xpath = "/html/body/div/section/div[2]/div[2]/div[2]/section/label/select")
    public WebElement list;




}
