package ua.kiev.prog;

import java.io.File;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        Class<?> cls = container.getClass();

        try {

            if (cls.isAnnotationPresent(SaveTo.class)) {
                System.out.println("Annotated with @SaveTo class: " + cls.getName());
            }

            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    SaveTo saveTo = cls.getAnnotation(SaveTo.class);
                    method.invoke(container, saveTo.path());

                    //if (File(saveTo.path()) = null)
                    File file = new File(saveTo.path());
                    System.out.println("File to write data: " + file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
