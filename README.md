
# 🛍️ Trendyol Web Test Automation Project

This project is created to test the web platform of [Trendyol.com](https://www.trendyol.com/) using end-to-end UI automation flows. Tests are written using Java (JDK 17), Selenium WebDriver, and Cucumber with JUnit. Test results are visualized using Allure Reports.

The main goal is to validate search, filter, and product page flows in the Trendyol UI.

---

## 🚀 Technologies and Tools Used

| Technology / Tool     | Description |
|------------------------|-------------|
| Java (JDK 17)          | Programming language for writing test scripts |
| Selenium WebDriver     | Web UI automation library |
| Cucumber + JUnit       | BDD framework using Gherkin syntax |
| Maven                  | Build and dependency management tool |
| IntelliJ IDEA          | Recommended IDE for development |
| Allure Reports         | Test reporting and visual result dashboard |
| Log4j2                 | Logging mechanism |
| Apache POI             | Reading Excel test data |
| WebDriverManager       | Driver management |

---

## 🧪 Test Environment

- **Platform**: Trendyol.com (Desktop Web Application)
- **Browsers**: Chrome (latest)
- **Automation Type**: End-to-End UI Test Automation
- **Test Framework**: Cucumber + JUnit
- **Reports**: Allure

---

## 📁 Project Structure

```
TrendyolWebUIUX/
├── .idea/ # IntelliJ project settings
├── allure-results/ # Allure report output
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── config/ # Configuration management
│ │ ├── Data/ # Test data files and models
│ │ ├── driver/ # WebDriver setup (DriverManager)
│ │ └── page/ # Page Object Model (POM) classes
│ │ ├── AddToCartPage.java
│ │ ├── HomePage.java
│ │ ├── SearchResultsPage.java
│ │ └── ShoppingCartPage.java
│ └── test/
│ ├── java/
│ │ ├── steps/ # Step definitions (Glue Code)
│ │ │ └── utilities/ # Utility classes
│ │ └── TestRunner.java # Cucumber Test Runner
│ └── resources/
│ ├── features/
│ │ ├── UI-FUNC-MNL-001/
│ │ │ ├── US_001.feature
│ │ │ └── US_002.feature
│ │ ├── UI-FUNC-MNL-002/
│ │ │ ├── US_003.feature
│ │ │ ├── US_004.feature
│ │ │ └── US_005.feature
│ │ └── UI-FUNC-MNL-003/
│ │ ├── US_006.feature
│ │ ├── US_007.feature
│ │ └── US_008.feature
│ └── config.properties
├── pom.xml # Maven dependencies & plugins
├── .gitignore
└── README.md
```

---

## 🧭 Test Scope (User Stories)
## 📋 User Stories Durum Tablosu

| ID      | User Story Açıklaması                                                                 | Durum   |
|---------|---------------------------------------------------------------------------------------|---------|
| US_001  | ➕ Ziyaretçi olarak, sepetime eklediğim ürünün adedini artırıp azaltabilmek istiyorum.| ✅ Done |
| US_002  | 🗑️ Ziyaretçi olarak, istemediğim ürünü sepetimden silebilmek istiyorum.               | ✅ Done |
| US_003  | 🔍 Kullanıcı olarak, “çanta” araması yaparak yalnızca ilgili ürünleri görmek istiyorum.| ✅ Done |
| US_004  | 🧰 Kullanıcı olarak, çanta ürünleri arasında kategori, marka ve fiyat filtreleri ile aradığım ürünü daha kolay bulmak istiyorum.| ✅ Done |
| US_005  | 📊 Kullanıcı olarak, çanta ürünlerini fiyata veya popülerliğe göre sıralayarak aradığım ürünü daha kolay bulmak istiyorum.| ✅ Done |
| US_006  | 🖼️ Kullanıcı olarak, istediğim ürünün resmini, fiyatını ve beden seçeneklerini görmek istiyorum.| ✅ Done |
| US_007  | 📝 Kullanıcı olarak, ürün detayını, yorumları ve puanlamayı görüntülemek istiyorum.  | ✅ Done |
| US_008  | 🛒 Kullanıcı olarak, istediğim ürünü sepete eklemek istiyorum.                        | ✅ Done |

---

## 📊 Test Execution and Reporting

Test cases are executed using Cucumber JUnit Runner. Allure is used for generating dynamic and visual HTML reports.

### Run Tests

```bash
mvn clean test
```

### Generate Allure Report

```bash
allure serve target/allure-results
```

---

## 👩‍💻 Team Members

| Name               | Role         | LinkedIn |
|--------------------|--------------|--------|
| Elif D. Kavlak     | QA Engineer  |linkedin.com/in/elif-demirci-kavlak |
| Yelda Akbulut      | QA Engineer  |linkedin.com/in/yelda-akbulut|
| Rüya Z.Ç. Baykoca  | QA Engineer  |linkedin.com/in/rüya-zeliha-çelik-baykoca |





