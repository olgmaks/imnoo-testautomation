package de.imnoo.controls.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PageDriverController {

    private static final ThreadLocal<PageDriver> PAGE_DRIVER_THREAD_LOCAL = ThreadLocal
            .withInitial(PageDriverController::initializePageDriver);

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    private static PageDriver initializePageDriver() {
        final ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new PageDriver(webDriver);
    }

    public static PageDriver getPageDriver() {
        return PAGE_DRIVER_THREAD_LOCAL.get();
    }

    public static void load(String url) {
        getPageDriver().get(url);
    }

    public static void close() {
        try {
            getPageDriver().close();
        } finally {
            PAGE_DRIVER_THREAD_LOCAL.remove();
        }
    }
}
