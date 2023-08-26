package com.Angle;

import lombok.Data;

/**
 * 功能描述
 *
 * @author: 启文
 * @date: 2023年09月04日 10:05
 */
@Data
public class user{
    String name;
    int age;

    public user(String name, int age) {
        this.name = name;
        this.age = age;
    }

}