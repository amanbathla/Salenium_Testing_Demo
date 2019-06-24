package com.ibm.Apollo.mod;


import java.util.ArrayList;
import java.util.HashMap;


import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import com.ibm.Apollo.auto.Controller;

import com.ibm.Apollo.utility.Constants;
import com.ibm.automation.IF.TestModIF;
import com.ibm.automation.ui.AutomationWrapper;







public class ApolloMod extends Controller implements TestModIF{
	

		// public WebDriver driver;
		public boolean flag = false;
		private static Logger logger=Logger.getLogger(ApolloMod.class);
		private HashMap<String, String> dataMap;
		
		private AutomationWrapper autoWrapper;
	
		private HashMap dataSheetMap;
		String Scenario2,Scenario3;
	
		
		
		//private D2cDbConnect dbObj;

//		@Parameters({ "paramData", "tcID", "sheetName", "timeout" })
		@Test
		public void Execute(HashMap paramData, String tcID, String sheetName, String timeout,String datasheetPath,String datasheetResultPath) throws Exception,Throwable {
			logger.info("ApolloMod initiated....");
			
			
			//To identiify Secnarios
			this.dataSheetMap=paramData;
			System.out.println("datasheetValue :"+dataSheetMap);
		
			Scenario2=sheetName;
			//Scenario3=paramData.get("ChannelName").toString();
			
			dataMap = new HashMap<String, String>();
			

			testReporter.startTest(TC_ID + "_" + Scenario2 );
			autoWrapper = new AutomationWrapper(datasheetPath,datasheetResultPath ,sheetName,
					Constants.snapshotsPath, Constants.reportPath, timeout, Constants.DB_SQL_URL, Constants.DB_SQL_DRV,
					Constants.DB_SQL_USR, Constants.DB_SQL_PWD,testReporter);
			
			
			autoWrapper.Execute(paramData, driver, TC_ID, dataMap, paramData, "APOLLO", "MunichInsurance", this);
			//autoWrapper.Execute(paramData, driver, TC_ID, dataMap,paramData, this,"APOLLO",Scenario2);
			
//			
//			Extent_Reporting.destroy();
//			
			Thread.sleep(9000);

		}
		
		public void NavigateBack()
		{
			driver.navigate().back();
		}
		
		
		public void navigateToURL(String ...url) {
		
			System.out.println("**********"+ url[0].toString());
			
				try {
					driver.get(url[0].toString());
				}
				catch(TimeoutException e) {
				
					System.out.println(e.getMessage());
				}
			
		
		}
		
		
	//here params is the date column name in datasheet have to be passed from configuration file.
	
public void doSplitDate(String... params) 
	{
		try
		{
			System.out.println(dataSheetMap.get(params[0]).toString());
			String date=dataSheetMap.get(params[0]).toString();
//			
			
			//TODO : date split logic to be implemented
			
			String DobArr[]=date.split("-");
			String Year=DobArr[2].toString().trim();
			String Month=DobArr[1].toString().trim();
			String day=DobArr[0].toString().trim();
			
			dataMap.put("Day", day);
			dataMap.put("Month", Month);
			dataMap.put("Year", Year);
			
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	


}
		



		


		
