package maximum_number_of_words_you_can_type;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    Set<Integer> ngLetters = brokenLetters.chars().boxed().collect(Collectors.toSet());
    int count = 0;
    for (String word : text.split(" ")) {
      if (!hasNgLetters(word, ngLetters)) {
        count++;
      }
    }
    return count;
  }

  private boolean hasNgLetters(String word, Set<Integer> ngLetters) {
    return word.chars().anyMatch(letter -> ngLetters.contains(letter));
  }
}
