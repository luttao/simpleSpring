package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class reflectTargetClass = Class.forName("reflect.ReflectTarget");
        //1.获取所有的公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructorCollector =  reflectTargetClass.getConstructors();
        for(Constructor c:constructorCollector){
            System.out.println(c);
        }
        //2.获取所有构造方法
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor[] constructorCollector1 =  reflectTargetClass.getDeclaredConstructors();
        for(Constructor c:constructorCollector){
            System.out.println(c);
        }
        //3.获取单个带参数的公有方法
        System.out.println("*****************获取公有、有两个参数的构造方法*******************************");
        Constructor constructorCollector2=reflectTargetClass.getConstructor(char.class);
        System.out.println(constructorCollector2);
        //4.获取单个私有的构造方法
        System.out.println("******************获取私有构造方法*******************************");
        constructorCollector2 = reflectTargetClass.getDeclaredConstructor(int.class);
        System.out.println("private con = " + constructorCollector2);
        System.out.println("******************调用私有构造方法创建实例*******************************");
        //暴力访问（忽略掉访问修饰符）
        constructorCollector2.setAccessible(true);
        ReflectTarget reflectTarget = (ReflectTarget) constructorCollector2.newInstance(1);

    }



}
