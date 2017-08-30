package com.zgs.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Smily on 2017/8/29.
 * 操作搜索结果
 */
public class BaiduResultsPage {
    public ElementsCollection getResults() {
        return $$(".c-container");
    }
    public SelenideElement getResult(int index) {
        return $(".c-container", index);
    }
}
