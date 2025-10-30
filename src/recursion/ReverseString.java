package recursion;

public class ReverseString {
    public static void main(String[] args) {
         String name = "Nanobot";

         reverseString(name, name.length()-1);

         reverser(name, name.length() - 1, "");
    }

    public static void reverseString(String str, int index){
        if(index == 0){
            System.out.println(str.charAt(0));
            return;
        }

        System.out.print(str.charAt(index));
        reverseString(str, index - 1);
    }

    public static void reverser(String str, int index, String reversed){
        if(index == 0){
            reversed += str.charAt(0);
            System.out.println(reversed);
            return;
        }
        reversed += str.charAt(index);
        reverser(str, index - 1, reversed);
    }
}
