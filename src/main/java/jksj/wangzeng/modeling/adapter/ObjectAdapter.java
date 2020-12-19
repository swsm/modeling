package jksj.wangzeng.modeling.adapter;

/**
 * @author swsm
 * @date 2020/12/19
 */
public class ObjectAdapter {

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

    class Adaptor implements ITarget {

        private Adaptee adaptee;

        public Adaptor(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void f1() {
            adaptee.fa();
        }

        @Override
        public void f2() {
            adaptee.fb();
        }
        
        @Override
        public void f3() {
            adaptee.f3();
        }
    }
    
}
