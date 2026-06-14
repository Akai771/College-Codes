// Write a Java Program to demonstrate a Generic Class.

package Practicals.Practical1;

class test<T> {
    T obj;
    test(T obj) {
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
}

public class GenericClassDemo {
    public static void main(String[] args) {
        test<Integer> iObj = new test<>(15);
        System.out.println("Integer Value: " + iObj.getObj());

        test<String> sObj = new test<>("Hello World");
        System.out.println("String Value: " + sObj.getObj());
    }
}
