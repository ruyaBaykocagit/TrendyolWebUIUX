Feature: US_004 Bir kullanıcı olarak, çanta ürünleri arasında kategori,
  marka ve fiyat filtrelerini kullanarak aradığım ürüne daha hızlı ve kolay ulaşmak istiyorum,
  böylece tercihlerime ve bütçeme uygun çantalara kolayca erişebilirim.


  Scenario: TC_001 Bir kullanıcı olarak, çanta ürünleri arasında sadece "omuz çantası" gibi
  belirli bir kategoriyi filtreleyerek aradığım ürünleri daha kolay bulmak istiyorum.
    Given   Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    When Kullanıcı sayfanın sol (veya üst) kısmındaki filtreleme panelini görür.
    And Kullanıcı “Kategori” filtresi altında yer alan “Omuz Çantası” seçeneğini işaretler.
    Then Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin yalnızca "omuz çantası" kategorisine ait olduğunu doğrular.
    And  Kullanıcı anasayfaya geri doner


  Scenario: TC_002 Bir kullanıcı olarak, sadece ilgilendiğim markalara ait çantaları görmek istiyorum,
  böylece tercihlerime uygun ürünlere ulaşabilirim.
    Given   Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    When Kullanıcı sayfanın sol (veya üst) kısmındaki filtreleme panelini görür.
    And Kullanıcı “Marka” filtresi altında yer alan “Mango” seçeneğini işaretler.
    Then Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin yalnızca "Mango" markasına ait olduğunu doğrular.
    And  Kullanıcı anasayfaya geri doner

  @t1
  Scenario: TC_003 Bir kullanıcı olarak, bütçeme uygun çantaları görebilmek için fiyat filtresini kullanmak istiyorum.
    Given   Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    When Kullanıcı sayfanın sol (veya üst) kısmındaki filtreleme panelini görür.
    And Kullanıcı “Fiyat” filtresi altında yer alan “200-450 TL” seçeneğini işaretler.
    Then Kullanıcı, filtre uygulandıktan sonra listelenen ürünlerin seçtigim filtrelere uygun olduğunu doğrular.
    And  Kullanıcı anasayfaya geri doner