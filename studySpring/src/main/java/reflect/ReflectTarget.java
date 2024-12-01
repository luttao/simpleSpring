package reflect;

public class ReflectTarget extends ReflectTargetOrign{
    //---------构造函数-----------
    //(默认的带参数构造函数)
    ReflectTarget(String str) {
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造函数
    public ReflectTarget() {
        System.out.println("调用了公有的无参构造方法 。。。");
    }

    //有一个参数的构造函数
    public ReflectTarget(char name) {
        System.out.println("调用了带有一个参数的构造方法，参数值为 " + name);
    }

    //有多个参数的构造函数
    public ReflectTarget(String name, int index) {
        System.out.println("调用了带有多个参数的构造方法，参数值为【目标名】： " + name + " 【序号】" + index);
    }
    //受保护的构造函数
    protected ReflectTarget(boolean n){
        System.out.println("受保护的构造方法 n :" + n);
    }
    //私有的构造函数
    private ReflectTarget(int index){
        System.out.println("私有的构造方法 序号：" + index);
    }

    //**************字段*******************//
    public String name;
    protected int index;
    char type;
    private String targetInfo;
    @Override
    public String toString(){
        return "ReflectTarget [name=" + name + ", index=" + index + ", type=" + type
                + ", targetInfo=" + targetInfo + "]";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方式获取类对象(class)
        ReflectTarget target = new ReflectTarget();
        Class reflectTargetClass1 = target.getClass();
        System.out.println(reflectTargetClass1.getName());
        //第二种方式获取类对象
        Class reflectTargetClass2 = ReflectTarget.class;
        System.out.println(reflectTargetClass2.getName());
        //第三种方式获取类对象
        Class reflectTargetClass3 = Class.forName("reflect.ReflectTarget");
        System.out.println(reflectTargetClass3.getName());
    }
}
