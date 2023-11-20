package com.cg.hbm.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("detals of hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("unique hotel id of hotel")
	private int hotelId;
	
	@ApiModelProperty("city of hotel")
	private String city;
	
	@ApiModelProperty("unique hotel hotelName of hotel")
	private String hotelName;
	
	@ApiModelProperty("unique hotel address of hotel")
	private String address;
	
	@ApiModelProperty("unique hotel description of hotel")
	private String description;
	
	@ApiModelProperty("unique hotel average rate per day of hotel")
	private double averageRatePerDay;
	
	@ApiModelProperty("unique hotel emailof hotel")
	private String email;
	
	@ApiModelProperty("unique hotel phone number of hotel")
	private String phone1;
	
	@ApiModelProperty("unique hotel phone number of hotel")
	private String phone2;
	
	@ApiModelProperty("unique hotel website  of hotel")
	private String website;
	
	@ApiModelProperty("booking status of file")
	private boolean isBooked;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
	private List<RoomDetails> roomDetailsList;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.PERSIST)
	private List<BookingDetails> bookingDetails;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.PERSIST)
	private Set<Review> reviews;
}
