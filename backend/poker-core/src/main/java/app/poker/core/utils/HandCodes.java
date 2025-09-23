package app.poker.core.utils;

import app.poker.core.playingcard.Rank;

/**
 * Utility class that deal with canonical hand codes and rank comparisons.
 * The canonical form is:
    * - For pairs: "AA", "TT", etc. (suited flag is ignored)
    * - For non-pairs: high-low + 's' (suited) or 'o' (offsuit), e.g., "AKs", "AKo", "T9s".
 */
public final class HandCodes {
    private HandCodes() {}
    /**
     * Returns the canonical hand code for two ranks and a suited flag.
     * @param a      the first rank
     * @param b      the second rank
     * @param suited true if the hand is suited, false if offsuit
     * @return the canonical hand code as a string
     */
    public static String canonical(Rank a, Rank b, boolean suited) {
        if (a == b) {
            // Pairs (ignoring suited)
            return "" + a.symbol() + b.symbol();
        }
        // Non-pairs
        Rank high = a.value() >= b.value() ? a : b;
        Rank low  = a.value() >= b.value() ? b : a;
        return "" + high.symbol() + low.symbol() + (suited ? "s" : "o");
    }
    /**
     * Compare two ranks in descending order (higher rank first).
     * @param left  the first rank to compare
     * @param right the second rank to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     *         equal to, or greater than the second (in descending order)
     */
    public static int compareRankDesc(Rank left, Rank right) {
        return Integer.compare(right.value(), left.value());
    }
}
