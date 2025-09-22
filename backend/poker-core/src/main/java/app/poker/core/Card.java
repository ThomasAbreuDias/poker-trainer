package app.poker.core;
public record Card(Rank rank, Suit suit) {
  public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
  public enum Rank { TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE }
}