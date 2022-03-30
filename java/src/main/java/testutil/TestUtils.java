package testutil;

import java.util.Arrays;
import java.util.List;
/**
 */
public class TestUtils {
    private static long startTime;
    private static int idx = 1;
    private static int startId;

    public static void newSuite() {
        idx++;
        startId = (idx - 1) * 100;
        TestUtils.printSeparateLine(idx - 1);
        startTime = System.currentTimeMillis();
    }

    @Deprecated
    public static void clockStart() {
        startTime = System.currentTimeMillis();
    }

    public static void printSeparateLine(int caseId) {
        System.out.printf("TestCase%03d-------------------------------%n", caseId);
    }

    public static void print(int actual, int expected) {
        print(++startId, actual, expected);
    }

    public static void print(int[] actual, int[] expected) {
        print(++startId, actual, expected);
    }

    public static void print(boolean actual, boolean expected) {
        print(++startId, actual, expected);
    }

    public static void print(String actual, String expected) {
        print(++startId, actual, expected);
    }

    public static <T> void print(List<T> actual, List<T> expected) {
        print(++startId, actual, expected, true);
    }

    public static <T> void print(List<T> actual, List<T> expected, boolean sameOrder) {
        print(++startId, actual, expected, sameOrder);
    }

    public static void print(int id, int actual, int expected) {
        String assertResult = actual == expected ? "T" : "F";
        if (assertResult.equals("T")) {
            System.out.printf(
                    "Test%03d%s: %s |got: %d |want: %d%n", id, calcDuration(), assertResult, actual, expected);
        } else {
            System.err.printf(
                    "Test%03d%s: %s |got: %d |want: %d%n", id, calcDuration(), assertResult, actual, expected);
        }
    }

    public static void print(int id, int[] actual, int[] expected) {
        String assertResult = Arrays.equals(actual, expected) ? "T" : "F";
        if (assertResult.equals("T")) {
            System.out.printf("Test%03d%s: %s | got:%s | want:%s%n",
                    id,
                    calcDuration(),
                    assertResult,
                    Arrays.toString(actual),
                    Arrays.toString(expected));
        } else {
            System.err.printf("Test%03d%s: %s | got:%s | want:%s%n",
                    id,
                    calcDuration(),
                    assertResult,
                    Arrays.toString(actual),
                    Arrays.toString(expected));
        }
    }

    public static void print(int id, boolean actual, boolean expected) {
        String assertResult = actual == expected ? "T" : "F";
        if (assertResult.equals("T")) {
            System.out.printf("Test%03d%s: %s | got:%b| want:%b%n", id, calcDuration(), assertResult, actual, expected);
        } else {
            System.err.printf("Test%03d%s: %s | got:%b| want:%b%n", id, calcDuration(), assertResult, actual, expected);
        }
    }

    public static void print(int id, String actual, String expected) {
        String assertResult = actual.equals(expected) ? "T" : "F";
        if (assertResult.equals("T")) {
            System.out.printf(
                    "Test%03d%s: %s | got: %s| want: %s%n", id, calcDuration(), assertResult, actual, expected);
        } else {
            System.err.printf(
                    "Test%03d%s: %s | got: %s| want: %s%n", id, calcDuration(), assertResult, actual, expected);
        }
    }

    public static <T> void print(int id, List<T> actual, List<T> expected) {
        print(id, actual, expected, true);
    }

    public static <T> void print(int id, List<T> actual, List<T> expected, boolean sameOrder) {
        String assertResult;
        if (sameOrder) {
            assertResult = actual.equals(expected) ? "T" : "F";
        } else {
            assertResult = actual.containsAll(expected) && expected.containsAll(actual) ? "T" : "F";
        }
        if (assertResult.equals("T")) {
            System.out.printf(
                    "Test%03d%s: %s | got: %s| want: %s%n", id, calcDuration(), assertResult, actual, expected);
        } else {
            System.err.printf(
                    "Test%03d%s: %s | got: %s| want: %s%n", id, calcDuration(), assertResult, actual, expected);
        }
    }

    private static String calcDuration() {
        String duration = String.format(" - %4d ms", startTime == 0 ? 0 : System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        return duration;
    }

    public static void main(String[] args) {
        TestUtils.newSuite();
        TestUtils.print(1, new int[] {39, 25, 15, 28}, new int[] {39, 25, 15, 28});
    }
}

