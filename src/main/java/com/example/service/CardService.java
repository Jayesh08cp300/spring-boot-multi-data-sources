package com.example.service;

import com.example.model.card.Card;
import com.example.model.cardholder.CardHolder;
import com.example.model.member.Member;
import com.example.repository.card.CardRepository;
import com.example.repository.cardholder.CardHolderRepository;
import com.example.repository.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CardService {

	private CardRepository cardRepository;
	private CardHolderRepository cardHolderRepository;
	private MemberRepository memberRepository;

	@Transactional(rollbackFor = RuntimeException.class)
	public CardHolder issueNewCard(String memberName, Integer age) {
		Member member = Member.builder()
				.name(memberName).age(age)
				.build();
		member = memberRepository.save(member);

		Card card = Card.builder()
				.name("Visa")
				.cvv("111")
				.expirationMonth(12)
				.expirationYear(2026)
				.number("0123456789")
				.build();
		card = cardRepository.save(card);

		if(member.getAge() < 18) throw new RuntimeException("Age is below 18;");

		CardHolder cardHolder = CardHolder.builder()
				.cardNumber(card.getNumber())
				.memberId(member.getId())
				.build();
		return cardHolderRepository.save(cardHolder);
	}

}
