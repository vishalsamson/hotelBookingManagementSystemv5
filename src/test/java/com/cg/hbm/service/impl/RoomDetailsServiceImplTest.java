package com.cg.hbm.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.hbm.dto.ReviewResponseDTO;
import com.cg.hbm.dto.RoomDetailsResponseDTO;
import com.cg.hbm.entity.Review;
import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.repository.IRoomDetailsRepository;
import com.cg.hbm.service.IRoomDetailsService;


@SpringBootTest
class RoomDetailsServiceImplTest {
	
	@MockBean
	IRoomDetailsRepository roomDetailsRepository;
	
	@Autowired
	RoomDetailsServiceImpl roomDetailsService;
	
	
	@Autowired
	ModelMapper modelMapper;

	@Test
	void testDeleteRoomDetails() {
		RoomDetails mockRoom=new RoomDetails(1, null, null, 0, false, null, null, null);
		
		when(roomDetailsRepository.findById(1)).thenReturn(Optional.of(mockRoom));
		
		roomDetailsService.deleteRoomDetails(1);
		
		verify(roomDetailsRepository, times(1)).delete(mockRoom);
	}

	@Test
	void testGetRoomDetailsById() {
		RoomDetailsResponseDTO actualOutput=new RoomDetailsResponseDTO();
		actualOutput.setId(1);
		
		RoomDetails room =modelMapper.map(actualOutput, RoomDetails.class);
		
		when(roomDetailsRepository.findById(1)).thenReturn(Optional.of(room));
		
		assertEquals(actualOutput, roomDetailsService.getRoomDetailsById(1));
	}
//
	@Test
	void testGetAllRoomDetails() {
		List<RoomDetailsResponseDTO> actualoutput=new ArrayList<>();
		actualoutput.add(new RoomDetailsResponseDTO(1, "A203", null, 0, false, null, null));
		actualoutput.add(new RoomDetailsResponseDTO(2, "A204", null, 0, false, null, null));
		
		List<RoomDetails> testrooms=actualoutput.stream()
				.map(room->modelMapper.map(room, RoomDetails.class))
				.collect(Collectors.toList());
		
		when(roomDetailsRepository.findAll()).thenReturn(testrooms);
		
		assertEquals(actualoutput, roomDetailsService.getAllRoomDetails());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
