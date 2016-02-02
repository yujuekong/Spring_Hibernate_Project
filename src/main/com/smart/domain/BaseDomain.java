package com.smart.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 景区po类的基类
 * @author CA
 *
 */
public class BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
