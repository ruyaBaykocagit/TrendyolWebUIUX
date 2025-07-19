@6
Feature:US_006 Bir kullanıcı olarak, istedigim urune tiklayip resmini, fiyatini ve size gormek istiyorum
@61
  Scenario: TC_001 Kullanıcı, istedigi urune tiklayinca o urunun resmini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici istedigi urunun resmini gorur


  Scenario: TC_002 Kullanıcı, istedigi urune tiklayinca o urunun fiyaini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici istedigi urunun fiyatini gorur
@63

  Scenario: TC_003 Kullanıcı, istedigi urune tiklayinca o urunun bedenini gorebilmelidir
    Given Kullanıcı URL ile siteye giris yapar
    And Kullanici cookiesleri kabul eder
    Then Kullanici dil ayarlarini yapar
    Then Kullanıcı anasayfada olduğunu dogrular
    Then Kullanıcı istedigi herhangi bir urunu secer ve uzerine tıklar
    And Kullanici simdi al butonunu gorur

