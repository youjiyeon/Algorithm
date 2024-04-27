import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int minX = n;
        int maxX = 0;
        int minY = m;
        int maxY = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wallpaper[i].charAt(j)=='#') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i+1);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
        return new int[] {minX, minY, maxX, maxY};
    }
}