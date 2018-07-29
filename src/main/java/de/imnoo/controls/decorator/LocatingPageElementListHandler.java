package de.imnoo.controls.decorator;

import de.imnoo.controls.driver.PageElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class LocatingPageElementListHandler implements InvocationHandler {

    private final ElementLocator locator;
    private final String name;

    public LocatingPageElementListHandler(ElementLocator locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable //
    {
        final List<PageElement> elements = convertToPageElementList(locator.findElements());
        try
        {
            return method.invoke(elements, objects);
        }
        catch (InvocationTargetException e)
        {
            throw e.getCause();
        }
    }

    public List<PageElement> convertToPageElementList(final List<WebElement> webElementList) //
    {

        final List<PageElement> pageElementList = newArrayList();

        int index = 0;
        for (WebElement webElement : webElementList) {
            pageElementList.add(
                    new PageElement.Builder()
                            .setName("Element [" + index++ + "] of List [" + name + "]")
                            .setWebElement(webElement)
                            .build());
        }

        return pageElementList;
    }
}
