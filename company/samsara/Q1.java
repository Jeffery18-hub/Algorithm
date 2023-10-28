package company.samsara;

public class Q1 {
    public String[] solution(String[] input){
        if(input.length == 1) return null;
        int i = 0, j = 1;
        String[] res = new String[input.length];
        while(i < input.length && j < input.length) {
            char firstChar = input[i].charAt(0);
            char secondChar = input[j].charAt(input[j].length() - 1);
            String newString = new String(new char[]{firstChar, secondChar});
            res[i] = newString;

            if(j == input.length - 1) {
                j = 0;
            }else {
                j++;
            }

            i++;
        }
        
        return res;
    }


    public static void main(String[] args) {
        Q1 q1 = new Q1();
        // Get user input
        String[] input = {"cat", "dog", "ferret", "scorpion"};
       // Call solution method
       String[] output = q1.solution(input);
       // Print output
       for(String s: output) {
        System.out.println(s); 
       }
    }
}
