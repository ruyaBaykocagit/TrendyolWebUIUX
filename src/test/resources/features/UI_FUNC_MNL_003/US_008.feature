@8
Feature:US_008 Bir kullanıcı olarak, istedigim urune tiklayip sepete eklemek istiyorum

  Scenario: TC_001 Kullanıcı, istedigi urune tiklayinca o urunun resmini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici  sepete ekle butonunu gorur ve tiklar

@82
  Scenario: TC_002 Kullanıcı, istedigi urune tiklayinca o urunun fiyaini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici  sepete ekle butonunu gorur ve tiklar
    And Kullanici sepete git butonunu gorur

  @83
  Scenario: TC_003 Kullanıcı, istedigi urune tiklayinca o urunun bedenini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici  sepete ekle butonunu gorur ve tiklar
    And Kullanici sectigi urunu basariyla sepete ekler
