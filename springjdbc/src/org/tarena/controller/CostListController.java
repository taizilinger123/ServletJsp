package org.tarena.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tarena.dao.ICostDao;
import org.tarena.entity.Cost;

@Controller//扫描
@RequestMapping("/cost")
public class CostListController{
	
	@Resource//注入
	private ICostDao costDao;//注入
   
	@RequestMapping("/list.do")
	public String execute(int page,ModelMap model){
		List<Cost> list = costDao.findPage(page);
		model.put("costs", list);
		model.put("page", page);
		return "fee/fee_list";//fee_list.jsp这里路径是fee/fee_list之前写错/fee_list一直不出效果
	}
}
