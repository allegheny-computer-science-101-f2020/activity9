package activitynine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Class implementing three algorithms for analysis.
* @author Janyl Jumadinova
*/
public class AlgorithmAnalysis {

  /** Use repeated concatenation to compose a String with "repeats" copies of a
  *  specified "character". */
  public String repeat1(char character, int repeats) {
    String answer = "";
    for (int j = 0; j < repeats; j++) {
      answer += character;
    }
    return answer;
  }

  /** Use repeated concatenation to compose a String with "repeats" copies of a
  *  specified "character". */
  public String repeat2(char character, int repeats) {
    java.lang.StringBuilder stringBuilder = new StringBuilder();
    for (int j = 0; j < repeats; j++) {
      stringBuilder.append(character);
    }
    return stringBuilder.toString();
  }

  /** Algorithm for testing three-way disjointness. */
  public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
    for (int aelement : groupA) {
      for (int belement : groupB) {
        for (int celement : groupC) {
          if ((aelement == belement) && (belement == celement)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /** Algorithm for testing three-way disjointness. */
  public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
    for (int aelement : groupA) {
      for (int belement : groupB) {
        if (aelement == belement) {
          for (int celement : groupC) {
            if (aelement == celement) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
  * Demonstrate the use of the algorithms.
  */
  public static void main(String[] args) {

    // declare the starting file and scanner
    File inputFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      inputFile = new File("input/numbers30000.csv");
      scanner = new Scanner(inputFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate the input file");
    }

    int[] numbers = new int[100];
    for (int count = 0; count < numbers.length; count++) {
      numbers[count] = scanner.nextInt();
    }
    System.out.println("Size of the array is: " + numbers.length);

  }
}
