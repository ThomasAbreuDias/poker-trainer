package app.poker.core;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import app.poker.core.playingcard.Rank;
import app.poker.core.utils.HandCodes;

public class RankComparisonTest {
    @Test
    void aceBeatsKing_descComparator() {
        assertTrue(HandCodes.compareRankDesc(Rank.ACE, Rank.KING) < 0);
        assertTrue(Rank.ACE.value() > Rank.KING.value());
    }
}
