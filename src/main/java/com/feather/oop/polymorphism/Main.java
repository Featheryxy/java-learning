package com.feather.oop.polymorphism;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Milo
 * @date 2023/6/23 20:54
 */
public class Main {
    @Test
    public void test() {
        // 多态：在继承/实现情况下, 编译类型与运行不一致时 表现为 行为多态， 对象多态
        People p1 = new Teacher();
        System.out.println(p1.name);
        p1.run();

        People p2 = new Student();
        System.out.println(p2.name);
        p2.run();

        // todo 为什么变量的打印都是编译时的，
        /**
         * 父类People的名称
         * 老师可以跑
         * 父类People的名称
         * 学生可以跑
         */
    }

    @Test
    public void advantage() {
        // 优点1， 实现解耦合，右边对象可以随着业务不同随时切换
        People p1 = new Teacher();
        p1.run();

        // 优点2：可以将父类类型的变量作为形式参数， 可以接受一切子类对象
        // 隐藏（封装）细节
        Student student = new Student();
        doing(student);

        Teacher teacher = new Teacher();
        doing(teacher);
    }

    public static void doing(People people) {
        if (people instanceof Teacher) {
            Teacher teacher = (Teacher) people;
            teacher.teach();
        } else if(people instanceof Student){
            Student stu = (Student) people;
            stu.study();
        }
    }

    @Test
    public void disAdvantage() {
        // 缺点，不能调用子类独有的功能
        People p1 = new Student();
        // 无法编译：Cannot resolve method 'study' in 'People'
        // p1.study();

        // 使用强制类型转换解决上述问题,
        Student student = (Student) p1;
        student.study();

        // java.lang.ClassCastException,
        // Teacher teacher = (Teacher) p1;

        // 强转前，建议使用instanceof关键字先判断，再转换
        if (p1 instanceof Teacher) {
            Teacher teacher = (Teacher) p1;
        }
        
    }
}
