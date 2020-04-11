package org.tarena.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ds")
public class MyDataSource {
	//@Value("#{db.key}")//key与applicationContext.xml中的<util:properties>中的key对应
	@Value("#{db.username}")//将db对象username值注入
	private String username;
	@Value("#{db.password}")//将db对象password值注入
	private String password;
	@Value("#{db.driver}")//将db对象driver值注入
	private String driver;
	@Value("#{db.url}")//将db对象url值注入
	private String url;
    
	//因为有@Value(""),setXxx方法可以省略
	public void getConnection() {
		System.out.println("利用连接参数创建数据库连接");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("driver:" + driver);
		System.out.println("url:" + url);
	}
}
