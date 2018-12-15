package com.epam.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeRepoPage extends com.epam.ta.pages.AbstractPage {

    private final String BASE_URL = "http://www.github.com";
    @FindBy (partialLinkText = "testRepo_")
    WebElement linkOfCreatedRepo;

    public ChangeRepoPage (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


    public boolean isLinkExist (){


        if (linkOfCreatedRepo.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnLink(){
        linkOfCreatedRepo.click();
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }
}
