package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DeleteRepoPage extends com.epam.ta.pages.AbstractPage {

    @FindBy (id = "rename-field")
    WebElement nameRepoField;

    @FindBy (xpath = "//div[8]/ul/li[4]/details/summary")
    WebElement deleteButton;

    @FindBy (xpath = "//div[8]/ul//div/div")
    WebElement warningMessage;              //"Are you absolutely sure?"

    @FindBy (xpath = "//li[4]//p/input")
    WebElement verifyNameForDelField;

    @FindBy (xpath = "//form/button[contains(text(), 'I understand the consequences, delete this repository')]")
    WebElement submitDeletingButton;

    public DeleteRepoPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnButton(){
        deleteButton.click();
    }

    public boolean isWarningDisplayed(){

        if(warningMessage.isDisplayed()) return true;
        return false;
    }

    public void deleteRepo(){

        clickOnButton();
        verifyNameForDelField.sendKeys(nameRepoField.getAttribute("value"));
        submitDeletingButton.click();

    }

    @Override
    public void openPage()
    {
        SettingsRepoPage settingsRepoPage = new SettingsRepoPage(driver);
        settingsRepoPage.openPage();
        settingsRepoPage.clickOnLink();
    }

}
