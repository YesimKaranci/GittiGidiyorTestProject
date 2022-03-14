package com.yesim.test.tests;

import com.yesim.test.contracts.IAddProductPage;
import com.yesim.test.page.AddProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AddProductTest {

    public IAddProductPage addProductPage = new AddProductPage();

    @Then("^Web sitesinin açıldığı kontrol edilir$")
    public void webSitesininAçıldığıKontrolEdilir() {
        addProductPage.checkHomePage();
    }

    @And("^Arama alanına ([^\"]*) yazılır$")
    public void aramaAlanınaProductYazılır(String keyword) {

        addProductPage.keywordSearch(keyword);
    }

    @And("^Arama sonuçları sayfasından ikinci sayfa açılır$")
    public void aramaSonuçlarıSayfasındanIkinciSayfaAçılır() {
        addProductPage.secondPage();
    }

    @Then("^Sayfaya gidildiği kontrol edilir$")
    public void sayfayaGidildiğiKontrolEdilir() {
        addProductPage.checkSecondPage();
    }

    @And("^Sayfanın sonuna gidilir$")
    public void sayfanınSonunaGidilir() {
        addProductPage.scrollPage();
    }

    @And("^Çerezler uyarısı kapatılır$")
    public void çerezlerUyarısıKapatılır() {
        addProductPage.closedCookies();
    }

    @And("^Rastgele bir ürün seçilir$")
    public void rastgeleBirÜrünSeçilir() {
        addProductPage.selectProduct();
    }

    @And("^Seçilen ürün bilgi ve tutar bilgisi dosyaya yazılır$")
    public void seçilenÜrünBilgiVeTutarBilgisiDosyayaYazılır() {
        addProductPage.fileWriter();
    }

    @And("^Ürün sepete eklenir$")
    public void ürünSepeteEklenir() {
        addProductPage.addToBasket();
    }

    @And("^Ürün sayfasındaki fiyat ile sepete eklenen ürün fiyatı karşılaştırılır$")
    public void ürünSayfasındakiFiyatIleSepeteEklenenÜrünFiyatıKarşılaştırılır() {
        addProductPage.matchProductPrice();
    }

    @And("^Sepete gidilir$")
    public void sepeteGidilir() {
        addProductPage.clickBasket();
    }

    @And("^Sepet ürün adedi artırılır$")
    public void sepetÜrünAdediArtırılır() {
        addProductPage.sayiArtir();
    }

    @And("^Ürün sepetten silinir$")
    public void ürünSepettenSilinir() {
        addProductPage.deleteProduct();
    }

    @Then("^Sepetin boş olduğu kontrol edilir$")
    public void sepetinBoşOlduğuKontrolEdilir() {
        addProductPage.emptyCartContainer();
    }
}
