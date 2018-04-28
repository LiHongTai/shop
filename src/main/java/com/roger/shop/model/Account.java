package com.roger.shop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 2737885130081062139L;
	
	private Integer id;
	private String login;
	private String name;
	private String password;

}
