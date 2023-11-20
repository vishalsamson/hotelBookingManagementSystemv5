package com.cg.hbm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("payment details")
public class Payment {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("unique payment id")
	private int id;
	
	@ApiModelProperty("details about payment status")
	private boolean paymentStatus;
}
