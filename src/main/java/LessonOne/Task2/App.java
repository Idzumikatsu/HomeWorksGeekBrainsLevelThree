package LessonOne.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

        static class ArrToList<T> {
            T[] arr;

            public ArrToList(T...arr) {
                this.arr = arr;
            }

            public ArrayList<T> convert(T[] arr){
                ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
                return list;
            }
        }

    public static void main(String[] args) {
        ArrToList<Integer> intArr = new ArrToList<>(4,5,6,8,9,87);
        List<Integer> list = intArr.convert(intArr.arr);
        System.out.println(list);

        ArrToList<String> strArr = new ArrToList<>("qwe", "asd", "zxc", "qweerer");
        List<String> list1 = strArr.convert(strArr.arr);
        System.out.println(list1);

        list.add(21);
        list1.add("erew");

        System.out.println();
        System.out.println(list);
        System.out.println(list1);

    }
}
