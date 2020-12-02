package algorithm.dac;

/**
 * @title: pl1111w
 * @description: 分治法-汉诺塔
 * @author: Kris
 * @date 2020/12/2 20:55
 */
public class HanoiTower {

    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    private static void hanoiTower(int number, char a, char b, char c) {

        if (number == 1) {
            System.out.println("第" + number + "个盘从" + a + "->" + c);
            return;
        } else {
            hanoiTower(number - 1, a, c, b);
            System.out.println("第" + number + "个盘从" + a + "->" + c);
            hanoiTower(number - 1, b, a, c);
        }
    }
}
