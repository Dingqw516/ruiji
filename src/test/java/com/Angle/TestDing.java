package com.Angle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author: 启文
 * @date: 2023年09月04日 9:57
 */
public class TestDing {

    @Test
    public void  list(){
        user user1 = new user("11",11);
        user user2 = new user("22",22);
        user user3 = new user("33", 33);
        List<user> list=new ArrayList<>() ;
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.stream().map((item)->{
            item.setAge(23);
            return item;
        }).collect(Collectors.toList());

        System.out.println(list);
    }
}
