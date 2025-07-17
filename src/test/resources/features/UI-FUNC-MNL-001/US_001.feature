Feature:US_001 Bir ziyaretci olarak, sepetime eklediğim bir ürünün adedini artırmak veya azaltmak istiyorum,
  böylece ihtiyacım kadar ürün sipariş edebileyim.


    Scenario: TC_01 Ziyaretçinin URL ile siteye giriş yapabilmesinin test edilmesi
      Given Ziyaretci verilen Url ile siteye gider
      Then Ziyareci siteye giris sagladigini dogrular

    Scenario: TC_02 Ziyaretçinin sepete ürün ekleyebilmesinin test edilmesi
      Given Ziyaretci verilen Url ile siteye gider
      When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
      And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
      Then Ziyaretci sepete ekle butonuna tiklar ve 'Sepete Eklendi' yazisini görerek dogrular


    Scenario: TC_03 Ziyaretçinin ürün adedini "+" butonu ile artırılabilmesi
      Given Ziyaretci verilen Url ile siteye gider
      When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
      And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
      And Ziyaretci urunun kontrolu icin 'Sepetim' e gider
      And Sepetinde urunu artırabilmek icin '+' ya tiklar
      Then 'Sepet başarıyla güncellendi' yazisini goruntuler
      Then Ziyaretci urunun arttigini goruntuler
