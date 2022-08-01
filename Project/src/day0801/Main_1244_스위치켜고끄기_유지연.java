package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기_유지연 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        // 1. 스위치 개수와 스위치읽기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sNum = Integer.parseInt(br.readLine());
        int[] sArr = new int[sNum];
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int s = 0; s<sNum; s++)
            sArr[s] = Integer.parseInt(st.nextToken());
        
        // 2. 학생 수
        int studentNum = Integer.parseInt(br.readLine());
        int[][] students = new int[studentNum][2];
        
        for(int s = 0; s<studentNum; s++)
        {
            StringTokenizer sts = new StringTokenizer(br.readLine());
            students[s][0] = Integer.parseInt(sts.nextToken()); // 남여
            students[s][1] = Integer.parseInt(sts.nextToken()); // 가지고 있는 수
        }
        // 3. 남여 구분해서 스위치on,off
        // 1이면(남) 수의 배수 스위치 change
        // 2이면(여) 해당 수 좌우 대칭인 경우의 스위치 change -> 반복문 추가
        for(int s = 0; s<studentNum; s++)
        {
            //남학생이면
            if(students[s][0] == 1)
            {
                for(int i = 0; i<sNum; i++)
                {
                    //스위치 on, off
                    if((i+1)%students[s][1] == 0)
                        sArr[i] = Math.abs(sArr[i]-1);
                        
                }
                    
            }
            
            
            // 여학생이면
            if(students[s][0] == 2)
            {
                sArr[students[s][1]-1] = Math.abs(sArr[students[s][1]-1]-1);
                int i = 1;
                // 좌우대칭 확인
                while(true)
                {
                    int left = (students[s][1]-1)-i;
                    int right = (students[s][1]-1)+i;
                    
                    // 경계 체크
                    if(left<sNum && left>=0 && right<sNum && right>=0)
                    {
                        if(sArr[left] == sArr[right])
                        {
                            sArr[left] = Math.abs(sArr[left]-1);
                            sArr[right] = Math.abs(sArr[right]-1);
                        }
                        else
                            break;
                    }
                    else
                        break;
                    i++;
                }
                
            }

        }
        
        // 스위치 배열 출력
        for(int i=0; i<sNum; i++)
        {
            System.out.printf("%d ",sArr[i]);
            
            if((i+1)%20 == 0)
                System.out.println();
        }
            

    }

}