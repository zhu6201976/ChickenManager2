package com.example.javatest;

import java.util.Arrays;

/**
 * ChickenManager:小鸡管理类
 * Created by My on 2018/1/15.
 */

public class ChickenManager {
    private Chicken[] chickens;
    private int count = 0;//实际保存的元素个数

    public ChickenManager(int size) {
        // 对象数组长度外部决定，默认长度3
        if (size > 0) {
            chickens = new Chicken[size];
        } else {
            chickens = new Chicken[3];
        }
    }

    public Chicken[] getChickens() {
        return chickens;
    }

    // 数组动态扩充容量
    public void add(Chicken c) {
        if (count < chickens.length) {
            chickens[count] = c;
        } else {
            int newLen = chickens.length * 3 / 2 + 1;
            chickens = Arrays.copyOf(chickens, newLen);
            chickens[count] = c;
        }
        count++;
    }

    // 两种实现方式，这种也很好理解
    public void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (chickens[i].getId() == id) {
                for (int j = i; j < count - 1; j++) {
                    chickens[j] = chickens[j + 1];
                }
                count--;
                break;
            }
        }
    }

    public void update(Chicken c) {
        Chicken chicken = this.find(c.getId());
        if (chicken != null) {
            // 这里必须重新赋值，数组内该引用和chicken指向相同，chicken为新创建
            chicken.setName(c.getName());
            chicken.setAge(c.getAge());
        }

    }

    public Chicken find(int id) {
        for (int i = 0; i < count; i++) {
            if (id == chickens[i].getId()) {
                return chickens[i];
            }
        }
        return null;
    }

    public void findAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(chickens[i]);
        }
    }
}
