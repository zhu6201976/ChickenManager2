package com.example.javatest;

/**
 * 对象数组就是数组里的每个元素都是类的对象，赋值时先定义对象，然后将对象直接赋给数组。
 * 示例：
 * Chicken[] cs= new Chicken[10];
 * 使用对象数组实现多个Chicken的管理。
 */
public class Test {

    public static void main(String[] args) {

        ChickenManager cm = new ChickenManager(3);
        cm.add(new Chicken(1, "c1", 1));
        cm.add(new Chicken(2, "c2", 2));
        cm.add(new Chicken(3, "c3", 3));
        cm.add(new Chicken(4, "c4", 4));

        System.out.println("-----findAll------");
        Chicken[] chickens = cm.getChickens();
        System.out.println("数组长度：" + chickens.length);
        cm.findAll();

        System.out.println("-----find------");
        Chicken chicken = cm.find(4);
        System.out.println(chicken);

        System.out.println("-----update------");
        cm.update(new Chicken(4, "c4", 40));
        cm.findAll();

        System.out.println("-----delete------");
        cm.delete(4);
        cm.findAll();

    }


}
