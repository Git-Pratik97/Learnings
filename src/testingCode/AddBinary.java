package testingCode;

public class AddBinary {
    public static void main(String[] args) {
        String a = "11", b = "1";
        String binarySum = addBinary(a, b);

        System.out.println("Binary Sum - " + binarySum);
    }

    public static synchronized void addBinary_sync(){
        System.out.println("Using Synchronized in static method...");
    }

    public static String addBinary(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || remainder == 1){
            if(i >= 0){
                remainder += num1.charAt(i--) - '0';
            }
            if(j >= 0){
                remainder += num2.charAt(j--) - '0';
            }

            sb.append(remainder % 2);
            remainder /= 2;
        }

        return sb.reverse().toString();
    }
}
