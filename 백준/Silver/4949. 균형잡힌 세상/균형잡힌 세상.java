import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!((str = br.readLine()).equals("."))){
            if (isRight(str)){
                sb.append("yes\n");
            }
            else sb.append("no\n");
        }
        System.out.println(sb);
    }

    public static boolean isRight(String str){
        char[] stack = new char[str.length()];
        int size = 0;

        for (int i = 0; i < str.length(); i++) {
            switch(str.charAt(i)) {
                case '(':
                    stack[size] = '(';
                    size++;
                    break;
                case '[':
                    stack[size] = '[';
                    size++;
                    break;
                case ')':
                    if (size==0 || stack[size-1] != '('){
                        return false;
                    }
                    size--;
                    break;
                case ']':
                    if (size==0 || stack[size-1] != '['){
                        return false;
                    }
                    size--;
                    break;
            }
        }

        if (size!=0){
            return false;
        }
        return true;
    }
}