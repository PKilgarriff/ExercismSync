import java.util.Collections;
import java.util.List;
import java.util.Random;

class DnDCharacter {
  private static final int BASE_HEALTH = 10;

  private final Random random = new Random();

  private final int strength;
  private final int dexterity;
  private final int constitution;
  private final int intelligence;
  private final int wisdom;
  private final int charisma;

  DnDCharacter() {
    this.strength = ability(rollDice());
    this.dexterity = ability(rollDice());
    this.constitution = ability(rollDice());
    this.intelligence = ability(rollDice());
    this.wisdom = ability(rollDice());
    this.charisma = ability(rollDice());
  }

  int ability(List<Integer> scores) {
    int totalScore = scores.stream()
        .mapToInt(Integer::intValue)
        .sum();

    return totalScore - Collections.min(scores);
  }

  private int rollDie() {
    return random.nextInt(1, 7);
  }

  List<Integer> rollDice() {
    return List.of(rollDie(), rollDie(), rollDie(), rollDie());
  }

  int modifier(int input) {
    return (int) Math.floor((input - 10) / 2.0);
  }

  int getStrength() {
    return this.strength;
  }

  int getDexterity() {
    return this.dexterity;
  }

  int getConstitution() {
    return this.constitution;
  }

  int getIntelligence() {
    return this.intelligence;
  }

  int getWisdom() {
    return this.wisdom;
  }

  int getCharisma() {
    return this.charisma;
  }

  int getHitpoints() {
    return BASE_HEALTH + modifier(getConstitution());
  }
}
