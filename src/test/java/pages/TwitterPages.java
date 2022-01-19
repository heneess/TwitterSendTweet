package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TwitterPages {

    public TwitterPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name="text")
    public WebElement userNameBox;

    @FindBy(xpath="(//div[@dir='auto'])[7]")
    public WebElement ileriButonu;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="(//div[@dir='auto'])[9]")
    public WebElement giris;

    @FindBy(xpath="//span[text()='Profil']")
    public WebElement profil;

    @FindBy(xpath = "(//div[@dir='auto'])[19]")
    public WebElement eskiTvitSayisi;

    @FindBy(xpath = "//span[text()='Tweetle']")
    public WebElement tweetleGirisButonu;

    @FindBy(xpath = "//div[@aria-autocomplete='list']")
    public WebElement tweetText;

    @FindBy(xpath = "(//span[text()='Tweetle'])[1]")
    public WebElement tweetleButonu;



}
