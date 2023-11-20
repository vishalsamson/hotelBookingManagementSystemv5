package com.cg.hbm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("details about reviews")
public class Review {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("Unique review id of review")
	private int reviewId;
	
	@ApiModelProperty("Unique review content of review")
	private String reviewContent;
	
	@ApiModelProperty("Unique rating id of review")
	private double rating;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private User user;
}
