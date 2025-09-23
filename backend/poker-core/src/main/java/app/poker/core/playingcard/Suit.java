package app.poker.core.playingcard;
/**
 * Represents the suit of a playing card.
 */
public enum Suit {
    CLUBS('c'),
    DIAMONDS('d'),
    HEARTS('h'),
    SPADES('s');

    private final char symbol;

    Suit(char symbol) {
        this.symbol = symbol;
    }
    public char symbol() {
        return symbol;
    }
    /**
     * Parses a suit from its character symbol.
     *
     * @param s the character symbol representing the suit ('c', 'd', 'h', 's')
     * @return the corresponding Suit enum value
     * @throws IllegalArgumentException if the symbol is not recognized
     */
    public static Suit fromSymbol(char s) {
        return switch (Character.toLowerCase(s)) {
            case 'c' -> CLUBS;
            case 'd' -> DIAMONDS;
            case 'h' -> HEARTS;
            case 's' -> SPADES;
            default -> throw new IllegalArgumentException("Unknown suit symbol: " + s);
        };
    }
}
