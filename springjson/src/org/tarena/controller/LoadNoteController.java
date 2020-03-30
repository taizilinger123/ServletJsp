package org.tarena.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.entity.Note;
@Controller//ɨ��
public class LoadNoteController {
  //����Dao��ȡ�ʼ����ݣ�����json����
  @RequestMapping("/ajax01.do")
  @ResponseBody//�����ؽ������jackson.jar��ת��json���
  public List<Note> execute(){
	  //����һ��List����
	  List<Note> list = new ArrayList<Note>();
	  Note note = new Note();
	  note.setId("01");
	  note.setName("SpringMVC����");
	  Note note1 = new Note();
	  note1.setId("02");
	  note1.setName("JSONӦ��");
	  list.add(note);
	  list.add(note1);
	  return list;
  }
  
  @RequestMapping("/ajax02.do")
  @ResponseBody//�����ص�noteת��json���
  public Note load1(){
	  Note note = new Note();
	  note.setId("01");
	  note.setName("Java����");
	  return note;
  }
  
  @RequestMapping("/ajax03.do")
  @ResponseBody//�����ص�mapת��json���
  public Map<String, Object> load2(){
	  Map<String, Object> map = new HashMap<String, Object>();
	  map.put("name", "scott");
	  map.put("salary", 8000);
	  return map;
  }
}
