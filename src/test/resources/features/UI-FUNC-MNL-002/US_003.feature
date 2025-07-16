
@1
Feature:US_003 Bir kullanıcı olarak, arama kutusuna "çanta" yazarak sadece çanta ile ilgili ürünleri görmek istiyorum,
  böylece istediğim ürünlere hızlıca ulaşabilirim.

  Scenario: TC_001 Kullanıcı HomePageden arama kutusuna çanta yazar ve ilgili urun listesi görebilmeli
    Given Kullanıcı URL ile siteye giris yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı arama kutusunu gordugunu dogrular
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    And  Kullanıcı anasayfaya geri doner
    When Browser kapatılır

  Scenario: TC_002 Kullanıcı gecersiz bir kelime girdiginde uyarı ekrani acilmali
    Given Kullanıcı URL ile siteye giris yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı arama kutusunu gordugunu dogrular
    When Kullanıcı arama kutusuna "Uçan Süpürgeli Çanta" yazar
    Then Kullanıcı ilgili uyarı yazısını gördügünü dogrular
    And  Kullanıcı anasayfaya geri doner
    When Browser kapatılır