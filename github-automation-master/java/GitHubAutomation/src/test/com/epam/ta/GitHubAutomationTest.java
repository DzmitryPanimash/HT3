package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "DzmitryTemp";
	private final String PASSWORD = "ifvbyjg321";
	private final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;


	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.openBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertEquals(USERNAME, steps.getLoggedInUserName());
	}

	//new tests are below

	@Test (description = "does the link of created repository exist on main page? is creating of repo success?")
	public void isCreatingRepoSuccess()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLinkNewRepoExist());

	}

	@Test (description = "this test is checking, that the warning message is on the display after the click on 'Delete this repository'")
	public void isWarningDisplayed(){
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isWarningOnDisplay());
	}

	@Test 	(description = "this test is checking, that the link of created repository doesn't exist after deleting of repo",
			expectedExceptions = NoSuchElementException.class)
	public void isRepoLinkAfterDelDisplayed(){

		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertFalse(steps.isRepoLinkAfterDeletingDisplayed());
	}


	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeBrowser();
	}

}
