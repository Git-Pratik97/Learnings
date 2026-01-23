package StringTest;

public class MinimumInteger {
    public static String minimumNumber(String num){
        if(num == null || num.length() < 2){
            return num;
        }

        int[] freq = new int[10];

        for(int i = 0; i < num.length(); i++){
            int s = num.charAt(i) - '0';
            freq[s]++;
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < freq.length; i++){
            while(freq[i] > 0){
                ans.append((char) (i + '0'));
                freq[i]--;
            }
        }

        return ans.toString();

    }

    public static void main(String[] args) {
        String num = "324";

        String ans = minimumNumber(num);

        System.out.println(ans);
    }
}
