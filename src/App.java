import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        ArrayList<String> al = gss(str);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

    public static ArrayList<String> gss(String str) {
        if (str.length() == 0)
            return new ArrayList<String>(Arrays.asList("")); // 0 length == 1 substring, ""
        ArrayList<String> al = new ArrayList<String>();
        ArrayList<String> recans = gss(str.substring(1));
        for (int i = 0; i < recans.size(); i++) {
            String ss = recans.get(i);
            al.add(str.charAt(0) + ss);
            al.add("-" + ss);
        }
        return al;
    }
}
