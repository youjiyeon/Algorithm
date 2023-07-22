import java.util.*;
class Solution {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        
        // 소문자 치환
        str = str.toLowerCase();
        // 문자 제거
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i)>='a' && str.charAt(i)<='z')
                || (str.charAt(i)>='0' && str.charAt(i)<='9')
                || str.charAt(i)=='-' || str.charAt(i) =='_'
                || str.charAt(i)=='.'){
                sb.append(str.charAt(i));
            }
        }
        str = String.valueOf(sb);
        System.out.println("1 "+str);


        // 연속 . 제거
        sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str.charAt(i)=='.') {
                for (int j = i+1; j < str.length(); j++) {
                    if (str.charAt(j)=='.'){
                        i++;
                    }
                    else break;
                }
            }
        }
        str = String.valueOf(sb);
        System.out.println("2 "+str);

        // 앞뒤 . 제거
        sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((i==0 || i==str.length()-1) && str.charAt(i)=='.') {
                continue;
            }
            sb.append(str.charAt(i));
        }
        str = String.valueOf(sb);
        System.out.println("3 "+str);

        // a 대입
        if (str.length()==0){
            str = "a";
        }
        System.out.println("4 "+str);

        // 15글자
        if (str.length()>=16) {
            sb = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                if (i == 14 && str.charAt(i) == '.') {
                    continue;
                }
                sb.append(str.charAt(i));
            }
            str = String.valueOf(sb);
            System.out.println("5 "+str);
        }

        // 2글자 이하
        if (str.length()<=2){
            sb = new StringBuilder();
            sb.append(str);
            for (int i = str.length(); i < 3; i++) {
                sb.append(str.charAt(str.length()-1));
            }
            str = String.valueOf(sb);
            System.out.println("6 "+str);
        }


        return str;
    }
}