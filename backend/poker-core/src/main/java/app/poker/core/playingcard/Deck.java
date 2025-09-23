package app.poker.core.playingcard;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
/**
 * Represents a standard deck of 52 playing cards.
 */
public final class Deck {
    private final List<Card> cards;
    private int index = 0;

    private Deck(List<Card> cards) {
        this.cards = cards;
    }
    
    public static Deck standard() {
        List<Card> list = new ArrayList<>(52);
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                list.add(new Card(r, s));
            }
        }
        return new Deck(list);
    }

     /** Fisher–Yates avec RandomGenerator seedable (ex: SplittableRandom) */
    public Deck shuffle(long seed) {
        RandomGenerator rng = RandomGeneratorFactory.of("SplittableRandom").create(seed);
        return shuffle(rng);
    }
    
    public Deck shuffle(RandomGenerator rng) {
        List<Card> copy = new ArrayList<>(cards);
        for (int i = copy.size() - 1; i > 0; i--) {
            int j = rng.nextInt(i + 1);
            Collections.swap(copy, i, j);
        }
        Deck d = new Deck(copy);
        d.index = 0;
        return d;
    }

    /** Shuffle non déterministe si besoin rapide (non utilisé pour les tests) */
    public Deck shuffleUnsecure() {
        SecureRandom sr = new SecureRandom();
        return shuffle(sr);
    }

    public boolean hasNext() {
        return index < cards.size();
    }

    public Card draw() {
        if (!hasNext()) throw new IllegalStateException("Deck empty");
        return cards.get(index++);
    }

    public List<Card> draw(int n) {
        if (index + n > cards.size())
            throw new IllegalStateException("Not enough cards");
        List<Card> out = cards.subList(index, index + n);
        index += n;
        return new ArrayList<>(out);
    }

    public int remaining() {
        return cards.size() - index;
    }

    public List<Card> asList() {
        return List.copyOf(cards);
    }
}