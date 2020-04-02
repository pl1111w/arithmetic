import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 每次遍历找到最小的那个与其交换位置
 **/
public class SelectSort {

    public static void main(String[] args) {
        int array[] = {8, 6, 9, 1, 4, 10, 7, 5, 3, 2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }

    }

}
