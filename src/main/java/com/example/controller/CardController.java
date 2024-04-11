package com.example.controller;

import com.example.model.cardholder.CardHolder;
import com.example.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CardController {

	private CardService cardService;

	@GetMapping("/NewCard/{name}/{age}")
	public CardHolder newCard(@PathVariable String name, @PathVariable Integer age) {
		return cardService.issueNewCard(name, age);
	}
}
