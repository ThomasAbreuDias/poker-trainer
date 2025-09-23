package app.poker.core.hand;

import app.poker.core.playingcard.Card;
import app.poker.core.utils.HandCodes;

/**
 * Represents a two-card poker hand.
 */
public record TwoCardHand(Card first, Card second) {
    /**
     * Constructs a TwoCardHand with the specified cards.
     * @param first  the first card
     * @param second the second card
     * @throws IllegalArgumentException if either card is null or if both cards are identical
     */
    public TwoCardHand {
        if(first == null || second == null) {
            throw new IllegalArgumentException("Cards cannot be null");
        }
        if (first.equals(second)) {
            throw new IllegalArgumentException("A hand cannot contain duplicate cards");
        }
    }
    /**
     * Returns the canonical code for this two-card hand.
     * @see HandCodes#canonical(Rank, Rank, boolean)
     * @return the canonical hand code as a string
     */
    public String canonicalCode() {
        boolean suited = first.suit() == second.suit();
        return HandCodes.canonical(first.rank(), second.rank(), suited);
    }
    @Override
    public String toString() {
        return first + " " + second + " (" + canonicalCode() + ")";
    }
}
