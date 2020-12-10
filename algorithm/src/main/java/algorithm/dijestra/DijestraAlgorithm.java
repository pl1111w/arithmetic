package algorithm.dijestra;

import java.util.Arrays;

/**
 * @title: pl1111w
 * @description: 迪杰斯特拉算法
 * @author: Kris
 * @date 2020/12/10 20:42
 */
public class DijestraAlgorithm {

    public static void main(String[] args) {

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 100;// 表示不可以连接
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
        //创建 Graph对象
        Graph graph = new Graph(vertex, matrix);
        //测试, 看看图的邻接矩阵是否ok
        graph.showGraph();
        //测试迪杰斯特拉算法
    }
}

class Graph {
    private char[] vertex;//顶点数组
    private int[][] martix;//邻接矩阵

    public Graph(char[] vertex, int[][] martix) {
        this.martix = martix;
        this.vertex = vertex;
    }

    //展示邻接矩阵
    public void showGraph() {
        for (int i = 0; i < vertex.length; i++) {
            System.out.println(Arrays.toString(martix[i]));
        }
    }
}

class VisitedVertax {
    /**
     * 表示各个顶点是否访问过，1：访问过；0：未访问
     **/
    private int[] already_arr;
    /**
     * 每个下标对应的前一个点的下标
     **/
    private int[] pre_visited;
    /**
     * 记录出发点到各个顶点的距离
     **/
    private int[] dis;

    /**
     * @param length:顶点个数
     * @param index：从那个顶点开始出发
     */
    public VisitedVertax(int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis, 100);//初始化dis数组；
        this.dis[index] = 0;
    }

    /**
     * @param index:顶点下标
     * @return是否访问过：访问过：true;没有访问：false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }
}
