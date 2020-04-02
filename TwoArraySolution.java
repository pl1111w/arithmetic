public class TwoArraySolution {
/**在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数**/

/**思路：左下右上取值判断**/
    public static void main(String[] args) {
        int array[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int target = 80;
        System.out.println(Find(target, array));
    }

    public static boolean Find(int target, int[][] array) {

        int rows = array.length;
        if (rows == 0) {
            return false;
        }
        int cols = array[0].length;
        if (cols == 0) {
            return false;
        }
        int col = array[0].length - 1;
        int temp = 0;
        while (temp < rows && col>=0) {
            if (target > array[temp][col]) {
                temp++;
            }
            else if(target<array[temp][col]){
                col--;
            }
            else if(target==array[temp][col]){
                return true;
            }
        }
         return false;
    }

}
