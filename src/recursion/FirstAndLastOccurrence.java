package recursion;

public class FirstAndLastOccurrence {
    public static int first = -1;
    public static int last = -1;

    public static void findFirstAndLast(String str, int index, char ele){

        if(index == str.length()){
            System.out.println("First occurrence at " + first +
                    " and last occurrence at " + last);
            return;
        }

        char current = str.charAt(index);
        if(current == ele){
            if(first == -1){
                first = index;
            }
            else{
                last = index;
            }
        }

        findFirstAndLast(str, index+1, ele);
    }

    public static void main(String[] args) {
        String str = "asdadsdasdsddfgeasdasdadsdsdaaa";

        findFirstAndLast(str, 0, 'a');
    }
}
