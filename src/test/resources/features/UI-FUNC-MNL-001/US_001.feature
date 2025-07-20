Feature:US_001 Bir ziyaretci olarak, sepetime eklediğim bir ürünün adedini artırmak veya azaltmak istiyorum,
  böylece ihtiyacım kadar ürün sipariş edebileyim.

  Background: TC_01 | TC_02
    Given Ziyaretci verilen Url ile siteye gider
    Then Ziyareci siteye giris sagladigini dogrular
    When Acilan reklamda kategoriyi secer
    When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
    And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
    And Acilan onboarding "Anladım" butonuna tiklar
    Then Ziyaretci sepete ekle butonuna tiklar ve 'Sepete Eklendi' yazisini görerek dogrular

  Scenario: TC_03 Ziyaretcinin ürün adedini "+" butonu ile artırılabilmesi
    And Ziyaretci urunun kontrolu icin Sepetim'e e gider
    And Sepetinde urunu artırabilmek icin '+' ya tiklar
    Then Sepet başarıyla güncellendi yazisini goruntuler

  Scenario: TC_04 Ziyaretcinin ürün adedini "-" butonu ile azaltabilmesi
    And Ziyaretci urunun kontrolu icin Sepetim'e e gider
    And Sepetinde urunu artırabilmek icin '+' ya tiklar
    And Sepetinde urunu artırabilmek icin '-' ya tiklar
    Then Sepet başarıyla güncellendi yazisini goruntuler

  Scenario: TC_05 Ürün adeti degistiginde fiyat ve adetin anlık güncellenmesinin test edilmesi
    And Ziyaretci urunun kontrolu icin Sepetim'e e gider
    Then Ziyaretci urunun adetini degistirdiginde fiyat guncellenmeli