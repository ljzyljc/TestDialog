package com.jackie.testdialog.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2021/1/11
 */
class ProxyTest {

//    public static void main(String[] args) {
//        //创建中介类实例
//        ProxyTest inter = new ProxyTest(new Vendor());
//        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//
//        //获取代理类实例sell
//        Sell sell = (Sell)(Proxy.newProxyInstance(Sell.class.getClassLoader(), new Class[] {Sell.class}, inter));
//
//        //通过代理类对象调用代理类方法，实际上会转到invoke方法调用
//        sell.sell();
//        sell.ad();
//    }

    class LogHandler implements InvocationHandler {
        Object target;  // 被代理的对象，实际的方法执行者

        public LogHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            before();
            Object result = method.invoke(target, args);  // 调用 target 的 method 方法
            after();
            return result;  // 返回方法的执行结果
        }

        // 调用invoke方法之前执行
        private void before() {
            System.out.println(String.format("log start time [%s] ", new Date()));
        }

        // 调用invoke方法之后执行
        private void after() {
            System.out.println(String.format("log end time [%s] ", new Date()));
        }
    }


    static class Vendor implements Sell {
        public void sell() {
            System.out.println("In sell method");
        }

        public void ad() {
            System.out.println("ad method");
        }
    }

    interface Sell {
        void sell();

        void ad();
    }

    class DynamicProxy implements InvocationHandler {
        //obj为委托类对象;
        private Object obj;

        public DynamicProxy(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            Object result = method.invoke(obj, args);
            System.out.println("after");
            return result;
        }
    }
/*
     class UserDao {
        public void select() {
            System.out.println("UserDao 查询 selectById");
        }
        public void update() {
            System.out.println("UserDao 更新 update");
        }
    }



    public class LogInterceptor implements MethodInterceptor {
        *//**
     * @param object 表示要进行增强的对象
     * @param method 表示拦截的方法
     * @param objects 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return 执行结果
     * @throws Throwable
     *//*
        @Override
        public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            before();
            Object result = methodProxy.invokeSuper(object, objects);   // 注意这里是调用 invokeSuper 而不是 invoke，否则死循环，methodProxy.invokesuper执行的是原始类的方法，method.invoke执行的是子类的方法
            after();
            return result;
        }
        private void before() {
            System.out.println(String.format("log start time [%s] ", new Date()));
        }
        private void after() {
            System.out.println(String.format("log end time [%s] ", new Date()));
        }
    }*/

    public class TestClass {

//        public static void main(String[] args) {
//
//            // 1. 动态代理，如果要是实现InvocationHandler接口，然后有具体的实现内容，
//            //    那就调用动态代理类直接调用方法
//            // 2. 如果类似下面的用匿名内部类的实现方式，我们可以在匿名内部类中，根据方法名称，
//            //    然后，在api.test这样调用方法的时候，我们在invoke里面可以拿到方法名做个判断，
//            //    然后invoke方法方法具体的对象 Student student = api.test(); api对象就类似一个壳
//            ApiService2 api = (ApiService2) Proxy.newProxyInstance(ApiService2.class.getClassLoader(), new Class<?>[]{ApiService2.class}
//                    , new InvocationHandler() {
//                        @Override
//                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
////                        //Object impl = new ApiServie2Impl(); //目标接口的实现类
////                        Object result = method.invoke(this,args);
//                            System.out.println(method.getName());
//                            if (method.getName().equals("test")){
//                                return new Student(30);
//                            }
//                            if (method.getName().equals("testA")){
//                                return new Student(20);
//                            }
//
//                            return null;
//                        }
//                    });
//            Student student = api.test();
//            System.out.println(student.age);
//
//            System.out.println("===================");
//
//            Student student1 = api.testA();
//            System.out.println(student1.age);
//
////      输出内容
////        test
////        30
////        ===================
////        testA
////        20
//
//        }
//    }


}





