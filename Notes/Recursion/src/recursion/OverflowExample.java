package recursion;

public class OverflowExample {
    public static void fib() {
        fib();
    }
    public static void main(String[] args) {
        fib();
        
    }
}
