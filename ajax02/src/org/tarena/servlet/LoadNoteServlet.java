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
	   //���ʼ���Ϣ��JSON��ʽ���
	   List<Note> list = new ArrayList<Note>();
	   Note note = new Note();
	   note.setId("01");
	   note.setName("Java����");
	   Note note1 = new Note();
	   note1.setId("02");
	   note1.setName("AjaxӦ��");
	   list.add(note);//��ӵ�list��
	   list.add(note1);//��ӵ�list��
	   //��note����ת��json�ַ���
	   //JSONObject json = JSONObject.fromObject(note);
	   //��listת��json�ַ���
	   JSONArray  json = JSONArray.fromObject(list);
	   String json_str = json.toString();
	   System.out.println(json_str);
	   //��json�ַ������
	   res.setContentType("text/plain;charset=utf-8");
	   PrintWriter out = res.getWriter();
	   out.print(json_str);
	   out.flush();
	   out.close();
    }
}
