Feature:US_001 Bir ziyaretci olarak, sepetime eklediğim bir ürünün adedini artırmak veya azaltmak istiyorum,
  böylece ihtiyacım kadar ürün sipariş edebileyim.

  Background:
    Given Ziyaretci verilen Url ile siteye gider

  Scenario: TC_01 Ziyaretcinin URL ile siteye giriş yapabilmesinin test edilmesi
    Then Ziyareci siteye giris sagladigini dogrular

  Scenario: TC_02 Ziyaretcinin sepete ürün ekleyebilmesinin test edilmesi
    When Acilan reklamda kategoriyi secer
    When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
    And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
    And Acilan onboarding "Anladım" butonuna tiklar
    Then Ziyaretci sepete ekle butonuna tiklar ve 'Sepete Eklendi' yazisini görerek dogrular

  Scenario: TC_03 Ziyaretcinin ürün adedini "+" butonu ile artırılabilmesi
    When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
    And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
    And Ziyaretci urunun kontrolu icin 'Sepetim' e gider
    And Sepetinde urunu artırabilmek icin '+' ya tiklar
    Then 'Sepet başarıyla güncellendi' yazisini goruntuler
    Then Ziyaretci urunun arttigini goruntuler

    Scenario: TC_04 Ziyaretcinin ürün adedini "-" butonu ile azaltabilmesi
      When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
      And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
      And Ziyaretci urunun kontrolu icin 'Sepetim' e gider
      And Sepetinde urunu artırabilmek icin '-' ya tiklar
      Then 'Sepet başarıyla güncellendi' yazisini goruntuler
      Then Ziyaretci urunun azaldigini goruntuler

    Scenario: TC_05 Ürün adeti degistiginde fiyat ve adetin anlık güncellenmesinin test edilmesi

