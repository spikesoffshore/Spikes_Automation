package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Key;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class Outbrain extends Base{
	
	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Outbrain.com");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.outbrain.com";
			driver.navigate().to(baseurl+siteURL);
			}
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/Outbrain";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				ReportGenerator.verifyNavigation(this.driver, "Content", parentTest,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("Outbrain_Favicon", screen, parentTest, "Verification of Outbrain Favicon", driver, testCaseName, "Yes");
				
				SikuliUtil.clickLeft("Outbrain_Home_Logo", screen, parentTest, "Clicking left to home logo to focus", driver, testCaseName, "No", 20);
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("Outbrain_Footer", screen, parentTest, "Scrolldown Check on Outbrain", driver, testCaseName, "Yes");
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("Outbrain_Home_Logo", screen, parentTest, "Scrollup Check on Outbrain", driver, testCaseName,"Yes" );
				
				SikuliUtil.verifyObjectAndClickOn("Outbrain_For_Business", screen, parentTest, "Clicking on For Business", driver, testCaseName, "No");
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("Outbrain_Amplify", screen, parentTest, "Verification of Link Navigation on Outbrain", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndClickOn("Outbrain_Login", screen, parentTest, "Clicking on Login", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Outbrain_Username", screen, parentTest, "Clicing on the Username box", driver, testCaseName, "No");
				
				SikuliUtil.typeScreen(screen, "spikesqa@gmail.com"+Key.TAB);
				
				SikuliUtil.typeScreen(screen, "QAqa4321!"+Key.ENTER);
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("Outbrain_Arrow", screen, parentTest, "Verification of Login on Outbrain", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("Outbrain_Logout", screen, parentTest, "Clicking on the logout link", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("Outbrain_Login_Button", screen, parentTest, "Verification of Logout from Outbrain", driver, testCaseName, "Yes");
				
							
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The Outbrain.com TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}

}
