package com.nastyHaze.havethem;

import com.nastyHaze.havethem.data.Card;
import com.nastyHaze.havethem.data.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.nastyHaze.havethem.constant.CommonConstant.DECK_SIZE;
import static org.junit.jupiter.api.Assertions.*;


public class DeckTest {

    private final Logger log = LoggerFactory.getLogger(getClass());

    Deck deck1;

    Deck deck2;

    @BeforeEach
    public void setup() {
        deck1 = new Deck();
        deck2 = new Deck();
    }

    @Test
    public void init_test() {
        deck1.init();

        log.info("Init deck: " + deck1.toString());

        assertNotNull(deck1);
        assertEquals(DECK_SIZE, deck1.getCards().size());
    }

    @Test
    public void shuffle_testCompareUnshuffled() {
        deck1.init();
        deck2.init();

        deck1.shuffle();

        log.info("Shuffled deck: " + deck1.toString());
        log.info("Unshuffled deck: " + deck2.toString());

        assertNotEquals(deck1, deck2);
    }

    @Test
    public void shuffle_testCompareShuffled() {
        deck1.init();
        deck2.init();

        deck1.shuffle();
        deck2.shuffle();

        log.info("Shuffled deck: " + deck1.toString());
        log.info("Another shuffled deck: " + deck2.toString());

        assertNotEquals(deck1, deck2);
    }

    @Test
    public void deal_testUnshuffled() {
        deck1.init();
        deck2.init();

        List<Card> dealtCards = new ArrayList<>();

        for(int i = 0; i < DECK_SIZE; i++) {
            dealtCards.add(deck1.deal());
        }

        log.info("dealtCards: " + dealtCards);

        assertTrue(deck1.getCards().isEmpty());
        assertEquals(deck2.getCards(), dealtCards);
    }

    @Test
    public void deal_testShuffled() {
        deck1.init();
        deck1.shuffle();

        List<Card> shuffledCards = new ArrayList<>(deck1.getCards());
        List<Card> dealtCards = new ArrayList<>();

        for(int i = 0; i < DECK_SIZE; i++) {
            dealtCards.add(deck1.deal());
        }

        log.info("dealtCards: " + dealtCards);

        assertTrue(deck1.getCards().isEmpty());
        assertEquals(shuffledCards, dealtCards);
    }
}
