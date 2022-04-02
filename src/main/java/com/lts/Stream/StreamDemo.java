package com.lts.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目要求，能用现一行代码完成此题
 * 现有5个用户！筛选：
 * 1、id必须是偶数，
 * 2、年龄必须大于23岁
 * 3、用户名转为大写
 * 4、用户名字母倒着排序
 * 5、只输出一个用户
 */
public class StreamDemo {
    public static void main(String[] args) {
        User user1=new User(1,22,"a");
        User user2=new User(2,23,"b");
        User user3=new User(3,24,"c");
        User user4=new User(4,25,"d");
        User user5=new User(6,26,"e");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);

        list.stream()
                .filter(u->{return u.getId()%2==0;})//返回id为偶数的user
                .filter(u->{return u.getAge()>23;})//返回年龄大于23岁的user
                .map(u->{return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)//只输出一行
                .forEach(System.out::println);//遍历出来
    }
}
