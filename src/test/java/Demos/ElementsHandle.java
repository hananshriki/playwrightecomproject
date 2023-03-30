package Demos;

import com.microsoft.playwright.*;

public class ElementsHandle {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );

        Page page = browser.newPage();

        page.navigate("https://www.saucedemo.com/");

        String title = page.title();

        String  Url = page.url();

        System.out.println("title = " + title);
        System.out.println("Url = " + Url);

       Locator UsernameInput =  page.locator("#user-name");
       UsernameInput.type("hanan");
page.waitForTimeout(2000);
UsernameInput.clear();
page.waitForTimeout(2000);
UsernameInput.type("shriki");
page.waitForTimeout(2000);
UsernameInput.fill("new value");
page.locator("[data-test='password']").fill("hanan");

page.locator(".submit-button").click();

String errorMessage = page.locator("[data-test=\"error\"]").textContent();
        System.out.println(errorMessage);
        page.waitForTimeout(3000);
        page.close();
        browser.close();
        playwright.close();






    }
}
