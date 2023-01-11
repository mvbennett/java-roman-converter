import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class RomanConverter {
  private static HashMap<String, Integer> ROMAN_TO_ARABIC = new HashMap<>();

  public static HashMap<String, Integer> arrayToHash(List<String> keys, List<Integer> values) {
    HashMap<String, Integer> hash = new HashMap<>();
    for (int i = 0; i < keys.size(); i++) {
      hash.put(keys.get(i), values.get(i));
    }
    return hash;
  }

  public static int romanToInteger(String romanString) {
    int sum = 0;
    while (romanString.length() > 0) {
      for (String symbol : ROMAN_TO_ARABIC.keySet()) {
        if (romanString.startsWith(symbol)) {
          sum += ROMAN_TO_ARABIC.get(symbol);
          romanString = romanString.substring(symbol.length());
          break;
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    List<String> roman = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "L", "XL", "X", "IX", "V", "IV", "I");
    List<Integer> arabic = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    ROMAN_TO_ARABIC = arrayToHash(roman, arabic);
    // System.out.println(ROMAN_TO_ARABIC);

    System.out.println(romanToInteger("MCMXCIV"));
  }
}
