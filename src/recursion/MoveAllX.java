package recursion;

public class MoveAllX {
    public static void moveAllx(String str, int index, int count, String newString){
        if(index == str.length()-1){
            for(int i = 0; i < count; i++){
                newString += "x";
            }
            System.out.println("New String is : " + newString);
            return;
        }
        char c = str.charAt(index);
        if(c == 'x'){
            count++;
        }
        else{
            newString += c;
        }
        moveAllx(str, index + 1, count, newString);
    }

    public static void main(String[] args) {
        String str = "axxccvxccxxxalksdjaklsdj";
        moveAllx(str, 0, 0, "");
    }
}
