package de.imnoo.controls.decorator;

import de.imnoo.controls.driver.PageDriverController;
import de.imnoo.controls.driver.PageElement;
import de.imnoo.controls.driver.PageElementList;
import de.imnoo.controls.driver.meta.Name;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class PageObjectFieldDecorator extends DefaultFieldDecorator {

    public PageObjectFieldDecorator(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {

        if (PageElement.class.isAssignableFrom(field.getType()))
        {
            return new PageElement.Builder()
                    .setName(getFieldNameAnnotation(field))
                    .setPageDriver(PageDriverController.getPageDriver())
                    .setWebElement(super.decorate(loader, field))
                    .build();
        }
        else if (PageElementList.class.isAssignableFrom(field.getType()))
        {
            return proxyForPageElementListLocator(loader, factory.createLocator(field), getFieldNameAnnotation(field));
        }
        return super.decorate(loader, field);
    }

    private String getFieldNameAnnotation(Field field) {

        String name;
        if (field.isAnnotationPresent(Name.class)) {
            name = field.getAnnotation(Name.class).value();
        } else {
            name = "No-name";
        }
        return name;
    }

    @SuppressWarnings("unchecked")
    protected PageElementList proxyForPageElementListLocator(ClassLoader loader, ElementLocator locator, String name) {
        InvocationHandler handler = new LocatingPageElementListHandler(locator, name);

        final List<PageElement> pageElementList = (List<PageElement>) Proxy.newProxyInstance(
                loader, new Class[]{List.class}, handler);

        return new PageElementList(pageElementList);

    }
}
