package org.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.dao.ICostDao;
import org.tarena.entity.Cost;

@Controller//ɨ��
@RequestMapping("/cost")
public class CostListController{
	
	@Resource//ע��
	private ICostDao costDao;//ע��
   
	@RequestMapping("/list.do")
	public String execute(int page,ModelMap model){
		List<Cost> list = costDao.findPage(page);
		model.put("costs", list);
		model.put("page", page);
		return "fee/fee_list";//fee_list.jsp����·����fee/fee_list֮ǰд��/fee_listһֱ����Ч��
	}
}
