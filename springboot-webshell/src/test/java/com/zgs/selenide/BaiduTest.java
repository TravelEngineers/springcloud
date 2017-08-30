package com.zgs.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Smily on 2017/8/29.
 */
public class BaiduTest {

    @Test
    public void userCanSearch() {
        // 设置Chrome浏览器
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProject\\chromedriver\\chromedriver.exe");
        // 打开页面
        BaiduPage page = open("https://www.baidu.com", BaiduPage.class);
        // 搜索结果
        BaiduResultsPage results = page.searchFor("selenide");
        // 验证搜索结果
//        results.getResults().shouldHave(size(10));
        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }


}
