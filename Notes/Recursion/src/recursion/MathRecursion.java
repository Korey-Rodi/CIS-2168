package recursion;

public class MathRecursion {

    public static double pow(double base, int exp) {
        if (exp == 0){
            return 1;
        } else if (exp < 0){
            return 1.0 / pow(base, exp * -1);
        }
        else {
            return base * pow(base,exp-1);
        }

    }
    public static int gcd(int bigger, int smaller){
        if (bigger < smaller){
            return gcd(smaller,bigger);
        }
        else if (bigger % smaller == 0){
            return smaller;
        } else {
            return gcd(smaller,bigger % smaller);
        }
    }
    // non recursive
    public static int linearSearch(int[] array,int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;

    }
    // private static int linearSearch(int [] array, int target, int index){
    //     if (index >= array.length){
    //         return -1;
    //     }
    //     if(array[index] == target){
    //         return index;
    //     }
    //     return linearSearch(array, target, index + 1);
    // }
    public static int search(int [] array , int target){
        return search(array, target, 0, array.length);
    }

    private static int search(int [] array, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int middle = (start + end) / 2;
        if(array[middle]== target){
            return middle;
        } else if(target < array[middle]){
            return search(array,target,start, middle - 1);
        } else {
            return search(array, target, middle + 1, end);

        }
    }


    public static void main(String[] args) {
        System.out.println(pow(2,-2));
        System.out.println(gcd(144,12));
        int [] array = {1,2,3,4,5,6,7};
        int [] array2 = new int[100000];
        for(int i = 0; i < array2.length; i++){
            array2[i] = i;
        }
        System.out.println(linearSearch(array, 5));
        System.out.println(search(array2, 23456));
        
    }
    
}
