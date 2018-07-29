package de.imnoo.controls.driver;

import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PageElement implements WebElement {

    private static final Logger LOG = LoggerFactory.getLogger(PageElement.class);

    private WebElement pageElement;
    private String name = "No-name";
    private PageDriver pageDriver;

    protected void setPageDriver(PageDriver pageDriver) {
        this.pageDriver = pageDriver;
    }

    protected void setPageElement(WebElement pageElement) {
        this.pageElement = pageElement;
    }

    protected void setName(String name) {
        this.name = name;
    }

    private PageElement() {
    }

    public void click() {
        LOG.debug("[{}] do click ...", name);
        pageElement.click();
    }

    public void submit() {
        pageElement.submit();
    }

    public void sendKeys(CharSequence... charSequences) {
        LOG.debug("[{}] do sendKeys [{}] ...", name, Arrays.toString(charSequences));
        pageElement.sendKeys(charSequences);
    }

    public void clear() {
        pageElement.clear();
    }

    public String getTagName() {
        return pageElement.getTagName();
    }

    public String getAttribute(String s) {
        return pageElement.getAttribute(s);
    }

    public boolean isSelected() {
        return pageElement.isSelected();
    }

    public boolean isEnabled() {
        return pageElement.isEnabled();
    }

    public String getText() {
        return pageElement.getText();
    }

    public List<WebElement> findElements(By by) {
        return pageElement.findElements(by);
    }

    public WebElement findElement(By by) {
        return pageElement.findElement(by);
    }

    public boolean isDisplayed() {
        return pageElement.isDisplayed();
    }

    public Point getLocation() {
        return pageElement.getLocation();
    }

    public Dimension getSize() {
        return pageElement.getSize();
    }

    public Rectangle getRect() {
        return pageElement.getRect();
    }

    public String getCssValue(String s) {
        return pageElement.getCssValue(s);
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return pageElement.getScreenshotAs(outputType);
    }

    public PageElement shouldExists() {
        LOG.debug("[{}] verifying existing ...", name);
        assertThat(isExists()).isTrue().as("PageElement [" + name + "] should exists but does not");
        return this;
    }

    public PageElement shouldBeVisible() {
        LOG.debug("[{}] verifying visibility ...", name);
        assertThat(isDisplayed())
                .as("PageElement [" + name + "]  should be visible but is not")
                .isEqualTo(true);
        return this;
    }

    public void shouldNotBeVisible() {
        LOG.debug("[{}] verifying invisibility ...", name);
        boolean isVisible = false;
        if (isExists()) {
            isVisible = isDisplayed();
        }
        assertThat(isVisible)
                .as("PageElement [" + name + "]  should not be visible but is")
                .isFalse();
    }

    public boolean isExists() {
        boolean exists;
        try {
            getSize();
            exists = true;
        } catch (NoSuchElementException e) {
            exists = false;
        }
        return exists;
    }

    public void shouldHaveClass(final String className) {
        final String attr = getAttribute("class");
        LOG.info("[{}] verifying attribute has class name [{}]", name, className);
        assertThat(attr).contains(className);
    }

    public static class Builder {

        private WebElement webElement;
        private String name;
        private PageDriver pageDriver;

        public Builder setWebElement(Object webElement) {
            if (!(webElement instanceof WebElement)) {
                throw new RuntimeException("Error while building web element decorator, webElement has type [" + webElement.getClass() + "]");
            }
            this.webElement = (WebElement) webElement;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPageDriver(PageDriver pageDriver) {
            this.pageDriver = pageDriver;
            return this;
        }

        public PageElement build() {
            final PageElement pageElement = new PageElement();
            pageElement.setName(name);
            pageElement.setPageDriver(pageDriver);
            pageElement.setPageElement(webElement);
            return pageElement;
        }
    }
}
