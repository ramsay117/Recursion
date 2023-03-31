import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetKpc {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    String[] chars = { ".,", "abc", "def", "ghi", "jkl", "mon", "pqrs", "tu", "vwx", "yz" };
    ArrayList<String> res = getKPC(str, chars);
    for (int i = 0; i < res.size(); i++) {
      System.out.print(res.get(i) + " ");
    }
  }

  public static ArrayList<String> getKPC(String str, String[] chars) {
    if (str.length() == 0)
      return new ArrayList<String>(Arrays.asList(""));
    ArrayList<String> al = new ArrayList<String>();
    ArrayList<String> recans = getKPC(str.substring(1), chars);
    String a = chars[str.charAt(0) - '0'];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < recans.size(); j++) {
        al.add(a.charAt(i) + recans.get(j));
      }
    }
    return al;
  }
}
