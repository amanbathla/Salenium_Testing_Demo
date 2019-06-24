package com.ibm.Apollo.run;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ibm.Apollo.xml.TestNGXML_Helper;
import com.ibm.automation.ui.Driver_Setup;


public class ipaRunner 
{
	private static Logger logger=Logger.getLogger(ipaRunner.class);
	public static void main(String[] args) throws Exception 
	{
		
		//logger.info("ipaRunner.main() Start::");
		
//		Extent_Reporting extent_reporting=new Extent_Reporting(Constants.snapshotsPath, Constants.reportPath);
		TestNGXML_Helper testNGXMLObj=new TestNGXML_Helper();
		testNGXMLObj.createXMLfile();
	

		logger.info("ipaRunner.main() End::");
		
	}
}