package jksj.wangzeng.modeling.adapter;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class ClassAdapter {
    
    private interface ITarget {
        void f1();
        void f2();
        void f3();
    }
    
    class Adaptee {

        public void fa() {
            System.out.println("i am fa");
        }

        public void fb() {
            System.out.println("i am fb");
        }

        public void f3() {
            System.out.println("i am f3");
        }
    }
    
    class Adaptor extends Adaptee implements ITarget {
        
        @Override
        public void f1() {
            super.fa();
        }

        @Override
        public void f2() {
            super.fb();
        }

    }
    
}
