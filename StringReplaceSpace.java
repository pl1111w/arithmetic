public class StringReplaceSpace {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("W Are Happy.");
        String result = replaceSpace(str);
        System.out.println(result);
    }

    private static String replaceSpace(StringBuffer str) {
        //法一
//        String result = str.toString().replaceAll(" ","20%");
//        System.out.println(result);
        //法二
          StringBuffer stringBuffer = new StringBuffer();
          for(int i=0;i<str.toString().length();i++){
              char b=str.charAt(i);
              if(String.valueOf(b).equals(" ")){
                  stringBuffer.append("20%");
              }
              else {
                  stringBuffer.append(b);
              }
          }
        return  stringBuffer.toString();

    }

}
