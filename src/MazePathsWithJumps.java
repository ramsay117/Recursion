import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MazePathsWithJumps {
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    ArrayList<String> paths = mpwj(0, 0, n - 1, m - 1);
    for (String path : paths) {
      System.out.print(path + " ");
    }
  }

  static ArrayList<String> mpwj(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc)
      return new ArrayList<String>(Arrays.asList(""));
    ArrayList<String> paths = new ArrayList<String>();
    for (int i = sc + 1; i <= dc; i++) {
      ArrayList<String> hPaths = mpwj(sr, i, dr, dc);
      for (String path : hPaths) {
        paths.add("h" + i + path);
      }
    }
    for (int i = sr + 1; i <= dr; i++) {
      ArrayList<String> vPaths = mpwj(i, sc, dr, dc);
      for (String path : vPaths) {
        paths.add("v" + i + path);
      }
    }
    for (int i = sr + 1, j = sc + 1; i <= dr && j <= dc; i++, j++) {
      ArrayList<String> dPaths = mpwj(i, j, dr, dc);
      for (String path : dPaths) {
        paths.add("d" + i + path);
      }
    }
    return paths;
  }
}
