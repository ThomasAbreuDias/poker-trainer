package app.poker.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import app.poker.core.playingcard.Deck;
import app.poker.core.playingcard.Card;

public class DeckDeterminismTest {
    @Test
    void sameSeed_sameOrder() {
        long seed = 123456789L;
        Deck d1 = Deck.standard().shuffle(seed);
        Deck d2 = Deck.standard().shuffle(seed);

        List<Card> first10_d1 = d1.draw(10);
        List<Card> first10_d2 = d2.draw(10);

        assertEquals(first10_d1, first10_d2, "Même seed => même tirage");
    }
    @Test
    void sameSeed_sameOrder2() {
        long seed = 143456789L;
        Deck d1 = Deck.standard().shuffle(seed);
        Deck d2 = Deck.standard().shuffle(seed);

        List<Card> all_d1 = d1.draw(52);
        List<Card> all_d2 = d2.draw(52);

        assertEquals(all_d1, all_d2, "Même seed => même decks");
    }
    @Test
    void differentSeeds_probablyDifferentOrder() {
        Deck d1 = Deck.standard().shuffle(1L);
        Deck d2 = Deck.standard().shuffle(2L);

        // On teste sur quelques cartes pour limiter le faux-positif
        List<Card> first5_d1 = d1.draw(5);
        List<Card> first5_d2 = d2.draw(5);

        assertNotEquals(first5_d1, first5_d2, "Seeds différents => ordre probablement différent");
    }
}
