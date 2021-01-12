package com.jackie.testdialog.generic;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/12/19
 */
class TestGenericOne {





}

//泛型类的两种实现方式
interface Generic1<T>{

}

class Generics2<T> implements Generic1<T>{
    public static void main(String[] args) {
        Generics2<Integer> generics2 = new Generics2<>();
    }
}

class Generics3 implements Generic1<String>{
    public static void main(String[] args) {
        Generics3 generics3 = new Generics3();
    }
}

class TestGenerics {

    //泛型方法，只有有定义了<T>才是
    public <T> void test(T t){

    }

    //只是方法里面的参数类型使用到了泛型，不是泛型方法，普通方法
    public void test2(List<String> list){

    }

    //普通方法
    public void test3(List<?> list){

    }

}


class Genericity<T> {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        Genericity<Integer> integerGenericity = new Genericity<>();
//
//        integerGenericity.show("Demo", 2333, 23.22);
//
//        Genericity.show(new Long(20));

        Genericity.sumOfList(new ArrayList<Integer>());

        //        List<Object> list2 = new ArrayList<>();
//        List<String> list1 = (List<String>)(List) list2;

//        List<String> list2 = new ArrayList<>();
//        list2.add("jackie");
//        List list1 = (List) list2;
//
//        List<String> collection = new ArrayList<String>();
//
//
////        List<Object> list1 = list2.stream().map(String::new).collect(Collectors.toList());
//        System.out.println(list1.get(0).toString());
        int res = foo();
        System.out.println(res);
    }

    public static int func() {
        try {
            System.exit(1);
            return 0;
        } catch (Exception e){
            return 1;
        } finally {
            return 2;
        }
    }

    public static int foo() {
        int x = 0;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    //静态泛型方法
    public static <T> void show(T t) {
        System.out.println(t);

    }
//    //以下方法编译器报错：
//    public static void show(T t) {
//
//    }

    public <T> void show(T... ts) {
        for (T t : ts) {
            System.out.println(t.toString());
        }
    }

    //上限通配符  只能读  <? extends Number>
    //更灵活 PE List Producter生产者，可以从它里面拿数据，但是你没办法往里面添加数据
    public static double sumOfList(List<? extends Number> list){
        //副作用
        //list.add(1) //上限 in 只读，但这个不是严格限制
        // 反射调用最新的不能调用
        // Cause by: java.lang.UnsupportedOperationExcepion

        Class<?> clazz = list.getClass();

        try {
            Method method = clazz.getMethod("add",java.lang.Object.class);
            method.setAccessible(true);
            method.invoke(list,100);
            System.out.println(list.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
        return 0d;

    }

    /**
     * 1.如果你正在编写一个可以使用Object类中提供的功能实现的方法。
     * 2.当代码使用通用类中不依赖与类型参数的方法时，例如list.size或list.clear
     * 事实上，Class<?>之所以这么经常使用，是因为Class<T>中的大部分方法都不依赖与T
     *
     * @param list
     */

//不受限
// ? 退化了，不能使用List中任何依赖类型参数[T]的方法
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void productList(List<?> list){
        //也有副作用
        //list.add("sss"); //不能使用该方法

        list.size();
        list.add(null);
        list.get(0);
        list.contains(12);


        Set<Integer> set = new HashSet<>();

        Set<?> set1 = set;

//        Set<?> set2 = new HashSet<>();
//        Set<Integer> set3 = set2; //编译器报错



        try{

        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}

class Pair<T> {
    public Pair(T first,T second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() { return first; }
    public T getSecond() { return second; }
    public void setFirst(T first) { this.first = first; }
    public void setSecond(T second) { this.second = second; }
    private T first;
    private T second;
}
//The generic class Box<T> may not subclass java.lang.Throwable
//class Box<T> extends Exception {}

//The generic class Box<T> may not subclass java.lang.Throwable
//class Box1<T> extends Throwable {}



class ExceptionTest2 {
    int age;
    public static void main(String[] args) {
        System.out.println(test().age);
        //throw new OutOfMemoryError();
    }
    public static ExceptionTest2 test() {
        ExceptionTest2 test = new ExceptionTest2();
        try {
            test.age = 10;
            return test;
        }catch (Exception e) {
            test.age = 20;
            return test;
        }finally {
            test = new ExceptionTest2();
            test.age = 30;
            return test;
        }
    }
}

abstract class  MyException extends Exception{
    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}

