package org.tarena.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.entity.Note;
@Controller//扫描
public class LoadNoteController {
  //调用Dao获取笔记数据，采用json返回
  @RequestMapping("/ajax01.do")
  @ResponseBody//将返回结果调用jackson.jar包转成json输出
  public List<Note> execute(){
	  //构建一个List集合
	  List<Note> list = new ArrayList<Note>();
	  Note note = new Note();
	  note.setId("01");
	  note.setName("SpringMVC开发");
	  Note note1 = new Note();
	  note1.setId("02");
	  note1.setName("JSON应用");
	  list.add(note);
	  list.add(note1);
	  return list;
  }
  
  @RequestMapping("/ajax02.do")
  @ResponseBody//将返回的note转成json输出
  public Note load1(){
	  Note note = new Note();
	  note.setId("01");
	  note.setName("Java基础");
	  return note;
  }
  
  @RequestMapping("/ajax03.do")
  @ResponseBody//将返回的map转成json输出
  public Map<String, Object> load2(){
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("name", "scott");
	  map.put("salary", 8000);
	  return map;
  }
}
