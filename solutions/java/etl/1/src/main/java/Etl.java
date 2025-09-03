import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Etl {

  Map<String, Integer> transform(Map<Integer, List<String>> old) {
    Map<String, Integer> newScoringMap = new HashMap<>();
    old.entrySet().stream().forEach(entry -> {
      entry.getValue().stream().forEach(letter -> {
        newScoringMap.put(letter.toLowerCase(), entry.getKey());
      });
    });

    return newScoringMap;
  }
}
