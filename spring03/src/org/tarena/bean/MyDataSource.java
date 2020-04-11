package org.tarena.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ds")
public class MyDataSource {
	//@Value("#{db.key}")//key��applicationContext.xml�е�<util:properties>�е�key��Ӧ
	@Value("#{db.username}")//��db����usernameֵע��
	private String username;
	@Value("#{db.password}")//��db����passwordֵע��
	private String password;
	@Value("#{db.driver}")//��db����driverֵע��
	private String driver;
	@Value("#{db.url}")//��db����urlֵע��
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
