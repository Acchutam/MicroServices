package com.rating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	private int userId;
	private int hotelId;
	private int rating;
	private String feedback;
	
}
