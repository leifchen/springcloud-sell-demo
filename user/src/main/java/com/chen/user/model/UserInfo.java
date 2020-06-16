package com.chen.user.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户
 * <p>
 * @Author LeifChen
 * @Date 2020-06-16
 */
@Data
@Entity
public class UserInfo {

	@Id
	private String id;

	private String username;

	private String password;

	private String openid;

	private Integer role;

	private Date createTime;

	private Date updateTime;
}
