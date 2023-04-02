import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StairPaths {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    ArrayList<String> al = sp(n, 0);
    for (String s : al) {
      System.out.print(s + " ");
    }
  }

  static ArrayList<String> sp(int n, int curr) {
    if (curr == n)
      return new ArrayList<String>(Arrays.asList(""));
    if (curr > n)
      return new ArrayList<String>();
    ArrayList<String> al = new ArrayList<String>();
    ArrayList<String> al1 = sp(n, curr + 1);
    ArrayList<String> al2 = sp(n, curr + 2);
    ArrayList<String> al3 = sp(n, curr + 3);
    for (int i = 0; i < al1.size(); i++) {
      al.add("1" + al1.get(i));
    }
    for (int i = 0; i < al2.size(); i++) {
      al.add("2" + al2.get(i));
    }
    for (int i = 0; i < al3.size(); i++) {
      al.add("3" + al3.get(i));
    }
    return al;
  }
}
