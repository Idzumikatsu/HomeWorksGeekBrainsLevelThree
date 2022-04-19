package LessonSix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class MainAppTest {

    @ParameterizedTest
    @MethodSource("dataForCutNumbersAfterFourInArrTest")
    public void testCutNumbersAfterFourInArr(Integer[] result, Integer[] arr) {
        Assertions.assertArrayEquals(result, MainApp.cutNumbersAfterFourInArr(arr));
    }

    public static Stream<Arguments> dataForCutNumbersAfterFourInArrTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[]{6}, new Integer[]{1, 4, 5, 6, 2, 4, 6}));
        out.add(Arguments.arguments(new Integer[0], new Integer[]{2, 3, 5, 6, 4}));
        out.add(Arguments.arguments(new Integer[]{5, 6, 1, 5, 3}, new Integer[]{1, 2, 3, 5, 2, 4, 5, 6, 1, 5, 3}));
        out.add(Arguments.arguments(new Integer[]{2}, new Integer[]{4, 4, 4, 4, 4, 5, 2, 1, 4, 2}));
        out.add(Arguments.arguments(new Integer[]{2, 3, 5, 1}, new Integer[]{5, 6, 2, 4, 2, 3, 5, 1}));
        return out.stream();
    }

    @Test
    public void throwableForCutNumbersAfterFourInArrTest() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            MainApp.cutNumbersAfterFourInArr(new Integer[]{1, 3, 5, 2, 6, 2});
        });
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArrayForExactNumbersTrueTest")
    public void checkArrayForExactNumbersTrueTest(Integer[] arr) {
        Assertions.assertTrue(MainApp.checkArrayForExactNumbers(arr));
    }

    public static Stream<Arguments> dataForCheckArrayForExactNumbersTrueTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[]{1, 4, 1, 4, 1, 4, 4}, true));
        out.add(Arguments.arguments(new Integer[]{4, 4, 1, 4}, true));
        out.add(Arguments.arguments(new Integer[]{1, 1, 1, 1, 4, 1, 1, 1, 1, 4},true));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArrayForExactNumbersFalseTest")
    public void checkArrayForExactNumbersFalseTest(Integer[] arr) {
        Assertions.assertFalse(MainApp.checkArrayForExactNumbers(arr));
    }

    public static Stream<Arguments> dataForCheckArrayForExactNumbersFalseTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new Integer[]{1, 1, 1, 1, 1, 1, 1}, false));
        out.add(Arguments.arguments(new Integer[]{4, 4, 4, 4}, false));
        out.add(Arguments.arguments(new Integer[]{1, 1, 5, 1, 4, 1, 2, 1, 1, 4},false));
        out.add(Arguments.arguments(new Integer[]{2,4,1,5,6,6,6,6,3,3},false));
        out.add(Arguments.arguments(new Integer[]{5,5,3,2,6,6,7},false));
        return out.stream();
    }
}