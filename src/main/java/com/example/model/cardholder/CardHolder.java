package com.example.model.cardholder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long memberId;
	private String cardNumber;
}