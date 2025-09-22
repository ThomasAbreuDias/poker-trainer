package app.poker.trainer.preflop;
public class PreflopService {
  public String decisionFor(String handCode, String position) {
    // TODO: brancher sur des ranges (JSON). Pour l’instant, stub:
    return switch (handCode) {
      case "AA","KK","QQ","AKs","AKo" -> "RAISE";
      default -> "FOLD";
    };
  }
}