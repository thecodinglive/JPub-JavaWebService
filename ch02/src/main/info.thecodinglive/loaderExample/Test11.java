package loaderExample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test11 {
    public static void main(String ar[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class myclass = loader.loadClass("loaderExample.JpServlet");
        String invokeParameter = "nick";

        Object loadedInstance = myclass.newInstance();

       Method servletMethod = myclass.getMethod("sayHello",    new Class[] { String.class });

        String result = (String)servletMethod.invoke(loadedInstance,  new Object[] { invokeParameter });

        System.out.println(result);
    }
}
