package de.imnoo.controls.page;

import de.imnoo.controls.driver.PageDriver;
import de.imnoo.controls.decorator.PageObjectFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import static de.imnoo.controls.driver.PageDriverController.getPageDriver;

public abstract class AbstractPage {

    protected  PageDriver pageDriver;

    public AbstractPage() {

        pageDriver = getPageDriver();

        PageFactory.initElements(
                new PageObjectFieldDecorator(
                        new DefaultElementLocatorFactory(pageDriver)), this);
    }
}
