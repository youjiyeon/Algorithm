import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class PGM_개인정보_수집_유효시간_Solution {
    
    public LocalDate date;
    public String[][] input;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        date = LocalDate.parse(today, formatter);
        
        input = new String[terms.length][2];
        for(int i = 0; i < terms.length; i++)
        {
            input[i] = terms[i].split(" ");
        }
        
        LocalDate[] startDays = new LocalDate[privacies.length];
        String[] type = new String[privacies.length];
        String[][] splits = new String[privacies.length][2];
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++)
        {
            splits[i] = privacies[i].split(" ");
            startDays[i] = LocalDate.parse(splits[i][0], formatter);
            type[i] = splits[i][1];
            
            if(!(checkVaild(startDays[i], type[i])))
            {
                arr.add(i+1);
            }
        }
        
        return arr.stream().mapToInt(integer -> integer).toArray();
    }
    
    public boolean checkVaild(LocalDate day, String type){
        
        int month = 0;
        for(int i=0; i<input.length;i++)
        {
            if(input[i][0].equals(type))
            {
                month = Integer.parseInt(input[i][1]);
            }
        }
        Period p = Period.between(day, date);
        int diff = p.getYears()*12 + p.getMonths();
        if(diff>=month)
        {
            return false;
        }
        
        return true;
    }
}