package recursion;

public class RecursionMethods {

    // n!
    // 5! = 5 * 4 * 3 * 2 * 1
    public static long factorial(int n){
        if(n < 0){
            return -1;
        }
        if(n == 0){
            return 1;
        }
        long product = 1; // So it can hold a biggger number
        for(int i = 1; i <= n; i++){
            product *= i;
        }
        return product;

    }
    // public static void foo() { this will cause a stack overflow error
    //     System.out.println("foo!");
    //     foo();
    // }

    public static long fact(int n){
        if(n == 0 || n == 1){
            return 1;
        } else{
            return n * fact(n-1);
        }

    } 
    public static int length(String s){
        if(s.equals("")) {
            return 0;
        } else {
            return 1 + length(s.substring(1));
        }
    } /* "food"
    f
    o
    o
    d
     */
    public static void printChars(String s){
        if(s.equals("")){
            System.out.println(" ");
        } else {
            System.out.println(s.charAt(0));
            printChars(s.substring(1));
        }

    }
    public static int summation(int n){
        if(n <= 0){
            return 0;
        } else {
            return n + summation(n -1);
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(factorial(1));
        System.out.println(fact(2));
        System.out.println(length("Hello"));
        printChars("null");
        System.out.println(summation(5));
    }
}
