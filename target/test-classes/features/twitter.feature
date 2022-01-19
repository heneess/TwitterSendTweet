@Test
Feature: US_001

  Scenario:TC_001 kullanici basarili twitter girisi

    Given kullanici "url"e gider
    And email kutusunda "valid_email"girer
    And ileri butonuna tiklar
    And "valid_sifre"girer
    And giris yapar
    And basarili bir giris yapildigi test edilir
    #And sayfayi kapatir

  Scenario: TC_002 kullanici tvit atar

    Given kullanici "url"e gider
    And email kutusunda "valid_email"girer
    And ileri butonuna tiklar
    And "valid_sifre"girer
    And giris yapar
    And basarili bir giris yapildigi test edilir
    

