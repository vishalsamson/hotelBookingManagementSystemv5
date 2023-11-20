package com.cg.hbm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Details of rooms")
public class RoomDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("unique id of room")
	private int roomId;
	
	@Column(unique = true)
	@ApiModelProperty("unique roomNo of room")
	private String roomNo;
	
	@ApiModelProperty("unique roomType of room")
	private String roomType;
	
	@ApiModelProperty("unique ratePerDay of room")
	private double ratePerDay;
	
	@ApiModelProperty("status of room")
	private boolean isavailable;
	
	//image name
	@ApiModelProperty("unique fileName of room")
	private String fileName;
	
	//image type
	@ApiModelProperty("fileType of room")
    private String fileType;
	
	@ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER )
	@JoinColumn(name = "hotel_id")
	@JsonIgnore
	private Hotel hotel;

}
