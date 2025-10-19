import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
  private String word;
  private String discovered;
  private Set<String> guesses;
  private Set<String> misses;
  private List<Part> parts;
  private Status status;

  public Output newGame(String word) {
    this.word = word;
    this.discovered = "_".repeat(word.length());
    this.guesses = new HashSet<>();
    this.misses = new HashSet<>();
    this.parts = new ArrayList<>();
    this.status = Status.PLAYING;
    return getOutput();
  }

  public Output makeGuess(String guess) {
    if (this.guesses.contains(guess) || this.misses.contains(guess)) {
      throw new IllegalArgumentException("Letter " + guess + " was already played");
    }

    if (this.word.contains(guess)) {
      this.guesses.add(guess);
      updateDiscovered(guess);
    } else {
      this.misses.add(guess);
      this.parts.add(Part.values()[this.misses.size() - 1]);
    }

    if (this.word.equals(this.discovered)) {
      setStatus(Status.WIN);
    }

    if (this.parts.size() >= Part.values().length) {
      setStatus(Status.LOSS);
    }

    return getOutput();
  }

  public Output getOutput() {
    return new Output(
        this.word,
        this.discovered,
        this.guesses,
        this.misses,
        this.parts,
        this.status);
  }

  private void updateDiscovered(String guess) {
    StringBuilder discoveredBuilder = new StringBuilder(this.word.length());

    for (int i = 0; i < this.word.length(); i++) {
      if (guess.equals(this.word.substring(i, i + 1))) {
        discoveredBuilder.append(guess);
      } else {
        discoveredBuilder.append(this.discovered.substring(i, i + 1));
      }
    }

    setDiscovered(discoveredBuilder.toString());
  }

  private void setStatus(Status status) {
    this.status = status;
  }

  private void setDiscovered(String discovered) {
    this.discovered = discovered;
  }

}