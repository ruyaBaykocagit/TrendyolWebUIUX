Feature: US_005 Bir kullanıcı olarak, çanta ürünlerini fiyata veya popülerliğe göre sıralayarak,
  bütçeme uygun ya da diğer kullanıcılar tarafından tercih edilen ürünleri daha hızlı bulmak istiyorum,
  böylece alışveriş sürecimi kolaylaştırabilirim.

  Scenario: TC_001 Bir kullanıcı olarak, çantaları en uygun fiyatlı olandan başlayarak sıralamak istiyorum,
  böylece bütçeme uygun ürünü daha hızlı bulabilirim.

    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    Then Kullanıcı sayfanın sağ (veya üst) kısmındaki filtreleme panelini görür.
    When Kullanıcı sıralamadan “En Düşük Fiyat” filtresi seçer.
    Then Kullanıcı, en düşük fiyat filtresi uygulandıktan sonra listelenen ürünlerin seçtigi filtrelere uygun olduğunu doğrular
    And  Kullanıcı anasayfaya geri doner


  Scenario: TC_002 Bir kullanıcı olarak, diğer kullanıcılar tarafından en çok satın alınan çantaları
  üst sıralarda görmek istiyorum, çünkü bu ürünler genelde daha güvenilirdir ve bu sıralama alışverişimi kolaylaştırır.
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    Then Kullanıcı sayfanın sağ (veya üst) kısmındaki filtreleme panelini görür.
    When Kullanıcı sıralamadan“En Çok Satan” filtresi seçer.
    Then Kullanıcı, en cok satan filtre uygulandıktan sonra listelenen ürünlerin seçtigim filtrelere uygun olduğunu doğrular.
    And  Kullanıcı anasayfaya geri doner
  @t2
  Scenario: TC_003 Bir kullanıcı olarak, çanta ürünlerini fiyata göre sıralayarak ve
  fiyat aralığını da seçerek bütçeme uygun ürünleri daha hızlı bulmak istiyorum, böylece alışveriş sürecimi kolaylaştırabilirim.
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    When Kullanici dil ayarlarini yapar
    When Kullanıcı arama kutusuna "çanta" yazar
    Then Kullanıcı arama sonucu cıkan listeyi dogrular
    Then Kullanıcı sayfanın sağ (veya üst) kısmındaki filtreleme panelini görür.
    When Kullanıcı “Fiyat” filtresi altında yer alan “200-450 TL” seçeneğini işaretler.
    When Kullanıcı sıralamadan “En Düşük Fiyat” filtresi seçer.
    Then İlgili filtreler uygulandıktan sonra listelenen ürünlerin seçtigim filtrelere uygun olduğunu doğrular.
    And  Kullanıcı anasayfaya geri doner