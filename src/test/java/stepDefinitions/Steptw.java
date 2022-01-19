import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.TwitterPages;
import utilities.ConfigReader;
import utilities.Driver;

public class Steptw {

    String actualUrl = "https://twitter.com/home";

    TwitterPages twitterPages=new TwitterPages();

    @Given("kullanici {string}e gider")
    public void kullaniciEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @And("email kutusunda {string}girer")
    public void emailKutusundaGirer(String valid_email) {

        twitterPages.userNameBox.sendKeys(ConfigReader.getProperty("valid_email"));

    }

    @And("ileri butonuna tiklar")
    public void ileriButonunaTiklar() {

        twitterPages.ileriButonu.click();
    }

    @And("{string}girer")
    public void girer(String valid_sifre) {
        twitterPages.password.sendKeys(ConfigReader.getProperty("valid_sifre"));
    }

    @And("giris yapar")
    public void girisYapar() {
        twitterPages.giris.click();
    }

    @And("basarili bir giris yapildigi test edilir")
    public void basariliBirGirisYapildigiTestEdilir() throws InterruptedException {

        Thread.sleep(5000);

        Assert.assertEquals("basarili giris yapilamadi!",
                ConfigReader.getProperty("basariliGirisUrl"),actualUrl);

    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("profile tiklar ve güncel tvit sayisini alir")
    public void profileTiklarVeGüncelTvitSayisiniAlir() throws InterruptedException {

        twitterPages.profil.click();
        Thread.sleep(2000);
        String eskiTvitNumber=twitterPages.eskiTvitSayisi.getText();

    }

    @And("soldaki tvitle yazisina tiklar")
    public void soldakiTvitleYazisinaTiklar() {

        twitterPages.tweetleGirisButonu.click();

    }

    @And("tviti girer ve tvitle butonuna tiklar")
    public void tvitiGirerVeTvitleButonunaTiklar() throws InterruptedException {

        twitterPages.tweetText.sendKeys("bu bir otomasyon tweetidir.");
        Thread.sleep(2000);
        twitterPages.tweetleButonu.click();

    }

    @And("tvit atildigini kontrol eder")
    public void tvitAtildiginiKontrolEder() throws InterruptedException {

        Steptw st = new Steptw();
        st.guncelTvitSayisiniKaydeder();

    }

    @And("guncel tvit sayisini kaydeder")
    public void guncelTvitSayisiniKaydeder() throws InterruptedException {

        Thread.sleep(2000);
        String eskiTweetNumber= "";
        String yeniTweetNumber= "";
        int count= 0 ;

        while (eskiTweetNumber.length()<1 && count ==0 ) {
            eskiTweetNumber = twitterPages.eskiTvitSayisi.getText();
        }
        count++;

        while (yeniTweetNumber.length()<1 && count==2) {
            yeniTweetNumber = twitterPages.eskiTvitSayisi.getText();
            Assert.assertFalse("tweet atilmadi,bir problem var", eskiTweetNumber.equals(yeniTweetNumber));
        }


    }
}
