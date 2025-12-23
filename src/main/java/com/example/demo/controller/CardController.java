package com.example.demo.controller;

import com.example.demo.entity.Card;
import com.example.demo.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id){
        return cardService.getOneCard(id);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id,@Valid @RequestBody Card card) {
        return cardService.updateCard(id, card);
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id ){
        cardService.deleteCard(id);
    }

    @PostMapping
    public Card createCard(@Valid @RequestBody Card card) {
        return cardService.createCard(card);
    }
}
