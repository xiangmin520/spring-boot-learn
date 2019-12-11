package com.xiami.redis.entity;

import java.io.Serializable;

/**
 * 用户。
 *
 * @author xiami
 * @since 2019年12月11日
 */
public class User implements Serializable {

	private Integer id;

	private String username;

	private Integer age;

	public User() {
	}

	public User(Integer id, String username, Integer age) {
		this.id = id;
		this.username = username;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}