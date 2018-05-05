package com.roger.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 6457393207289324388L;
	private int id;
	private String name;
	private BigDecimal price;
	private String pic;
	private String remark;
	private String remarkDetail;
	private Timestamp productDate;
	private Boolean commend;
	private Boolean open;
	private Category category;
}
