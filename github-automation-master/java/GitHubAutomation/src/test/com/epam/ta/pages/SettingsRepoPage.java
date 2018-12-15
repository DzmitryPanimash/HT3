package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsRepoPage extends com.epam.ta.pages.AbstractPage{


    @FindBy (xpath = "//nav/a[4]")
    WebElement settingsLink;


    public SettingsRepoPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public void clickOnLink(){
        settingsLink.click();
    }

    @Override
    public void openPage()
    {
        ChangeRepoPage changeRepoPage = new ChangeRepoPage(driver);
        changeRepoPage.clickOnLink();
    }
}
