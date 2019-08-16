package com.ibm.automation.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ibm.utility.ConnectionManager;

public class AutomationConfig 
{
	
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	//Website Sanity and Premium Check
	private String WebsiteSql="SELECT * FROM DB_OWNER.T_APOLLO_SCREEN_LOCATOR_EVENTS_MAPPING WHERE APP_CODE=? AND SCREEN_CODE=? AND IS_ACTIVE='Y' ORDER BY EVENT_SEQ";
    
	private String CheckPremiumSql="SELECT * FROM DB_OWNER.T_APPOLLO_CHECK_PREMIUM WHERE APP_CODE=? AND SCREEN_CODE=? AND IS_ACTIVE='Y' ORDER BY EVENT_SEQ";
	
	//HealthJinn SSP Sanity Check UAT
	private String SSPSql = "SELECT * FROM DB_OWNER.T_APOLLO_SSP_MAPPING WHERE APP_CODE=? AND SCREEN_CODE=? AND IS_ACTIVE='Y' ORDER BY EVENT_SEQ";
	
	//Elixir Sanity Check 
	private String ElixirSql = "SELECT * FROM DB_OWNER.T_APPOLLO_ELixir WHERE APP_CODE=? AND SCREEN_CODE=? AND IS_ACTIVE='Y' ORDER BY EVENT_SEQ";
	


	public AutomationConfig(Connection con) throws Exception
	{
		this.con = con;
	}
	
	
	public List<DataSheetDto>  GetTestCases(String App_code,String Screen_code) throws Exception
	{
		 BeanListHandler<DataSheetDto> beanListHandler = new BeanListHandler<>(DataSheetDto.class);
		 QueryRunner runner =new QueryRunner();
		 List<DataSheetDto> list= runner.query(con,CheckPremiumSql, beanListHandler,App_code,Screen_code);
		
		return list;
	}
	

	
	public void destroy() throws Exception
	{
		ConnectionManager.closeBD();
	}

	
	
//	public static void main(String[] args) throws Exception
//	{
//		
//		AutomationConfig obj=new AutomationConfig();
//		
//		for(DataSheetDto datasheet:obj.GetTestCases())
//		{
//			System.out.println(datasheet.getDT_CREATE());
//		}
//		
//	}
	
	
}
