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
        graph.dijestra(6);
        graph.showDijestra();

    }
}

class Graph {
    private char[] vertex;//顶点数组
    private int[][] martix;//邻接矩阵
    private VisitedVertax vv;

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

    /**
     * @param index 出发顶点的下标
     */
    public void dijestra(int index) {
        vv = new VisitedVertax(vertex.length, index);
        update(index);//更新index下标周围距离以及前驱节点
        for (int j = 1; j < vertex.length; j++) {
            index = vv.updateArr();//选择新的顶点；
            update(index);
        }
    }

    /**
     * @param index
     */
    public void update(int index) {
        int len = 0;
        for (int i = 0; i < martix[index].length; i++) {
            //vv.getDis(index):出发顶点到index顶点的距离
            //vv.getDis(index)：顶点index到顶点i的距离
            len = vv.getDis(index) + martix[index][i];
            if (!vv.in(i) && len < vv.getDis(i)) {
                vv.updatePre(i, index);
                vv.updateDis(i, len);
            }
        }
    }

    public void showDijestra() {
        vv.show();
    }
}

class VisitedVertax {
    /**
     * 表示各个顶点是否访问过，1：访问过；0：未访问，动态变化的；
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
        this.already_arr[index] = 1;//设置出发顶点已经访问
    }


    /**
     * @param index:顶点下标
     * @return是否访问过：访问过：true;没有访问：false
     */
    public boolean in(int index) {
        return already_arr[index] == 1;
    }

    /**
     * 更新出发点到下标为index顶点的距离
     *
     * @param index 下标
     * @param len   距离
     */
    public void updateDis(int index, int len) {
        dis[index] = len;
    }

    /**
     * 更新前驱节点为pre的顶点为index顶点
     *
     * @param pre
     * @param index
     */
    public void updatePre(int pre, int index) {
        pre_visited[pre] = index;
    }

    /**
     * 出发顶点到index顶点的距离
     *
     * @param index 顶点
     * @return 距离
     */
    public int getDis(int index) {
        return dis[index];
    }

    /**
     * 下一个未访问的节点更新为已经访问并返回下标
     *
     * @return
     */
    public int updateArr() {
        int min = 100, index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && min > dis[i]) {
                min = dis[i];//找到距离最近的
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }
    //显示最后的结果
    //即将三个数组的情况输出
    public void show() {

        System.out.println("==========================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 100) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();

    }
}
