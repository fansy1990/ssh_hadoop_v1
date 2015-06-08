package com.fz.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hconstants")
/**
 * hadoop 常量类
 * @author fansy
 * @date 2015-6-8
 */
public class HConstants implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String hkey;
	private String hvalue;
	private String description;
	
	public HConstants(){	}
	public HConstants (String key, String value){
		this.hkey=key;
		this.hvalue=value;
	}
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHkey() {
		return hkey;
	}
	public void setHkey(String hkey) {
		this.hkey = hkey;
	}
	public String getHvalue() {
		return hvalue;
	}
	public void setHvalue(String hvalue) {
		this.hvalue = hvalue;
	}
	
}
