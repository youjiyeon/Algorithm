import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        System.out.println(isRight());
    }

    public static int isRight(){
        //char[] stack = new char[str.length()];
        //int size = 0;
        int result = 0;
        int temp = 1;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            switch(str.charAt(i)) {
                case '(':
                    stack.push(str.charAt(i));
                    temp*=2;
                    break;
                case '[':
                    stack.push(str.charAt(i));
                    temp*=3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '('){
                        return 0;
                    }

                    else if (str.charAt(i-1) == '('){
                        result+=temp;
                    }
                    temp/=2;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '['){
                        return 0;
                    }

                    else if (str.charAt(i-1) == '[') {
                        result += temp;
                    }
                    temp/=3;
                    stack.pop();
                    break;
            }
        }

        if (stack.isEmpty()){
            return result;
        }
        return 0;
    }
}