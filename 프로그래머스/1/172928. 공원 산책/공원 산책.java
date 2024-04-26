class Solution {
    // N, S, E, W
    public static int[][] way = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int n = park.length;
        int m = park[0].length();
        int r = routes.length;
        
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            int w = 0;
            int d = routes[i].charAt(2)-'0';
            switch (routes[i].charAt(0)) {
                case 'N': w = 0;
                    break;
                case 'S': w = 1;
                    break;
                case 'E': w = 2;
                    break;
                case 'W': w = 3;
                    break;
            }
            
            int x = answer[0];
            int y = answer[1];
            int j = 0;
            for (j = 0; j < d; j++) {
                int nx = x + way[w][0];
                int ny = y + way[w][1];
                
                if (nx<0 || nx>=n || ny<0 || ny>=m || map[nx][ny]=='X') {
                    break;
                }
                x = nx; y = ny;
                //System.out.println(x+" "+y+" "+d);
            }
            
            //System.out.println(j);
            // 중간에 방해물을 안만나거나, 경계를 넘지 않은 경우
            if (j == d) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        
        return answer;
    }
}