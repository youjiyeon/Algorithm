class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int n = skill.length();
        int t = skill_trees.length;
        boolean[] check = new boolean[1000];
        //System.out.println(n+" "+t);
        
        for (int i = 0; i < n; i++) {
            check[skill.charAt(i)-'A'] = true;
            //System.out.println(skill.charAt(i)-'A');
        }        
        
        for (int i = 0; i < t; i++) {
            int idx = 0;
            int m = skill_trees[i].length();
            int j = 0;
            //System.out.println(i);
            T: for (j = 0; j < m; j++) {
                
                
                if (idx>=n) break T;
                //System.out.println(skill.charAt(idx)+" "+skill_trees[i].charAt(j));
                if (skill.charAt(idx) != skill_trees[i].charAt(j)) {
                    if (check[skill_trees[i].charAt(j)-'A'])
                        break T;
                }
                else idx++;
            }
            if (j==m || idx==n) {
                //System.out.println(i);
                answer++;
            }
        }
        
        return answer;
    }
}