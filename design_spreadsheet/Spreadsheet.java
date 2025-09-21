package design_spreadsheet;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spreadsheet {

  private Map<String, String> sheet;

  public Spreadsheet(int rows) {
    this.sheet = new HashMap<>();
  }

  public void setCell(String cell, int value) {
    sheet.put(cell, String.valueOf(value));
  }

  public void resetCell(String cell) {
    sheet.remove(cell);
  }

  public int getValue(String formula) {
    Matcher m = Pattern.compile("^=(.+)\\+(.+)$").matcher(formula);
    m.find();
    return eval(m.group(1)) + eval(m.group(2));
  }

  private int eval(String cell) {
    if (cell.matches("^[0-9]+$")) {
      return Integer.parseInt(cell);
    }

    if (sheet.containsKey(cell)) {
      return eval(sheet.get(cell));
    } else {
      return 0;
    }
  }
}
