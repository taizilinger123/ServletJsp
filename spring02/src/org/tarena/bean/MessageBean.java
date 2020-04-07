package org.tarena.bean;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class MessageBean {
	private String name;
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
       System.out.println("--Listע����Ϣ--");
       for(String s : friends){
    	   System.out.println(s);
       }
       System.out.println("--Setע����Ϣ--");
       for(String s : cities){
    	   System.out.println(s);
       }
       System.out.println("--Mapע����Ϣ--");
       Set<Entry<String, String>> booksSet = books.entrySet();
       for(Entry<String, String> e : booksSet ){
    	   System.out.println(e.getKey()+":"+e.getValue());
       }
       System.out.println("--Propertiesע����Ϣ--");
       Set<Object> keys = db.keySet();
       for(Object key : keys){
    	   System.out.println(key+":"+db.getProperty(key.toString()));
       }
	}
	
	//���ַ�������ת��Date����
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
