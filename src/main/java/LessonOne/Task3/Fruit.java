package LessonOne.Task3;

public class Fruit {
    private Float weight;

    public Float getItemWeight() {
        return weight;
    }

    public Fruit() {
    }

}

class Apple extends Fruit {

    private Float weight;

    @Override
    public Float getItemWeight() {
        return weight = 1.0f;
    }

    public Apple() {
    }
}

class Orange extends Fruit {

    private Float weight;

    @Override
    public Float getItemWeight() {
        return weight = 1.5f;
    }

    public Orange() {
    }

}