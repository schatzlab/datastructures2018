public class CompareSuffixes {

  // Compare 2 suffixes of text starting at s1 and s2
  // Return -1 if s1 is smaller, +1 if s2 is smaller, 0 for the same
  public static int cmpSuffixes(String text, int s1, int s2) {
    int d = 0;

    if (s1 == s2) { return 0; }

    while ((s1 + d < text.length()) && (s2 + d < text.length())) {
      char c1 = text.charAt(s1+d);
      char c2 = text.charAt(s2+d);

      if      (c1 < c2) { return -1; }
      else if (c2 < c1) { return +1; }

      // else they are the same, keep going
      d++;
    }

    // no differences through end of string
    // return shorter one meaning having a bigger offset
    if (s1 < s2) { return +1; }
    return -1;
  }

  public static void main(String [] args) {
    if (args.length < 3) {
      System.err.println("usage: CompareSuffixes text s1 s2\n");
      return;
    }

    String text = args[0];
    int s1 = Integer.parseInt(args[1]);
    int s2 = Integer.parseInt(args[2]);

    System.out.format("Comparing the suffixes of \"%s\"\n", text);
    System.out.format("s1 [%d]: \"%s\"\n", s1, text.substring(s1));
    System.out.format("s2 [%d]: \"%s\"\n", s2, text.substring(s2));

    int cmp = cmpSuffixes(text, s1, s2);

    System.out.println("Returned: " + cmp);
    if (cmp < 0) { 
      System.out.format("s1 \"%s\" < s2 \"%s\"\n", 
                        text.substring(s1), 
                        text.substring(s2)); 
    } else if (cmp > 0) { 
      System.out.format("s2 \"%s\" < s1 \"%s\"\n", 
                        text.substring(s2), 
                        text.substring(s1)); 
    }
    else {
      System.out.format("s1 \"%s\" == s2 \"%s\"\n", 
                        text.substring(s1), 
                        text.substring(s2)); 
    }
  }
}
