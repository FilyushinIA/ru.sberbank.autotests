package ru.sberbank.autotests;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    public RegionsWidget changeRegionButtonClick() {
        $(By.xpath("//span[@class='region-list__arrow']")).click();
        return page(RegionsWidget.class);
    }

    public SelenideElement regionNameField() {
        return $(By.xpath("//span[@class='region-list__name']"));
    }

    public void scroll() {
        $(By.xpath("//p[@class='footer-info__copyright']")).scrollTo();
    }

    public void hasSocialItem(final String value) {

        ElementsCollection socialItems = $$(By.xpath("//li[@class=\"social__item\"]/a"));
        for (SelenideElement item : socialItems) {
            String attr = item.getAttribute("href");
            if (attr.contains(value)) return;
        }
        Assert.fail("Ссылка на " + value + " не найдена!");
    }
}

