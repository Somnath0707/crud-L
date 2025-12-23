package com.example.demo.service;

import com.example.demo.entity.Card;
import com.example.demo.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {

    // 1. INJECT THE REPOSITORY
    // (We need a 'private final' variable here so Lombok creates the constructor)
    private final CardRepository cardRepository;

    // 2. GET ALL CARDS
    public List<Card> getAllCards() {
        // TODO: Return the list of cards from the repository
        return cardRepository.findAll();
    }

    public Card getOneCard(Long id){
        return cardRepository.findById(id).orElse(null);
    }

    public Card updateCard(Long id , Card cardDetails){
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){
            Card existingCard = cardOptional.get();
            existingCard.setTitle(cardDetails.getTitle());
            existingCard.setDescription(cardDetails.getDescription());
            existingCard.setCategory(cardDetails.getCategory());
            return cardRepository.save(existingCard);
        }
        return null;
    }

    public void deleteCard(Long id){
        cardRepository.deleteById(id);
    }


    // 3. CREATE CARD
    public Card createCard(Card card) {
        // TODO: Save the card using the repository and return it
        return cardRepository.save(card);

    }
}