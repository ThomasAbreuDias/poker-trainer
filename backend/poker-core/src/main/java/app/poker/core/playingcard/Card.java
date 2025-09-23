package app.poker.core.playingcard;
import java.util.Objects;
/**
 * Represents a playing card with a rank and suit.
 */
public record Card(Rank rank, Suit suit) {
    public Card {
        Objects.requireNonNull(rank, "Rank cannot be null");
        Objects.requireNonNull(suit, "Suit cannot be null");
    }

    @Override
    public String toString() {
        return "" + rank.symbol() + suit.symbol();
    }
    /**
     * Parses a card from its string representation.
     * The string must be exactly 2 characters long, where the first character represents the rank
     * and the second character represents the suit.
     *
     * @param s the string representation of the card
     * @return the corresponding Card object
     * @throws IllegalArgumentException if the string is not exactly 2 characters long or contains invalid symbols
     */
    public static Card fromString(String s) {
        if (s == null || s.length() != 2) {
            throw new IllegalArgumentException("Card string must be exactly 2 characters long");
        }

        Rank rank = Rank.fromSymbol(Character.toUpperCase(s.charAt(0)));
        Suit suit = Suit.fromSymbol(Character.toLowerCase(s.charAt(1)));
        return new Card(rank, suit);
    }
}