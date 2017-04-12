package com.oc.action;

import org.openqa.selenium.WebDriver;

import com.oc.basic.Log;
import com.oc.page.*;

public class LoginAction {
    
    private WebDriver driver;
    //1�����췽���ķ�����������������ͬ��
    //2�����췽��û�з������ͣ�Ҳ���ܶ���Ϊvoid���ڷ�����ǰ�治�����������͡�
    //3�����췽������Ҫ��������ɶ���ĳ�ʼ�����������ܹ��Ѷ������ʱ�Ĳ��������������
    public LoginAction(WebDriver driver){
        this.driver = driver;
    }
    
    //��¼
    public void Login(String user,String pw) {
        LoginPage.userName(driver).sendKeys(user);
        Log.info("�����û�����"+user);
        LoginPage.passWord(driver).sendKeys(pw);
        Log.info("�������룺"+pw);
        LoginPage.loginButton(driver).click();
        Log.info("�����¼");
       
    }


        
    //����driver
    public WebDriver ReturnDriver(){
        return this.driver;
    }        
} 