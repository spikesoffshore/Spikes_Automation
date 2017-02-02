package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.CommonUtil;
import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class DeviantArt extends Base {

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing DeviantArt");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.deviantart.com";
			driver.navigate().to(baseurl+siteURL);
			}
		
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/DeviantArt";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Favicon", screen, parentTest, "Verification of DeviantArt Favicon", driver, testCaseName, "Yes");
				
				SikuliUtil.clickBelow("DeviantArt_Undiscovered", screen, parentTest, "Clicking on First Undiscovered Image", driver, testCaseName, "No", 100);
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Next", screen, parentTest, "Display of image", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Home", screen, parentTest, "Navigation to Deviant Art home using Home logo", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Welcome", screen, parentTest, "Back to home", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Search", screen, parentTest, "Clicking on Search Icon for an Empty Search", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Sort", screen, parentTest, "Verification of Empty search on DeviantArt", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Login", screen, parentTest, "Clicking on Login", driver, testCaseName, "No");
				
				Sleep(8000);
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_UserName", screen, parentTest, "Clicking inside the Username textbox", driver, testCaseName, "No");
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				Sleep(1000);
				
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Spikesqa", screen, parentTest, "Verification of Login", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Watch", screen, parentTest, "Click on Watch", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_WatchPlus", screen, parentTest, "Watching a User", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Watching", screen, parentTest, "Verification of successfull watching", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Watching", screen, parentTest, "Click on Unwatch", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_WatchPlus", screen, parentTest, "Verification of Unwatch", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Submit", screen, parentTest, "Click on Submit to upload an image", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Upload", screen, parentTest, "Clicking on Upload button", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Select_File", screen, parentTest, "Clicking on ISLA upload", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.typeScreen(screen, (path+"/DeviantArt_AAA.png").replaceAll("/", "\\")+Key.ENTER);
				
				//SikuliUtil.verifyObjectAndClickOn("DeviantArt_AAA", screen, parentTest, "Selecting image for upload", driver, testCaseName, "No");
				
				Sleep(6000);
				
				//SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				
				
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_IAgree", screen, parentTest, "Clicking on I Agree", driver, testCaseName, "No");
				
				Sleep(4000);
								
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_AAA", screen, parentTest, "Verification of Uploaded Image", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_SaveExit", screen, parentTest, "Clicking on Save and Exit", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Delete", screen, parentTest, "Clicking on Delete", driver, testCaseName, "No");
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_ENTER);
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Spike", screen, parentTest, "Hovering on Stash", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("DeviantArt_Logout", screen, parentTest, "Clicking on Logout", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("DeviantArt_Stash", screen, parentTest, "Verification of Logout on DeviantArt", driver, testCaseName, "Yes");
				
				
				
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The DeviantArt TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}
}
