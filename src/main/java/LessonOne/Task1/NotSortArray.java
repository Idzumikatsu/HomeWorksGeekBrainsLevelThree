package LessonOne.Task1;

import java.util.Arrays;

public class NotSortArray<T> {
    T[] arr;

    public NotSortArray(T...arr) {
        this.arr = arr;
    }

    public <T> T[] swapElements(int src, int dest, T[] arr) {
        T element = arr[src];
        arr[src] = arr[dest];
        arr[dest] = element;
        return arr;
    }

    public static void main(String[] args) {
        NotSortArray<Integer> integerNotSortArray = new NotSortArray<>(4,5,6,4,8,7,89,9);
        System.out.println(Arrays.toString(integerNotSortArray.swapElements(1, 5, integerNotSortArray.arr)));
        NotSortArray<String> stringNotSortArray = new NotSortArray<>("qwe","asd", "zxc");
        System.out.println(Arrays.toString(stringNotSortArray.swapElements(0, 2, stringNotSortArray.arr)));
    }
}
