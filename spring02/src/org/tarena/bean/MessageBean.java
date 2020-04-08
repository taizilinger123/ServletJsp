package org.tarena.bean;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class MessageBean {
	private String name;
	public String getName() {
		return name;
	}
	
	private int age;
	private Date birth;
	private List<String> friends;
	private Set<String> cities;
	private Map<String,String> books;
	private Properties db;
	
	public void setDb(Properties db) {
		this.db = db;
	}

	public void setBooks(Map<String, String> books) {
		this.books = books;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public void show(){
       System.out.println("name:"+name);
       System.out.println("age:"+age);
       System.out.println("birth:"+birth);
       System.out.println("--List注入信息--");
       for(String s : friends){
    	   System.out.println(s);
       }
       System.out.println("--Set注入信息--");
       for(String s : cities){
    	   System.out.println(s);
       }
       System.out.println("--Map注入信息--");
       Set<Entry<String, String>> booksSet = books.entrySet();
       for(Entry<String, String> e : booksSet ){
    	   System.out.println(e.getKey()+":"+e.getValue());
       }
       System.out.println("--Properties注入信息--");
       Set<Object> keys = db.keySet();
       for(Object key : keys){
    	   System.out.println(key+":"+db.getProperty(key.toString()));
       }
	}
	
	//把字符串类型转成Date类型
	public void setBirth(String birth) {
		Date date = Date.valueOf(birth);
		this.birth = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
