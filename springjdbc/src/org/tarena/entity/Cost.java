package org.tarena.entity;

import java.io.Serializable;
import java.util.Date;

public class Cost implements Serializable {
	private Integer cost_id;//资费ID
	private String name;//资费名
	private Long base_duration;//基本时长
	private Double base_cost; //基本费用
	private Double unit_cost;//单位费用
	private String status;//状态
	private String descr;//描述
	private Date creatime;//创建时间
	private Date startime;//启用时间
	private String cost_type;//资费类型

	public Integer getCost_id() {
		return cost_id;
	}

	public void setCost_id(Integer costId) {
		cost_id = costId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBase_duration() {
		return base_duration;
	}

	public void setBase_duration(Long baseDuration) {
		base_duration = baseDuration;
	}

	public Double getBase_cost() {
		return base_cost;
	}

	public void setBase_cost(Double baseCost) {
		base_cost = baseCost;
	}

	public Double getUnit_cost() {
		return unit_cost;
	}

	public void setUnit_cost(Double unitCost) {
		unit_cost = unitCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreatime() {
		return creatime;
	}

	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public String getCost_type() {
		return cost_type;
	}

	public void setCost_type(String costType) {
		cost_type = costType;
	}

}
