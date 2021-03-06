package LessonFour;

public class ABCApp {

    static final Object mon = new Object();
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while (currentLetter != 'C'){
                            mon.wait();
                        }
                        System.out.print("C");
                        currentLetter = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while (currentLetter != 'A'){
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {
                    synchronized (mon){
                        while (currentLetter != 'B'){
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}
