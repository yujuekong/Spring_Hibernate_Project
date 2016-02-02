package com.smart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 景区评论的po类
 * @author CA
 *
 */
@Entity
@Table(name="t_comment_log")
public class CommentLog extends BaseDomain{
	
	private static final long serialVersionUID = 1L;
	
	public final static int WANT_TO_GO = 1;      //想去
	public final static int HAVE_BEAN_TO = 2;    //去过
	public final static int DONT_WANT_TO = 3;    //不想去
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="log_id")
	private int logId;
	
	private String ip;
	
	@Column(name="space_id")
	private int spaceId;
	
	@Column(name="comment_type")
	private int commentType;
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getCommentType() {
		return commentType;
	}
	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}
	public int getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
}
