package LessonOne.Task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private int size;
    private int value = 0;
    private ArrayList<T> list = new ArrayList<>(size);


    public Box(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addOneItem(T fruit) {
        if (getValue() < getSize()) {
            list.add(fruit);
            setValue(getValue() + 1);
        } else {
            System.out.println("Коробка c " + fruit.getClass().getSimpleName() + " уже полная");
        }
    }

    public void addFewItems(T fruit, Box<T> box, int repValue) {
        if (getSize() - getValue() >= repValue) {
            for (int i = 0; i < repValue; i++) {
                box.addOneItem(fruit);
            }
        } else {
            System.out.println("В коробке нет столько места");
        }
    }

    public T getListItem() {
        if (getValue() > 0) {
            return list.get(getValue() - 1);
        }
        return null;
    }

    public Float getWeight(Box<?> box){
        return box.getListItem().getItemWeight() * box.getValue();
    }

    public boolean compare(Box<T> box1, Box<?> box2){
        Float boxOneWeight = box1.getWeight(box1);
        Float boxTwoWeight = box2.getWeight(box2);
        return Math.abs(boxOneWeight - boxTwoWeight) < 0.000000001;
    }

    public Box<T> transferBoxToBox(Box<T> box1){
        Box<T> box2 = new Box<>(box1.size);
        box1.list.addAll(box2.list);
        box1.list.clear();
        box1.setValue(0);
        return box2;
    }

}
