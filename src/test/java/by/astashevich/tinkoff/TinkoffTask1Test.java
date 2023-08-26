package by.astashevich.tinkoff;

import by.astashevich.tinkoff.converter.ObjectToArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TinkoffTask1Test {

  @Test
  void getInputFromConsole() {
    final String inputString = "123456??90";
    final char[] result = inputString.toCharArray();
    InputStream stdin = System.in;
    System.setIn(new ByteArrayInputStream(inputString.getBytes()));
    char[] output = TinkoffTask1.getInputArrayFromConsole();
    System.setIn(stdin);
    assertArrayEquals(result, output);
  }

  @ParameterizedTest(name = "{index}: {0} must be possible line and return true")
  @ValueSource(strings = {"1234??7890", "11223344550?2?4?6?80?6677889900", "??????????", "1122??1234567?00"})
  void isPossibleLine(@ConvertWith(ObjectToArrayConverter.class) char[] charSequence) {
    assertTrue(TinkoffTask1.isPossibleLine(charSequence));
  }

  @ParameterizedTest(name = "{index}: {0} must be impossible line and return false")
  @ValueSource(strings = {"??1236781", "111111111", "1122??1234567100", "?"})
  void isImPossibleLine(@ConvertWith(ObjectToArrayConverter.class) char[] charSequence) {
    assertFalse(TinkoffTask1.isPossibleLine(charSequence));
  }

}
