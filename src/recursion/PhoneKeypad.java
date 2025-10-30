package recursion;

public class PhoneKeypad {
    public static String[] keyPad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void findCompinations(String str, int index, String combinations){
        if(index == str.length()){
            System.out.println(combinations);
            return;
        }
        char c = str.charAt(index);
        String mapping = keyPad[c - '0'];
        for(int i = 0; i < mapping.length(); i++){
            findCompinations(str, index + 1, combinations + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "23";
        findCompinations(str, 0, "");
    }
}
