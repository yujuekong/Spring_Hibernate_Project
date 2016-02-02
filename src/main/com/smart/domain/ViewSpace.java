package com.smart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 景区的po类
 * @author CA
 *
 */
@Entity
@Table(name = "t_view_space")
public class ViewSpace extends BaseDomain{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="space_id")
	private int spaceId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="space_name")
	private String spaceName;
	
	//对应的表字段和属性名相同，jpa会默认映射，无需标注
	private String description;
	private String website;
	private String address;
	
	@Column(name="want_num")
	private int wantNum;
	
	@Column(name="been_num")
	private int beenNum;
	
	@Column(name="notwant_num")
	private int notwantNum;
	
	public int getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
	public String getSpaceName() {
		return spaceName;
	}
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getWantNum() {
		return wantNum;
	}
	public void setWantNum(int wantNum) {
		this.wantNum = wantNum;
	}
	public int getBeenNum() {
		return beenNum;
	}
	public void setBeenNum(int beenNum) {
		this.beenNum = beenNum;
	}
	public int getNotwantNum() {
		return notwantNum;
	}
	public void setNotwantNum(int notwantNum) {
		this.notwantNum = notwantNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
