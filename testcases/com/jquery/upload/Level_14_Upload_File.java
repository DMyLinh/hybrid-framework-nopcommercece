package com.jquery.upload;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_14_Upload_File extends BaseTest {
	WebDriver driver;
	UploadPageObject uploadPage;
	String hanoiCity = "HaNoi.JPG";
	String HCMCity = "HCM.JPG";
	String hueCity = "Hue.JPG";
	
	String[] fileNames = {hanoiCity, HCMCity, hueCity};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadPage= PageGeneratorManager.getUploadPage(driver);
	}

	//@Test
	public void TC_01_Upload_Single_File() {
		uploadPage.uploadMultipleFiles(driver, hanoiCity);
		uploadPage.sleepInSecond(1);
		uploadPage.uploadMultipleFiles(driver, HCMCity);
		uploadPage.sleepInSecond(1);
		uploadPage.uploadMultipleFiles(driver, hueCity);
		uploadPage.sleepInSecond(1);
		
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(HCMCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hueCity));
		
		
		uploadPage.clickStartButtonForEachFile();
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(HCMCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hueCity));

	}
	
	//@Test
	public void TC_02_Upload_Multiple_File() {
		uploadPage.uploadMultipleFiles(driver, fileNames);
			
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(HCMCity));
		Assert.assertTrue(uploadPage.isFileLoadedSuccess(hueCity));
		
		
		uploadPage.clickStartButtonForEachFile();
		uploadPage.sleepInSecond(2);
		
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hanoiCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(HCMCity));
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(hueCity));
		
	} 
	
	@Test
	public void TC_03_Upload_Files_And_Wait_Icon_Loading() {
		uploadPage.openUrl(driver, "https://gofile.io/welcome");
		Assert.assertTrue(uploadPage.isIconLoadingDisappear());
		uploadPage.goToUploadPage();
		Assert.assertTrue(uploadPage.isIconLoadingDisappear());
		
		uploadPage.uploadMultipleFiles(driver, fileNames);
		Assert.assertTrue(uploadPage.isIconLoadingDisappear());
		
		Assert.assertEquals(uploadPage.getMainUploadSuccess(), "Your files have been successfully uploaded");
		uploadPage.clickToAjaxLink();
		Assert.assertTrue(uploadPage.isIconLoadingDisappear());
		
		Assert.assertTrue(uploadPage.isFilesUploaded(hanoiCity));
		Assert.assertTrue(uploadPage.isFilesUploaded(HCMCity));
		Assert.assertTrue(uploadPage.isFilesUploaded(hueCity));
		

		

	}
	
	@AfterClass
	public void afterClass() {
		quitBrowserDriver();
	}



}
