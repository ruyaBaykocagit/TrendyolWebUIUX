@7
Feature:US_007 Bir kullanıcı olarak, istedigim urune tiklayip urun detayini, yorumlari ve puanlamayi gormek istiyorum
  @71
  Scenario: TC_001 Kullanıcı, istedigi urune tiklayinca o urunun resmini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici istedigi urunun detaylarini gorur

  @72
  Scenario: TC_002 Kullanıcı, istedigi urune tiklayinca o urunun fiyaini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici istedigi urunun yorumlarini gorur


  Scenario: TC_003 Kullanıcı, istedigi urune tiklayinca o urunun bedenini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici istedigi urunun puanlamasini gorur
