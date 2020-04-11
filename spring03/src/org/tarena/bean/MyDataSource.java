package org.tarena.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ds")
public class MyDataSource {
	@Value("#{db.username}")
	private String username;
	@Value("#{db.password}")
	private String password;
	@Value("#{db.driver}")
	private String driver;
	@Value("#{db.url}")
	private String url;
    
	//��Ϊ��@Value(""),setXxx��������ʡ��
	public void getConnection() {
		System.out.println("�������Ӳ����������ݿ�����");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("driver:" + driver);
		System.out.println("url:" + url);
	}
}
