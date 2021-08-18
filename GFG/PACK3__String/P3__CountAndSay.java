package PACK3__String;

public class P3__CountAndSay {


    public static void main(String[] args) {
        
        System.out.println(countAndSay(111221));
    }


    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
          int count = 1;
          char num = result.charAt(0);
          StringBuilder temp = new StringBuilder();
          for (int j = 1, l = result.length(); j < l; j++) {
            if (result.charAt(j) == num) {
              count++;
            } else {
              temp = temp.append(String.valueOf(count)).append(String.valueOf(num));
              num = result.charAt(j);
              count = 1;
            }
          }
          temp = temp.append(String.valueOf(count)).append(String.valueOf(num));
          result = temp.toString();
        }
        return result;
      }

}
