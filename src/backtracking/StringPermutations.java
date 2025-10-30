package backtracking;

public class StringPermutations {
    public static void stringArrange(String str, String perm, int idx){
        if(str.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            stringArrange(newString, perm + curr, idx + 1);
        }

    }

    public static void main(String[] args) {
        String str = "ABC";
        stringArrange(str, "", 0);
    }
}
