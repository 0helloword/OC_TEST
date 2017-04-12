package com.oc.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.oc.action.*;
import com.oc.basic.*;

public class oc_process {

	LoginAction login = null;
	LogOutAction logout = null;
	HomePageAction app = null;
	AppQueryAction appquery = null;
	ManualAuditAction_pos manualaudit_pos=null;
	AuditAllotAction_pos auditallot_pos=null;
	WebDriver webdriver = new FirefoxDriver();
	
	
	@BeforeTest
	public void beforeMethod() {
		Log.startTestCase("开始testcase001");
		// 初始化类，并打开链接
		login = new LoginAction(webdriver);
		webdriver.get("http://123.57.56.45:7778/OC/initLogin");
		webdriver.manage().window().maximize();
		app=new HomePageAction(webdriver);
	}

	@Test(priority = 1)
	public void LoginA() {
		// 登录
		login.Login("999111", "cyj111");
	}
	
	 @Test(priority=2)
	 public void AuditAllot_pos() throws Exception {
		 app.ManualAudit();//人工审核
		 app.AuditAllotPos();//人工审核分单——pos贷
		 auditallot_pos=new AuditAllotAction_pos(webdriver);
		 auditallot_pos.AllotApp("小拉");
		 
	 }
//	 @Test(priority=3)
//	 public void ManualAudit_pos() throws Exception {
//		 //人工初步审核
//		 app.ManualAudit();  //人工审核
//		 app.FirstAuditPos();//初步审核
//		 manualaudit_pos=new ManualAuditAction_pos(webdriver);
//		 manualaudit_pos.GetApp();
//		 manualaudit_pos.Audit1("信息和照片均一致", "照片一致");
//		 manualaudit_pos.Audit2("社保单位名称与申请表一致","学信网一致","照片一致","照片一致");
//		 manualaudit_pos.Audit3();
//		 //manualaudit.Audit4info();  //因滚动栏原因不好定位？
//		 //manualaudit.Audit4phoneself("单位电话", "18956254412", "生效", "test");
//		// manualaudit.Audit4phoneother("当康", "亲属", "16589784452", "失效", "test");
//		 manualaudit_pos.Audit4("信息已验证","信息已验证", "RES01", "信息已验证", "信息已验证", "信息已验证", "公司名和地址均一致");
//	 }
	 
	
	
	// @Test(priority=3)
	// public void LogOut(){
	// //退出登录
	// logout=new LogOutAction();
	// Log.endTestCase("退出登录");
	// }

	// @AfterMethod
	// public void afterMethod(){
	// //关闭浏览器
	// login.ReturnDriver().close();
	// }
}