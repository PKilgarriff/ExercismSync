import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Etl {

  Map<String, Integer> transform(Map<Integer, List<String>> old) {
    Map<String, Integer> newScoringMap = new HashMap<>();
    old.forEach((score, letters) -> {
      letters.forEach(letter -> {
        newScoringMap.put(letter.toLowerCase(), score)
      });
    });
    return newScoringMap;
  }
}
