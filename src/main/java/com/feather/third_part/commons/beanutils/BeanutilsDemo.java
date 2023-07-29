package com.feather.third_part.commons.beanutils;

import com.feather.domain.People;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Milo
 * @date 2023/7/29 19:59
 */
public class BeanutilsDemo {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        People tom = new People();
        tom.setName("Tom");
        tom.setAge(13);
        tom.setMale(true);
        tom.setHobby(null);
        System.out.println("tom "+tom);

        People people = new People();
//        BeanUtils.copyProperties(people, tom); // 所有属性拷贝，包括null值
//        System.out.println(people);

        org.springframework.beans.BeanUtils.copyProperties(tom, people);
        System.out.println(people);

//        org.springframework.beans.BeanUtils.copyProperties

    }


}
