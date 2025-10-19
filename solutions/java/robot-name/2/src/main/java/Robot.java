import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Robot {
  private static List<String> robotNames = new ArrayList<>();
  private Random random = new Random();
  private String name;

  public Robot() {
    this.name = generateName();
  }

  public String getName() {
    return this.name;
  }

  public void reset() {
    String originalName = this.name;

    this.name = generateName();

    robotNames.remove(originalName);
  }

  private String generateName() {
    String generatedName = generateAlphabeticSection() + generateNumericSection();

    while (robotNames.contains(generatedName)) {
      generatedName = generateAlphabeticSection() + generateNumericSection();
    }

    robotNames.add(generatedName);

    return generatedName;
  }

  private String generateAlphabeticSection() {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 2;

    return random.ints(leftLimit, rightLimit + 1)
        .limit(targetStringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString()
        .toUpperCase();
  }

  private String generateNumericSection() {
    return String.format("%03d", random.nextInt(1000));
  }

}