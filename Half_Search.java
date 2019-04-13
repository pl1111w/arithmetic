import java.util.Scanner;

public class Half_Search {
    public  static  void  main(String arg[]){
        int [] math ={1,3,4,6,7,9,11};
        System.out.println("输入查找的数字");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int index = -1;
        int begin = 0;
        int end = math.length-1;/*易出错点*/
        int middle = end/2;
        while(begin<=end){

            if(number>math[middle]){
                begin=middle+1;
                middle= (begin+end)/2;
            }
            if(number<math[middle]){
                end=middle-1;
                middle=end/2;
            }
            if(number==math[middle]){
                index=middle;
                System.out.println("下标为:"+middle);
                break;
            }
        }
        if(index==-1){
            System.out.println("没找到");
        }
    }

}
