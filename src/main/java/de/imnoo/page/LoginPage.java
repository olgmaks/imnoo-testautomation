package de.imnoo.page;

import de.imnoo.controls.driver.PageElement;
import de.imnoo.controls.driver.meta.Name;
import de.imnoo.controls.page.AbstractPage;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @Name("Login input")
    @FindBy(name = "email")
    private PageElement loginInput;

    @Name("Password input")
    @FindBy(name = "password")
    private PageElement passwordInput;

    @Name("Submit login form")
    @FindBy(xpath = "//*[@class='auth0-lock-submit']")
    private PageElement submitButton;

    public void submitLogin(final String userName, final String password) {
        loginInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
