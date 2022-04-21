package LessonSeven;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class StartCalcTest {

    public static void main(String[] args) {
        try {
            start(CalcTest.class);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class testClass) throws ReflectiveOperationException {

        Map<Integer, Method> map = new TreeMap<>();
        Method[] methods = testClass.getDeclaredMethods();

        int count = 0;
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuit.class) || m.isAnnotationPresent(AfterSuit.class)) {
                count++;
                if (count > 2) {
                    throw new RuntimeException("More than one method with annotation @BeforeSuit or @AfterSuit");
                }
            }
        }

        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuit.class) != null) {
                BeforeSuit beforeSuit = m.getAnnotation(BeforeSuit.class);
                map.put(beforeSuit.value(), m);
            }
            if (m.getAnnotation(AfterSuit.class) != null) {
                AfterSuit afterSuit = m.getAnnotation(AfterSuit.class);
                map.put(afterSuit.value(), m);
            }
            if (m.getAnnotation(TestAnnotation.class) != null){
                TestAnnotation testAnnotation = m.getAnnotation(TestAnnotation.class);
                map.put(testAnnotation.value(), m);
            }
        }

        for (Integer key: map.keySet()) {
            map.get(key).invoke(testClass);
        }

    }
}
