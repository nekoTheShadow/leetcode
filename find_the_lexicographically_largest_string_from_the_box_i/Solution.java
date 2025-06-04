package find_the_lexicographically_largest_string_from_the_box_i;

public class Solution {
  public String answerString(String word, int numFriends) {
    if (numFriends == 1) {
      return word;
    }

    int len = word.length();
    int n = len - numFriends + 1;
    String ret = "";
    for (int i = 0; i < len; i++) {
      String substr = word.substring(i, Math.min(i + n, len));
      if (ret.compareTo(substr) < 0) {
        ret = substr;
      }
    }
    return ret;
  }
}
