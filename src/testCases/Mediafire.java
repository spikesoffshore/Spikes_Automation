package testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Mediafire extends Base{

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Mediafire.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.mediafire.com";
			driver.navigate().to(baseurl+siteURL);
			}
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Mediafire";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				ReportGenerator.verifyNavigation(this.driver, "File", parentTest,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("Mediafire_Favicon", screen, parentTest, "Verification of Mediafire Favicon", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Login", screen, parentTest, "Clicking on the login button", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Email", screen, parentTest, "CLicking inside the Email Address Field", driver, testCaseName,"No");
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(2000);
				
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(4000);
				
				/*if(SikuliUtil.isPresent(screen, "Mediafire_Dismiss")){
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Dismiss", screen, parentTest, "Dismiss the upload popup", driver, testCaseName, "No");
				}
				*/
				SikuliUtil.verifyObjectAndHighlight("Mediafire_Profile_Icon", screen, parentTest, "Verification of successfull login", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Upload", screen, parentTest, "Click on Upload Button", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_From_Computer", screen, parentTest, "Clicking on MyComputer", driver, testCaseName, "No");
				
				Sleep(4000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Add_Files", screen, parentTest, "Clicking on Add Files", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndHighlight("Medifire_Isla_Upload_File", screen, parentTest, "Verification of ISLA upload message", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Isla_Cross", screen, parentTest, "Closing the ISLA info message", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Cancel", screen, parentTest, "Cancellation of File upload", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Add_Folder", screen, parentTest, "Addition of new folder", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Folder_Name", screen, parentTest,"clicking inside folder name textbox", driver, testCaseName, "No");
				
				SikuliUtil.typeScreen(screen, "TestFolder");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Create", screen, parentTest, "Clicking on Create Folder", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("Mediafire_Test_Folder", screen, parentTest, "Creation of new Folder", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Arrow", screen, parentTest, "Getting options for the folder", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Move_To_Trash", screen, parentTest, "Clicking to delete the test folder", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Yes", screen, parentTest, "Confirm delete folder", driver, testCaseName, "No");
				
				Sleep(1000);
				
				SikuliUtil.verifyObjectAndHighlight("Mediafire_Just_Now", screen, parentTest, "Deletion of test folder", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Profile_Icon", screen, parentTest, "Clicking on Profile Icon", driver, testCaseName, "No");
				
				Sleep(1000);
				
				SikuliUtil.verifyObjectAndClickOn("Mediafire_Logout", screen, parentTest, "Clicking on Logout", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("Mediafire_Login", screen, parentTest, "Logout on Mediafire", driver, testCaseName, "Yes");
				
				
				
				
				
				
				
				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Mediafire.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}
