import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MazePaths {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    ArrayList<String> paths = mp(0, 0, n - 1, m - 1);
    for (String path : paths) {
      System.out.print(path + " ");
    }
  }

  // sr - source row
  // sc - source column
  // dr - destination row
  // dc - destination column
  static ArrayList<String> mp(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      return new ArrayList<String>(Arrays.asList(""));
    }
    if (sr > dr || sc > dc) {
      return new ArrayList<String>();
    }
    ArrayList<String> al = new ArrayList<String>();
    ArrayList<String> hPaths = mp(sr, sc + 1, dr, dc);
    for (String path : hPaths) {
      al.add("h" + path);
    }
    ArrayList<String> vPaths = mp(sr + 1, sc, dr, dc);
    for (String path : vPaths) {
      al.add("v" + path);
    }
    return al;
  }
}
