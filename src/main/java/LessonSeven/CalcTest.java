package LessonSeven;

public class CalcTest {


    @BeforeSuit
    public static void starterMeth(){
        System.out.println("Testing suit started");
    }

//    @BeforeSuit
//    public static void starterMeth1(){
//        System.out.println("Testing suit started");
//    }

    @AfterSuit
    public static void endingMeth(){
        System.out.println("Testing suit complete");
    }

    @TestAnnotation(value = 2)
     public static void test1(){
        System.out.println("Test 1 passed (low priority)");
    }

    @TestAnnotation(value = 4)
    public static void test2(){
        System.out.println("Test 2 passed (mid priority)");
    }

    @TestAnnotation
    public static void test3(){
        System.out.println("Test 3 passed def priority");
    }

    @TestAnnotation(value = 8)
    public static void test4(){
        System.out.println("Test 4 passed (high priority))");
    }

}
