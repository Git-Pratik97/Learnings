package StackTest;

public class AbsolutePath {
    public static void main(String[] args) {
        String str = "dir/n/tsubdir1/n/t/tfile1.ext/n/t/tsubsubdir1/n/tsubdir2/n/t/tsubsubdir2/n/t/t/tfile.ext";

        for(String s : str.split("/n")){
            System.out.println("Index of /t here for String " + s + " is " + s.lastIndexOf("/t"));
        }
//        int lev = str.lastIndexOf("/t");

//        System.out.println("Last /t present at " + lev);
    }
}
