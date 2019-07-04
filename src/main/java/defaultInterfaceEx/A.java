package defaultInterfaceEx;

interface A {
    default void doSth() {
        System.out.println("inside A");
    }
}

interface B {
    default void doSth() {
        System.out.println("inside B");
    }
}

interface C extends A {
    default void doSth() {
        System.out.println("inside C");
    }
}

class App implements B, A {

    @Override
    public void doSth() {
        A.super.doSth();
    }

    public static void main(String[] args) {
        new App().doSth();
    }
}