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

import com.cg.hbm.dto.BookingDetailsResponseDTO;
import com.cg.hbm.dto.ReviewResponseDTO;
import com.cg.hbm.entity.BookingDetails;
import com.cg.hbm.entity.Review;
import com.cg.hbm.repository.IBookingDetailsRepository;
import com.cg.hbm.service.IBookingDetailsService;

@SpringBootTest
class BookingDetailsServiceImplTest {
	
	@MockBean
	IBookingDetailsRepository bookingDetailsRepository;
	
	@Autowired
	IBookingDetailsService bookingDetailsService;
	
	@Autowired
	ModelMapper modelMapper;

	@Test
	void testDeleteBookingDetails() {
		BookingDetails mockbooking = new BookingDetails(); // Create a mock review or use a builder to create one
		mockbooking.setBookingId(1);

        // Mock the behavior of bookingDetailsRepository.findById
        when(bookingDetailsRepository.findById(1)).thenReturn(Optional.of(mockbooking));

        // Act
        bookingDetailsService.deleteBookingDetails(1);

        // Assert
        // Verify that bookingDetailsRepository.delete was called with the correct argument
        verify(bookingDetailsRepository, times(1)).delete(mockbooking);
	}

	@Test
	void testGetBookingDetailsById() {
		BookingDetailsResponseDTO actualOutput=new BookingDetailsResponseDTO();
		actualOutput.setId(1);
		
		BookingDetails booking =modelMapper.map(actualOutput, BookingDetails.class);
		
		when(bookingDetailsRepository.findById(1)).thenReturn(Optional.of(booking));
		
		assertEquals(actualOutput, bookingDetailsService.getBookingDetailsById(1));
	}
//
	@Test
	void testGetAllBookingDetails() {
		List<BookingDetailsResponseDTO> actualoutput=new ArrayList<>();
		actualoutput.add(new BookingDetailsResponseDTO(1, null, null, 0, 0, 0, null));
		actualoutput.add(new BookingDetailsResponseDTO(2, null, null, 0, 0, 0, null));
		
		List<BookingDetails> testbookings=actualoutput.stream()
				.map(booking->modelMapper.map(booking, BookingDetails.class))
				.collect(Collectors.toList());
		
		when(bookingDetailsRepository.findAll()).thenReturn(testbookings);
		
		assertEquals(actualoutput, bookingDetailsService.getAllBookingDetails());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
