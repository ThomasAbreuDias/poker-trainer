package app.poker.core.playingcard;

import java.util.Arrays;
import java.util.List;

/**
 * Represents the rank of a playing card.
 */
public enum Rank {
    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13),
    ACE('A', 14);

    private final char symbol;
    private final int value;

    Rank(char symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }
    
    public char symbol() {
        return symbol;
    }

     public int value() {
        return value;
    }

    // List of ranks in descending order
    public static final List<Rank> DESC = List.of(ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO);

    /**
     * Parses a rank from its character symbol.
     *
     * @param s the character symbol representing the rank ('2'-'9', 'T', 'J', 'Q', 'K', 'A')
     * @return the corresponding Rank enum value
     * @throws IllegalArgumentException if the symbol is not recognized
     */
    public static Rank fromSymbol(char s) {
        return Arrays.stream(values())
                .filter(r -> r.symbol == Character.toUpperCase(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown rank symbol: " + s));
    }
}
