Feature:US_002 Bir ziyaretçi olarak, istemediğim bir ürünü sepetimden silebilmek istiyorum,
  böylece yalnızca satın almak istediğim ürünlerle alışverişe devam edebileyim.

  Background: TC_01 | TC_02
    Given Ziyaretci verilen Url ile siteye gider
    Then Ziyareci siteye giris sagladigini dogrular
    When Acilan reklamda kategoriyi secer
    When Ziyaretci arama kutusuna tiklar , "mont" yazar ve aratır
    And Ziyaretci urunun gorunurlugunu dogrular ve urun uzerine tiklar
    And Acilan onboarding "Anladım" butonuna tiklar
    Then Ziyaretci sepete ekle butonuna tiklar ve 'Sepete Eklendi' yazisini görerek dogrular

  Scenario: TC_03 Sepete eklenen urun için silme secenegi goruntulenmesinin test edilmesi
    Given Ziyaretci urunun kontrolu icin Sepetim'e e gider
    Then Sepetten urun cıkarmak ici Sil ikonunu goruntulendıgını dogrular

  Scenario: TC_04 ZiyaretCi ürünü silme butonuna tıklayarak (sayfa yenilemeden) anında silebilmelisi
    Given Ziyaretci urunun kontrolu icin Sepetim'e e gider
    Then Ziyaretci ekledigi urunu sepetten siler ve silindigini dogrular

  Scenario: TC_05  Urun silindiginde toplam tutar otomatik(sayfa yenilenmeden) güncellenmesinin test edilmesi
    Given Ziyaretci urunun kontrolu icin Sepetim'e e gider
    Then Ziyaretci urunu sildiginde Siparis Ozeti kismindaki tutarin guncellendigini dogrular