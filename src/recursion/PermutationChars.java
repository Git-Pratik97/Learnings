package recursion;

public class PermutationChars {

    public static void permutationString(String str, String permut){
        if(str.length() == 0){
            System.out.println(permut);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);

            permutationString(newString, permut + curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        permutationString(str, "");
    }
}
