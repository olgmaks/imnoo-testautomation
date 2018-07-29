package de.imnoo.page;

import de.imnoo.controls.driver.PageElement;
import de.imnoo.controls.driver.meta.Name;
import de.imnoo.controls.page.AbstractPage;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends AbstractPage {

    @Name("User Email in Header on Dashboard")
    @FindBy(xpath = "//*[contains(@class, 'header-navigation-user-toggle')]")
    private PageElement userEmailLink;

    public void verifyUserEmailLinkVisible() {
        userEmailLink.shouldExists().shouldBeVisible();
    }
}
