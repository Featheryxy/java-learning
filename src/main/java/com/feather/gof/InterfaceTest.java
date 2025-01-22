package com.feather.gof;

import org.junit.Test;

/**
 * @author Milo
 * @date 2025/1/1 22:00
 */
public class InterfaceTest {
    interface IMourceOpen{
        void open();
    }

    class MourceOpen implements IMourceOpen{
        @Override
        public void open() {
            System.out.println("MourceOpen");
        }
    }


    interface IMourceEat extends IMourceOpen{

    }

    class MourceEat extends MourceOpen implements IMourceEat{


    }

    abstract class Mource implements IMourceEat{


    }

    @Test
    public void test(){
        new MourceEat().open();
    }

}
