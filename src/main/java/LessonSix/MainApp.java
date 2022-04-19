package LessonSix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{4, 3, 54, 2, 4, 43, 3, 3, 5, 2};
        System.out.println(Arrays.toString(cutNumbersAfterFourInArr(arr)));

        Integer[] arr2 = new Integer[]{1,1,1,4,1};
        System.out.println(checkArrayForExactNumbers(arr2));
    }

    public static Integer[] cutNumbersAfterFourInArr(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        if (arrayList.contains(4)) {
            Integer targetPoint = arrayList.lastIndexOf(4);
            if (targetPoint.equals(arrayList.indexOf(arrayList.get(arrayList.size() - 1)))) {
                return new Integer[0];
            } else {
                List<Integer> result = arrayList.subList(targetPoint + 1, arrayList.size());
                return result.toArray(new Integer[0]);
            }
        } else {
            throw new RuntimeException();
        }
    }


    public static boolean checkArrayForExactNumbers(Integer[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        Integer numberOfFours = Collections.frequency(arrayList, 4);
        Integer numberOfOnes = Collections.frequency(arrayList, 1);
        if (arrayList.contains(4) && arrayList.contains(1) && arrayList.size() == (numberOfFours + numberOfOnes)) {
            return true;
        } else {
            return false;
        }

    }
}
