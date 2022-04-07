package com.nastyHaze.havethem.data;

import com.nastyHaze.havethem.data.Card;
import com.nastyHaze.havethem.constant.Rank;
import com.nastyHaze.havethem.constant.Suit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deck {

    List<Card> cards;

    public void init() {
        List<Suit> suits = List.of(Suit.values());
        List<Rank> ranks = List.of(Rank.values());

        cards = suits.stream()
                .map(suit -> ranks.stream()
                        .map( rank -> new Card(suit, rank))
                        .collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
