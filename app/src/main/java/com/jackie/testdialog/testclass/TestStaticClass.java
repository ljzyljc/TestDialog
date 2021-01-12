package com.jackie.testdialog.testclass;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/22
 */
public class TestStaticClass {

    int age;
    private void setAge(){
    }

    private void setName(){

    }
    private void callInnerMethod(){
        //外部类访问内部类非静态的东西需要创建内部类对象，所以非静态内部类一定要实例化才能访问
        InnerClass innerClass = new InnerClass();
        innerClass.test();
        innerClass.testTwo();
    }
    class InnerClass{

        //static String country;  //非静态内部类不能有静态的东西
        String name;
        public void test(){
            //内部类可以直接访问外部类的方法
            setAge();
            setName();
        }

        private void testTwo(){

        }
    }
}
