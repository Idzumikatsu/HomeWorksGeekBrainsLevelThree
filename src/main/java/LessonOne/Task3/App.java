package LessonOne.Task3;

public class App {

    public static void main(String[] args) {

        Box<Apple> appleBox = new Box<>(20);

        appleBox.addOneItem(new Apple());
        appleBox.addFewItems(new Apple(), appleBox, 5);
        System.out.println(appleBox.getValue());
        System.out.println("Вес коробки " + appleBox.getListItem().getClass().getSimpleName() + " составляет : " + appleBox.getWeight(appleBox) + " единиц");
        System.out.println();


        Box<Orange> orangeBox = new Box<>(20);
        orangeBox.addOneItem(new Orange()); // добавление одного фрукта
        orangeBox.addFewItems(new Orange(), orangeBox, 21); // добавление repValue фруктов
        System.out.println(orangeBox.getValue());
        System.out.println("Вес коробки " + orangeBox.getListItem().getClass().getSimpleName() + " составляет : " + orangeBox.getWeight(orangeBox) + " единиц");

        System.out.println(orangeBox.compare(orangeBox, appleBox)); // сравнение

        // пересыпаем фрукты
        System.out.println("Старая : " + orangeBox); //старая коробка
        Box<? extends Fruit> box = orangeBox.transferBoxToBox(orangeBox);
        System.out.println("Новая : " + box.toString()); //новая коробка


    }

}
