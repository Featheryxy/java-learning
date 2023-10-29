package com.feather.generate;

import com.feather.oop.polymorphism.People;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Milo
 * @date 2023/10/27 19:56
 */
public class GenericDemo<T> {
        private T data;

        public GenericDemo(T data) {
            this.data = data;
        }

        // 泛型方法，可以独立引入类型参数
        public <U> void processData(U value) {
            // 在这里，U 是方法级别的类型参数，不同于类级别的类型参数 T
            System.out.println("Data: " + data);
            System.out.println("Value: " + value);
            System.out.println(value.getClass() == Integer.class); // 实例的类 是否相等
            System.out.println(value instanceof Number); // value对象是否是Integer类的实例或其子类的实列
            System.out.println(value instanceof Object); // value对象是否是Integer类的实例或其子类的实列
        }

        // 泛型方法，可以独立引入类型参数
        public <U> void processData(Collection<U> values) {
            if (values.getClass() == ArrayList.class) {
                ArrayList<People> values1 = (ArrayList) values;
                System.out.println(values);
//                System.out.println(values instanceof Number); // value对象是否是Integer类的实例或其子类的实列
            }
        }
        // 带有泛型的普通方法，依赖于类级别的类型参数 T
        public T getData() {
            // 在这里，只能使用类级别的类型参数 T
            return this.data;
        }

    public static void main(String[] args) {
        GenericDemo<String> demo = new GenericDemo<>("hello");
        demo.processData(123);
        System.out.println(demo.getData());
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        demo.processData(objects);
    }
}
