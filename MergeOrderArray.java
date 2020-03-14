import java.util.Arrays;

/**
 * 将两个有序数组合并
 **/

public class MergeOrderArray {

    public static void main(String[] args) {
        int arrayOne[] = {1, 2, 5, 6};
        int arrayTwo[] = {10, 9, 8, 7, 4, 3};
        int resultLength = arrayOne.length + arrayTwo.length;
        int arrayResult[] = new int[resultLength];

        mergeMethod(arrayOne, arrayTwo, arrayResult, resultLength);
        System.out.println(Arrays.toString(arrayResult));
    }

    private static void mergeMethod(int[] arrayOne, int[] arrayTwo, int[] arrayResult, int resultLength) {
        int arrayOneIndex = 0;
        int arrayTwoIndex = arrayTwo.length - 1;

        for (int i = 0; i < resultLength; i++) {

            //判断两个数组都有值则进行比较
            if (arrayTwoIndex >= 0 && arrayOneIndex < arrayOne.length) {
                if (arrayOne[arrayOneIndex] <= arrayTwo[arrayTwoIndex]) {
                    arrayResult[i] = arrayOne[arrayOneIndex];
                    arrayOneIndex++;
                } else if (arrayOne[arrayOneIndex] >= arrayTwo[arrayTwoIndex]) {
                    arrayResult[i] = arrayTwo[arrayTwoIndex];
                    arrayTwoIndex--;
                }
            }
            //否则直接放在新数组里
            else{
                if(arrayTwoIndex >= 0){
                    arrayResult[i] = arrayTwo[arrayTwoIndex];
                    arrayTwoIndex--;
                }
                else{
                    arrayResult[i] = arrayOne[arrayOneIndex];
                    arrayOneIndex++;
                }
            }


        }

    }

}
