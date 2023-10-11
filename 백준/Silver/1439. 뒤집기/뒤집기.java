import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int i = 0;
        int len = str.length();
        int oneCnt = 0;
        int zeroCnt = 0;
        if (str.charAt(0)=='1'){
            oneCnt++;
        }
        else zeroCnt++;

        while (i<len){
            if (i+1<len) {
                char l = str.charAt(i);
                char r = str.charAt(i+1);
                if (r != l){
                    if (r=='1'){
                        oneCnt++;
                    }
                    else zeroCnt++;
                }
            }
            i++;
        }
        System.out.println(Math.min(oneCnt, zeroCnt));
    }
}