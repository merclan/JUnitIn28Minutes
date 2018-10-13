package tech.merclan;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class StringTest {

  @BeforeAll
  static void beforeAll() {
    System.out.println("before all");
  }

  @BeforeEach
    //@Before
  void beforeEach(TestInfo testInfo) {
    System.out.println("before " + testInfo.getDisplayName());
  }

  @AfterEach
    //After
  void afterEach(TestInfo testInfo) {
    System.out.println("after " + testInfo.getDisplayName());
  }


  @AfterAll
  static void afterAll() {
    System.out.println("after all");
  }

  @Test
  @Disabled
    //@Ignore
  void failTest() {
    fail("not yet implemented");
  }

  @Test
  void verifyLenght() {
    int actualLength = "ABCD".length();
    int expectedLength = 4;
    assertEquals(expectedLength, actualLength);
  }

  @Test
  @DisplayName("When string is null throw an exception")
  void verifyException() {
    String str = null;
    assertThrows(NullPointerException.class, () -> {
      str.length();
    });
  }

  @RepeatedTest(5)
  void toUpperCase() {
    String str = "abcd";
    String result = str.toUpperCase();
    assertEquals("ABCD", result);
    assertNotNull(result);
  }

  @Test
  void contains() {
    String str = "abcdefgh";
    boolean result = str.contains("ijk");
    assertFalse(result);
  }

  @Test
  void split() {
    String str = "abc def ghi";
    String actualResult[] = str.split(" ");
    String expectedResult[] = new String[]{"abc", "def", "ghi"};
    assertArrayEquals(expectedResult, actualResult);
  }

  @Test
  void lengthGreaterThanZero() {
    assertTrue("ABCD".length() > 0);
    assertTrue("ABC".length() > 0);
    assertTrue("A".length() > 0);
    assertTrue("DEF".length() > 0);
  }

  @ParameterizedTest
  @DisplayName("length greater than zero")
  @ValueSource(strings = {"ABCD", "ABC", "A", "DEF"})
  void lengthGreaterThanZeroUsingParameterizedTest(String str) {
    assertTrue(str.length() > 0);
  }


  @ParameterizedTest(name = "{0} length is {1}")
  @DisplayName("length greater than zero CSV")
  @CsvSource(value = {"ABCD, 4", "ABC, 3", "A, 1", "'',0", "ABCDEFG,7"})
  void lengthGreaterThanZeroUsingParameterizedTest(String word, int expectedLength) {
    assertEquals(expectedLength, word.length());
  }

  @Test
  void performanceTest() {
    assertTimeout(Duration.ofMillis(1), () -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(i);
      }
    });
  }

  private String str;

  @Nested
  @DisplayName("For an empty string")
  class EmptyStringTest {

    @BeforeEach
    void setToEmpty() {
      str = "";
    }

    @Test
    @DisplayName("length greater than zero")
    void lengthIsZero() {
      assertEquals(0, str.length());
    }

    @Test
    @DisplayName("upper case is empty")
    void upperCaseIsEmpty() {
      assertEquals(0, str.toUpperCase().length());
    }
  }

}
