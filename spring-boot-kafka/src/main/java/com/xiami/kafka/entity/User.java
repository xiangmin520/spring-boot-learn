package com.xiami.kafka.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户。
 *
 * @author xiami
 * @since 2019年12月11日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private Integer id;

	private String username;

	private Integer age;
}
