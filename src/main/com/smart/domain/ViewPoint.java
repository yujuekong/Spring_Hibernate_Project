package com.smart.domain;
/**
 * 景点的po类
 * @author CA
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_view_point")
public class ViewPoint extends BaseDomain{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="point_id")
	private int pointId;
	
	@Column(name="point_name")
	private String pointName;
	
	@Column(name="ticket_price")
	private float ticketPrice;
	
	private String description;
	
	@Column(name="img_file")
	private String imgFile;
	
	
	public int getPointId() {
		return pointId;
	}
	public void setPointId(int pointId) {
		this.pointId = pointId;
	}
	public String getPointName() {
		return pointName;
	}
	public void setPointName(String pointName) {
		this.pointName = pointName;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	
	
}
