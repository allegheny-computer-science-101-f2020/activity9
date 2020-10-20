package activitynine;

import java.util.Random;

/** Class implementing three algorithms for analysis.
* @author Janyl Jumadinova
*/
public class AlgorithmAnalysis {

  /** Use repeated concatenation to compose a String with "repeats" copies of a
  *  specified "character". */
  public static String repeat1(char character, int repeats) {
    String answer = "";
    for (int j = 0; j < repeats; j++) {
      answer += character;
    }
    return answer;
  }

  /** Use repeated concatenation to compose a String with "repeats" copies of a
  *  specified "character". */
  public static String repeat2(char character, int repeats) {
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

    int[] numbers1 = new int[10000];
    int[] numbers2 = new int[10000];
    int[] numbers3 = new int[10000];
    Random rand = new Random();

    for (int count = 0; count < 10000; count++) {
      numbers1[count] = rand.nextInt(1000);
      numbers2[count] = rand.nextInt(1000);
      numbers3[count] = rand.nextInt(1000);
    }

    System.out.println("Starting repeat1 ...");

    /* Testing repeat1 */

    long startTime = System.currentTimeMillis();

    //System.out.println(AlgorithmAnalysis.repeat1('a', 10));
    AlgorithmAnalysis.repeat1('a', 1000);

    long endTime = System.currentTimeMillis();
    System.out.println("Finished repeat1.");

    long elapsed = endTime - startTime;
    System.out.println("Running time repeat1: " + elapsed);

    /* Testing repeat2 */
    System.out.println("Starting repeat2 ...");
    startTime = System.currentTimeMillis();
    AlgorithmAnalysis.repeat2('a', 1000);
    endTime = System.currentTimeMillis();
    System.out.println("Finished repeat2.");
    elapsed = endTime - startTime;
    System.out.println("Running time repeat2: " + elapsed);

    /* Testing disjoint1 */
    System.out.println("Starting disjoint1 ...");
    startTime = System.currentTimeMillis();
    AlgorithmAnalysis.disjoint1(numbers1, numbers2, numbers3);
    endTime = System.currentTimeMillis();
    System.out.println("Finished disjoint1.");
    elapsed = endTime - startTime;
    System.out.println("Running time disjoint1: " + elapsed);

    /* Testing disjoint2 */
    System.out.println("Starting disjoint2 ...");
    startTime = System.currentTimeMillis();
    AlgorithmAnalysis.disjoint2(numbers1, numbers2, numbers3);
    endTime = System.currentTimeMillis();
    System.out.println("Finished disjoint2.");
    elapsed = endTime - startTime;
    System.out.println("Running time disjoint2: " + elapsed);
  }
}
