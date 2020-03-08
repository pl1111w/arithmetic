import java.util.Scanner;
/***
 *
 * 斐波那契数列
 *
 * */
public class fibonacci {
    public static void main(String[] args) {
        System.out.println("输入查找斐波那契数列第几个项");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if(number==1){
            System.out.println("第"+number+"项的值为："+(number-1));
        }
        else if(number==2){
            System.out.println("第"+number+"项的值为："+(number-1));
        }
        else{
            int result = fib(number)+fib(number-1);
            System.out.println("第"+number+"项的值为："+result);
        }
    }

    private static int fib(int number) {
        if(number<=3){
            return 1;
        }
        else{
            return fib(number-1)+fib(number-2);
        }
    }

}
