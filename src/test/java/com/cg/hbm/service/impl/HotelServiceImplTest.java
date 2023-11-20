package com.cg.hbm.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hbm.dto.HotelResponseDTO;
import com.cg.hbm.entity.Hotel;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.service.IHotelService;


@SpringBootTest
class HotelServiceImplTest {
	
	@MockBean
	IHotelRepository hotelRepository;
	
	@Autowired
	HotelServiceImpl hotelService;
	
	@Autowired
	ModelMapper modelMapper;

	@Test
	void testDeleteHotel() {
		Hotel sampleHotel=new Hotel();
		sampleHotel.setHotelId(1);
		sampleHotel.setHotelName("lemontree");
		
		when(hotelRepository.findById(1)).thenReturn(Optional.of(sampleHotel));
		
		hotelService.deleteHotel(1);
		verify(hotelRepository, times(1)).delete(sampleHotel);	
		
	}

	@Test
	void testGetHotelById() {
		HotelResponseDTO actualOutput=new HotelResponseDTO();
		actualOutput.setHotelId(1);
		actualOutput.setHotelName("lemontree");
		
		Hotel hotel=modelMapper.map(actualOutput, Hotel.class);
		
		when(hotelRepository.findById(1)).thenReturn(Optional.of(hotel));
		
		assertEquals(actualOutput, hotelService.getHotelById(1));
	}
//
	@Test
	void testGetAllHotels() {
		List<HotelResponseDTO> actualOutput=new ArrayList<>();
		actualOutput.add(new HotelResponseDTO(1, "solapur", null, null, null, 0, null, null, null, null, false));
		actualOutput.add(new HotelResponseDTO(2, "pune", null, null, null, 0, null, null, null, null, false));
		
		List<Hotel> allhotels=actualOutput.stream()
				.map(hotel->modelMapper.map(hotel, Hotel.class))
				.collect(Collectors.toList());
		
		when(hotelRepository.findAll()).thenReturn(allhotels);
		
		assertEquals(actualOutput, hotelService.getAllHotels());
	}

}
