package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by xyd on 16/7/4.
 */
public class ReflactTest {
    public static Car initByDefaultConstruct() throws Throwable{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("test.Car");

        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car)cons.newInstance();

        Method setName = clazz.getMethod("setName",String.class);
        setName.invoke(car,"benz");
        Method setId = clazz.getMethod("setId",String.class);
        setId.invoke(car,"1");

        return car;
    }
}
