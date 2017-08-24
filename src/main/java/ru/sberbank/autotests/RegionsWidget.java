package ru.sberbank.autotests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegionsWidget {


    public SelenideElement regionInput() {
        return $(By.xpath("//input[@placeholder='Введите название региона']"));
    }

    public MainPage selectItemFromRegionList(String item) {
        ElementsCollection ec = $$(By.xpath("//span[@class='region-search-box__option']"));
        for (SelenideElement e : ec) {
            if (e.getText().equals(item)) {
                e.click();
                return page(MainPage.class);
            }
        }
        Assert.fail("Элемент " + item + " не найден!");
        return null;
    }
}
