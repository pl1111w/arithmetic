import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 每次遍历找到最小的那个与其交换位置
 **/
public class ChoiceSort {

    public static void main(String[] args) {
        int array[] = {8, 6, 9, 1, 4, 10, 7, 5, 3, 2};
        choiceSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void choiceSort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[j] > array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    System.out.println(Arrays.toString(array));
                }
            }
        }


    }

}
