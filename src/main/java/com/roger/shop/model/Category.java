package com.roger.shop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable{

	private static final long serialVersionUID = -1561866328091742991L;
	
	private int id;
	private String type;
	private boolean hot;
	
}
