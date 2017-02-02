package testCases;

import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Loggers;
import utils.ReportGenerator;
import utils.SikuliUtil;

public class WordpressOrg extends Base{

	private WebDriver driver;
	private String testCaseName=getClass().getName().substring(10); 
	private String currentSitePath;
	ExtentTest parentTest = ReportGenerator.initializeParentTest(getClass().getName().substring(10),"Testing Wordpress.org");
		
		public void navigateToURL(WebDriver driver){
			siteURL="http://www.wordpress.org";
			driver.navigate().to(baseurl+siteURL);
			}
		
		@Test	
		public void executeScript() throws IOException {
			
			ReportGenerator.assignAuthor(parentTest,"Doraemon");
			
			this.driver=driverIns();
			spikeLogin();
			currentSitePath=path;
			path=path+"/WordpressOrg";
			System.out.println(currentSitePath);
			navigateToURL(this.driver);
			
			Sleep(25000);
			
			try{
				
				Loggers.startCurrentTestCaseExecution(this.driver);
				
				ReportGenerator.verifyNavigation(this.driver, "WordPress", parentTest,testCaseName,"Yes");
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Favicon", screen, parentTest, "Verification of Wordpress Org Favicon", driver, testCaseName, "Yes");
				
				SikuliUtil.clickLeft("WordpressOrg_Home_Logo", screen, parentTest, "Clicking left to home logo to focus", driver, testCaseName, "No", 20);
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_END);
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Footer", screen, parentTest, "Scrolldown Check on Outbrain", driver, testCaseName, "Yes");
				
				SikuliUtil.keyPress(robot, KeyEvent.VK_HOME);
				
				Sleep(2000);
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Home_Logo", screen, parentTest, "Scrollup Check on Outbrain", driver, testCaseName,"Yes" );
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Showcase", screen, parentTest, "Clicking on Showcase Link", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Bada_Showcase", screen, parentTest, "Navigation to Wordpress Showcase", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Home_Logo", screen, parentTest, "Navigating back to WordpressOrg home", driver, testCaseName,"No" );
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Get_Involved", screen, parentTest, "Clicking on Get involved Link", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Make_Wordpress", screen, parentTest, "Navigation to Wordpress get involved", driver, testCaseName, "Yes");
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Home_Logo", screen, parentTest, "Navigating back to WordpressOrg home", driver, testCaseName,"No" );
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Bada_Download", screen, parentTest, "Clicking on Download", driver, testCaseName, "No");
				
				Sleep(3000);
				
				SikuliUtil.verifyObjectAndClickOn("WordpressOrg_Version_Download", screen, parentTest, "Clicking on the Download link", driver, testCaseName, "No");
				
				SikuliUtil.verifyObjectAndHighlight("WordpressOrg_Download_Message_ISLA", screen, parentTest, "Verification of Wordpress Download", driver, testCaseName, "Yes");
				
											
			}catch(Exception e){
				
				ReportGenerator.logStatusFail(parentTest,testCaseName, "The WordpressOrg TestCase Failed,Please see logs and error screenshots", driver);
				Loggers.writeErrorLog("An Exception was thrown, Please check error screenshot for more information");	
			
			}
			finally{
				quitDriver(this.driver);
				path=currentSitePath;
				ReportGenerator.flushReportToDisk(parentTest);
			}	
		}

	
}
