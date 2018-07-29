package de.imnoo.page;

import de.imnoo.controls.driver.PageElement;
import de.imnoo.controls.driver.PageElementList;
import de.imnoo.controls.driver.meta.Name;
import de.imnoo.controls.page.AbstractPage;
import org.openqa.selenium.support.FindBy;

public class AdminCustomerPage extends AbstractPage {

    @Name("Add new customer plus button")
    @FindBy(xpath = "//*[@class='admin-page-header']/im-button")
    private PageElement plusButton;

    @Name("Customer modal popup")
    @FindBy(xpath = "//*[@class='customer-modal']//*[contains(@class,'im-modal-content')]")
    private PageElement customerModalPopup;

    @Name("Abort create new customer button on Customer Modal")
    @FindBy(xpath = "//*[@class='customer-modal']//button[contains(@class, 'color-default')]")
    private PageElement abortCreateNewCustomerButton;

    @Name("Pagination Links on Customer Modal")
    @FindBy(xpath = "//*[@class='im-pagination']//*[contains(@class, 'page-number')]/..")
    private PageElementList paginationLinks;

    public void clickPlusButton() {
        plusButton.click();
    }

    public void verifyCustomerModalVisible() {
        customerModalPopup.shouldExists().shouldBeVisible();
    }

    public void verifyCustomerModalIsNotVisible() {
        customerModalPopup.shouldNotBeVisible();
    }

    public void clickAbortCreateNewCustomerButton(){
        abortCreateNewCustomerButton.click();
    }

    public void clickPageNumber(Integer pageNumber) {
        paginationLinks.get(--pageNumber).click();
    }

    public void verifyPageIsActive(int pageNumber){
        paginationLinks.get(--pageNumber).shouldHaveClass("active");
    }
}
