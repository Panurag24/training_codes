package test;

public class OutputSubClass extends OutputSuperClass {
    public OutputSubClass() {
        System.out.println("Sub 1");
    }

    public OutputSubClass(int x) {
        System.out.println("Sub 2");
    }

    public OutputSubClass(int x, int y) {
        System.out.println("Sub 3");
    }

    public static void main(String[] args) {
        new OutputSubClass(1);
    }

}
