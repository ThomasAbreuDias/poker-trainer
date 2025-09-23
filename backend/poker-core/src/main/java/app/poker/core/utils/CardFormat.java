package app.poker.core.utils;

import app.poker.core.playingcard.Card;
import app.poker.core.playingcard.Suit;


/**
 * Utility class for formatting playing cards for readable display.
 */
public final class CardFormat {
    private CardFormat() {}

    /*
    * Returns a "beautiful" representation of a card with suit symbols.
    */
    public static String beauty(Card card) {
        return card.rank().symbol() + suitSymbol(card.suit());
    }

    private static String suitSymbol(Suit suit) {
        return switch (suit) {
            case HEARTS   -> "♥️";
            case DIAMONDS -> "♦️";
            case CLUBS    -> "♣️";
            case SPADES   -> "♠️";
        };
    }


    /*
     * Returns a "beautiful" representation of a card with suit symbols and ANSI colors.
     */
    public static String beautyAnsi(Card card) {
        String base = card.rank().symbol() + suitSymbol(card.suit());
        return switch (card.suit()) {
            case HEARTS, DIAMONDS -> "\u001B[31m" + base + "\u001B[0m"; // red
            case CLUBS, SPADES    -> "\u001B[30m" + base + "\u001B[0m"; // black
        };
    }
}
