package org.tarena.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.tarena.entity.Note;

public class LoadNoteServlet extends HttpServlet{
   public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
	   //将笔记信息以JSON格式输出
	   List<Note> list = new ArrayList<Note>();
	   Note note = new Note();
	   note.setId("01");
	   note.setName("Java变量");
	   Note note1 = new Note();
	   note1.setId("02");
	   note1.setName("Ajax应用");
	   list.add(note);//添加到list中
	   list.add(note1);//添加到list中
	   //将note对象转成json字符串
	   //JSONObject json = JSONObject.fromObject(note);
	   //将list转成json字符串
	   JSONArray  json = JSONArray.fromObject(list);
	   String json_str = json.toString();
	   System.out.println(json_str);
	   //将json字符串输出
	   res.setContentType("text/plain;charset=utf-8");
	   PrintWriter out = res.getWriter();
	   out.print(json_str);
	   out.flush();
	   out.close();
    }
}
