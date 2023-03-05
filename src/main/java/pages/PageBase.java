package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageBase {
    protected WebDriver driver;
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
