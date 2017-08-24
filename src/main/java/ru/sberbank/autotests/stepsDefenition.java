package ru.sberbank.autotests;

import cucumber.api.PendingException;
import cucumber.api.java.ru.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class stepsDefenition {

    private MainPage mainPage;
    private RegionsWidget regionsWidget;

    @Дано("^открыта страница \"([^\"]*)\"$")
    public void mainPageIsOpened(String url) {
        mainPage = open(url, MainPage.class);
    }

    @Также("нажата кнопка выбора региона")
    public void changeRegionButtonClick() {
        regionsWidget = mainPage.changeRegionButtonClick();
    }

    @Тогда("^на странице отображается регион \"([^\"]*)\"$")
    public void regionNameShouldBe(String region) {
        mainPage.regionNameField().shouldBe(visible).shouldHave(exactText(region));

    }

    @Также("^сделан скролл до footer$")
    public void goToFooter() {
        mainPage.scroll();
    }

    @Тогда("^footer содержит значок социальной сети \"([^\"]*)\"$")
    public void hasSocialRef(String value) {
        mainPage.hasSocialItem(value);
    }

    @И("^в поле поиска введено значение \"([^\"]*)\"$")
    public void setValueToRegionInput(String value) {
        regionsWidget.regionInput().sendKeys(value);
    }

    @И("^из выпадающего списка выбран элемент \"([^\"]*)\"$")
    public void selectItemFromDropdown(String item) {
        regionsWidget.selectItemFromRegionList(item);
    }
}
