import java.lang.reflect.InvocationTargetException;

/*
 * 反射：把Java类中的各种结构（方法、属性、构造器、类名）映射成一个个Java对象
 * 1、获得Class对象
 * 2、动态创建对象
 * @project_name    hello-world
 * @author          zhishangli
 * @time            14:54 2019-01-28
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Test test1 = new Test();

        Class testClass1 = test1.getClass();
        Class testClass2 = Test.class;
        Class testClass3 = Class.forName("Test");

        Test test2 = (Test) testClass1.getConstructor().newInstance();
    }
}
class Test {
    public Test(){};
}
