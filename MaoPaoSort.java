import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 相邻位置两两比较，大的数沉下去小的数浮上来
 **/
public class MaoPaoSort {

    public static void main(String[] args) {
        int array[] = {8, 6, 9, 1, 4, 10, 7, 5, 3, 2};
        beginMaoPao(array);
        System.out.println(Arrays.toString(array));
    }

    private static void beginMaoPao(int[] array) {
        for (int j =0;j<array.length;j++) {
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }


    }

}
