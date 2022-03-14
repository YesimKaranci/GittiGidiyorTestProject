Feature:Gittigidiyor test senaryoları

  @Sepete_Ürün_Ekleme
  Scenario Outline: Sepete Ürün Ekleme
    Then Web sitesinin açıldığı kontrol edilir
    And Arama alanına <product> yazılır
    And Sayfanın sonuna gidilir
    And Çerezler uyarısı kapatılır
    And Arama sonuçları sayfasından ikinci sayfa açılır
    Then Sayfaya gidildiği kontrol edilir
    And Rastgele bir ürün seçilir
    And Seçilen ürün bilgi ve tutar bilgisi dosyaya yazılır
    And Ürün sepete eklenir
    And Sepete gidilir
    And Ürün sayfasındaki fiyat ile sepete eklenen ürün fiyatı karşılaştırılır
    And Sepet ürün adedi artırılır
    And Ürün sepetten silinir
    Then Sepetin boş olduğu kontrol edilir

    Examples:
      | product |
      | bilgisayar |




