package com.zgs.selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Smily on 2017/8/29.
 * 打开的页面
 */
public class BaiduPage {
    public BaiduResultsPage searchFor(String text) {
        $(By.name("wd")).val(text).pressEnter();
        return page(BaiduResultsPage.class);
    }
}
