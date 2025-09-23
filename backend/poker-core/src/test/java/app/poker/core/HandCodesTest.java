package app.poker.core;

import org.junit.jupiter.api.Test;

import app.poker.core.hand.TwoCardHand;
import app.poker.core.playingcard.Rank;
import app.poker.core.playingcard.Card;
import app.poker.core.playingcard.Suit;
import app.poker.core.utils.HandCodes;

import static org.junit.jupiter.api.Assertions.*;

public class HandCodesTest {
       @Test
    void pairAA() {
        TwoCardHand h = new TwoCardHand(
                new Card(Rank.ACE, Suit.SPADES),
                new Card(Rank.ACE, Suit.HEARTS)
        );
        assertEquals("AA", h.canonicalCode());
    }

    @Test
    void AKs_whenSuited() {
        TwoCardHand h = new TwoCardHand(
                new Card(Rank.ACE, Suit.HEARTS),
                new Card(Rank.KING, Suit.HEARTS)
        );
        assertEquals("AKs", h.canonicalCode());
    }

    @Test
    void AKo_whenOffsuit() {
        TwoCardHand h = new TwoCardHand(
                new Card(Rank.ACE, Suit.CLUBS),
                new Card(Rank.KING, Suit.DIAMONDS)
        );
        assertEquals("AKo", h.canonicalCode());
    }

    @Test
    void utilCanonical_matchesHand() {
        String util = HandCodes.canonical(Rank.TEN, Rank.NINE, true);
        TwoCardHand h = new TwoCardHand(
                new Card(Rank.TEN, Suit.SPADES),
                new Card(Rank.NINE, Suit.SPADES)
        );
        assertEquals("T9s", util);
        assertEquals(util, h.canonicalCode());
    }

    @Test
    void rejectDuplicateCard() {
        Card as = new Card(Rank.ACE, Suit.SPADES);
        assertThrows(IllegalArgumentException.class, () -> new TwoCardHand(as, as));
    }
}
