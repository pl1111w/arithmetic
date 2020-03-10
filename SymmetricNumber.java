import java.util.Scanner;

/**
 * 输出某个数字的最近对称数 ：例如 1001 101都是对称数
 **/
public class SymmetricNumber {

    public static void main(String[] args) {
        System.out.println("请输入要判断的数字");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int result = highAnaLowSwap(number);
        boolean isEqual = isEqual(result, number);
        while (!isEqual){
            boolean flag = true;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if (flag) {
                    number = number + i;
                    result = highAnaLowSwap(number);
                    isEqual = isEqual(result, number);
                    if(isEqual){
                        break;
                    }
                    flag = false;
                } else {
                    number = number - i;
                    result = highAnaLowSwap(number);
                    isEqual = isEqual(result, number);
                    if(isEqual){
                        break;
                    }
                    flag = true;
                }
            }
        }
    }

    private static boolean isEqual(int result, int number) {
        if (result == number) {
            System.out.println(number);
            return true;
        } else {
           return false;
        }
    }

    private static int highAnaLowSwap(int number) {

        int temp = number;
        int swap = 0;
        while (temp > 0) {
            swap = swap * 10 + temp % 10;
            temp = temp / 10;
        }
        return swap;
    }


}
