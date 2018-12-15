package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import com.epam.ta.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void openBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeBrowser()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public String getLoggedInUserName()
	{
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.getLoggedInUserName().trim();  //toLowerCase was deleted
	}

	public void createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public String getCurrentRepositoryName(){
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.getCurrentRepositoryName();
	}

	public String generateRandomRepositoryNameWithCharLength(int howManyChars){
		String repositoryNamePrefix = "testRepo_";
		return repositoryNamePrefix.concat(Utils.getRandomString(howManyChars));
	}




	//new methods are below

	public boolean isLinkNewRepoExist(){

		logger.info("[changeRepo.isLinkExist() called]");
		ChangeRepoPage changeRepo = new ChangeRepoPage(driver);
		return changeRepo.isLinkExist();
	}

	public boolean isWarningOnDisplay(){

		logger.info("[deleteRepoPage.isWarningDisplayed() called]");
		DeleteRepoPage deleteRepoPage = new DeleteRepoPage(driver);
		deleteRepoPage.openPage();
		deleteRepoPage.clickOnButton();
		return deleteRepoPage.isWarningDisplayed();

	}

	public boolean isRepoLinkAfterDeletingDisplayed() throws NoSuchElementException {

		logger.info("[isRepoLinkAfterDeletingDisplayed() called. deleteRepoPage.deleteRepo() called. changeRepo.isLinkExist() called]");
		DeleteRepoPage deleteRepoPage = new DeleteRepoPage(driver);
		deleteRepoPage.openPage();
		deleteRepoPage.deleteRepo();
		ChangeRepoPage changeRepo = new ChangeRepoPage(driver);
		return changeRepo.isLinkExist();

	}

}
