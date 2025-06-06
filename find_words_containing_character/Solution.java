package find_words_containing_character;

import java.util.List;
import java.util.stream.IntStream;

public class Solution {
  public List<Integer> findWordsContaining(String[] words, char x) {
    return IntStream.range(0, words.length).filter(i -> words[i].indexOf(x) != -1).boxed().toList();
  }
}
