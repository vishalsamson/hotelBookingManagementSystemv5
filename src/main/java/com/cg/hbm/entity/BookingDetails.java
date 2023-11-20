package com.cg.hbm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("details of all Bookings")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("unique booking id of booking")
	private int bookingId;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_id")
	@ApiModelProperty("unique booking id of booking")
	private User user;
	
	@ApiModelProperty("date  of booking")
	private LocalDate bookedFrom;
	
	@ApiModelProperty("date  of upto booking")
	private LocalDate bookedTo;
	
	@ApiModelProperty("number of adults in booking")
	private int noOfAdults;
	
	@ApiModelProperty("number of children in booking")
	private int noOfChildren;
	
	@ApiModelProperty("amount of booking")
	private double amount;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
//	@OneToMany(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "room_id")
//	RoomDetails roomDetails;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<RoomDetails> roomDetailsList;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
}
