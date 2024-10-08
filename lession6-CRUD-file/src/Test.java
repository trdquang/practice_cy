import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) {
        String str = "1         , Beef Wellington          , Beef, Puff Pastry, Mushrooms                 , Main Course              , 30 ";
        String[]res = new String[5];
        StringTokenizer token = new StringTokenizer(str, ";");
        int cnt = 0;
        while (token.hasMoreElements() && cnt < 5){
            String x = token.nextToken().trim();
            res[cnt++] = x;
            System.out.println(cnt + ", " + x);
        }
    }
}
