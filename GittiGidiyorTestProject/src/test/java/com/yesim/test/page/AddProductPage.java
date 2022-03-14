package com.yesim.test.page;

import com.yesim.test.contracts.IAddProductPage;
import com.yesim.test.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.util.List;

public class AddProductPage extends BasePageUtil implements IAddProductPage {

    public By searchText=By.xpath("//div[@class='sc-4995aq-4 dNPmGY']//input[@type='text']");
    public By secondPage=By.cssSelector("a[title='2. sayfa']");
    public By ariaCurrent=By.cssSelector("a[aria-current='true']");
    public By cookies = By.cssSelector("a[class='tyj39b-5 bEEsJG']");
    public By cookies2 = By.cssSelector("div[class='gg-ui-button gg-ui-btn-secondary policy-alert-v2-buttons']");
    public By productPrice = By.xpath("(//div[@id='sp-price-lowPrice'])[1]");
    public By product = By.xpath("//h2[@class='sc-1ku3a4v-0 sc-7u3xly-0 clhtrN jytHfD sc-1n49x8z-16 khXIrI']");
    public By addToBasket = By.xpath("//button[@id='add-to-basket']");
    public By myBasket = By.cssSelector("span[class='basket-title']");
    public By totalPrice = By.cssSelector("div[class='total-price']");
    public By countInput = By.cssSelector("li[id='product-collection-button']");
    public By amount = By.xpath("//select[@class='amount']");
    public By selectAmount = By.xpath("//select[@class='amount']//option[@value='2']");
    public By delete = By.xpath("(//a[@title='Sil'])[1]");
    public By emptyContainerIcon = By.xpath("//*[@id='empty-cart-container']//*[@class='gg-icon gg-icon-cart']");
    public By emptyContainerMessage = By.xpath("//*[@id='empty-cart-container']//*[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']");
    public By maxAmount = By.xpath("//*[@class='amount']");

    @Override
    public void checkHomePage() {

        Assert.assertTrue("Web sitesi görüntülenmedi!",isElementDisplayed(searchText));
    }

    @Override
    public void keywordSearch(String keyword) {
        sendKeys(searchText,keyword);
        keyENTER(searchText);
    }

    @Override
    public void scrollPage() {
        hoverElement(secondPage);
    }

    @Override
    public void closedCookies() {
        click(cookies);
    }

    @Override
    public void secondPage() {
        click(secondPage);
    }

    @Override
    public void checkSecondPage() {
        hoverElement(secondPage);
        Assert.assertTrue("Sayfa görüntülenemedi!",isEnabled(ariaCurrent));
    }

    @Override
    public void fileWriter() {

            try {
                FileWriter fw = new FileWriter("src/test/resources/dosya.txt");
                PrintWriter pw = new PrintWriter(fw);
                String text = getText(productPrice);
                System.out.println("Ürün fiyatı : " + text);
                pw.write(text);
                pw.close();
            }
            catch (IOException e){
                System.out.println("HATA !!!");
            }
    }

    @Override
    public void addToBasket() {
        click(cookies2);
        hoverElement(countInput);
        click(addToBasket);
        thread(3000);
    }

    @Override
    public void matchProductPrice() {
        String price;
        try {
        BufferedReader str = new BufferedReader(new FileReader("src/test/resources/dosya.txt"));
        while ((price = str.readLine()) != null){
            System.out.println(price);
            Assert.assertEquals("Fiyatlar eşleşmiyor!!!" , price,getText(totalPrice));
            }
        }
        catch (IOException e){
            System.out.println("HATA !!!");
        }
    }

    @Override
    public void clickBasket() {
        click(myBasket);
    }

    @Override
    public void sayiArtir() {

        if(getAttribute(maxAmount,"data-maxamount") != "1"){
            click(amount);
            click(selectAmount);
            doubleClick(selectAmount);
            Assert.assertEquals("Ürün adedi artırılamadı!", "2", getAttribute(amount, "value"));

        }
        else {
            System.out.println("Son adet ürün kaldığından sepet ürün sayısı artırılamadı!!!" +getAttribute(maxAmount,"data-maxamount"));
        }

    }

    @Override
    public void deleteProduct() {
        click(delete);
    }

    @Override
    public void emptyCartContainer() {
        thread(2000);
        Assert.assertTrue("Sepetiniz boş değil " , isElementDisplayed(emptyContainerMessage));
        Assert.assertTrue("Sepetiniz boş değil " , isElementDisplayed(emptyContainerIcon));
    }

    @Override
    public void selectProduct() {
        thread(1000);
        List<WebElement> resultTitles = driver.findElements(By.xpath("//h2[@class='sc-1ku3a4v-0 sc-7u3xly-0 clhtrN jytHfD sc-1n49x8z-16 khXIrI']"));
            if (resultTitles != null && !resultTitles.isEmpty()) {
                    System.out.println("Listenin son elemanı" + resultTitles.size());
                    resultTitles.get(28).click();
        }

        }

}
