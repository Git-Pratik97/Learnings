package recursion;

public class findDuplicatesChars {
    public static boolean[] map = new boolean[26];

    public static void removeDuplicates(String str, int index, String newString){
        if(index == str.length()){
            System.out.println("New String without Duplicates : " + newString);
            return;
        }
        char c = str.charAt(index);
        if(map[c - 'a'] == true){
            removeDuplicates(str, index + 1, newString);
        }
        else{
            newString += c;
            map[c - 'a'] = true;
            removeDuplicates(str, index + 1, newString);
        }
    }

    public static void main(String[] args) {
        String str = "sdasdasasdsdsdfsdfsdfadadsd";
        removeDuplicates(str, 0, "");
    }
}
