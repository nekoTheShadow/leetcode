package design_spreadsheet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpreadsheetTest {

  @Test
  void example1() {
    Spreadsheet ss = new Spreadsheet(3);
    assertEquals(12, ss.getValue("=5+7"));
    ss.setCell("A1", 10);
    assertEquals(16, ss.getValue("=A1+6"));
    ss.setCell("B2", 15);
    assertEquals(25, ss.getValue("=A1+B2"));
    ss.resetCell("A1");
    assertEquals(15, ss.getValue("=A1+B2"));
  }

}
