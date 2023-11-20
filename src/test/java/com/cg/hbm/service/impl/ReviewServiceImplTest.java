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
import com.cg.hbm.entity.Review;
import com.cg.hbm.repository.IReviewRepository;
import com.cg.hbm.service.IReviewService;

@SpringBootTest
class ReviewServiceImplTest {
	
	@MockBean
	IReviewRepository reviewRepository;
	
	@Autowired
	ReviewServiceImpl reviewServiceImpl;
	
	@Autowired
	ModelMapper modelMapper;

	@Test
	void testDeleteReview() {
	        Review mockReview = new Review(); // Create a mock review or use a builder to create one
	        mockReview.setReviewId(1);

	        // Mock the behavior of reviewRepository.findById
	        when(reviewRepository.findById(1)).thenReturn(Optional.of(mockReview));

	        // Act
	        reviewServiceImpl.deleteReview(1);

	        // Assert
	        // Verify that reviewRepository.delete was called with the correct argument
	        verify(reviewRepository, times(1)).delete(mockReview);
	}

	@Test
	void testGetReviewById() {
		ReviewResponseDTO actualOutput=new ReviewResponseDTO();
		actualOutput.setId(1);
		
		Review review =modelMapper.map(actualOutput, Review.class);
		
		when(reviewRepository.findById(1)).thenReturn(Optional.of(review));
		
		assertEquals(actualOutput, reviewServiceImpl.getReviewById(1));
	}
//
	@Test
	void testGetAllReviews() {
		List<ReviewResponseDTO> actualoutput=new ArrayList<>();
		actualoutput.add(new ReviewResponseDTO(1, null, 0));
		actualoutput.add(new ReviewResponseDTO(2,null,0));
		
		List<Review> testusers=actualoutput.stream()
				.map(review->modelMapper.map(review, Review.class))
				.collect(Collectors.toList());
		
		when(reviewRepository.findAll()).thenReturn(testusers);
		
		assertEquals(actualoutput, reviewServiceImpl.getAllReviews());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
