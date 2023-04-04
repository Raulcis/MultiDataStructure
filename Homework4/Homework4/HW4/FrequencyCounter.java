// FrequencyCounter.java: Reads in a command-line integer and sequence of words
// from standard input and prints out all the words (whose length exceeds the
// threshold) that occur most frequently to standard output. It also prints out
// the number of words whose length exceeds the threshold and the number of
// distinct such words.

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]); // key-length cutoff
        ST<String, Integer> st = new ST<>();
        int HighNum = 1;
        int wordCount = 0;
        int uniqueWord = 0;
        StringBuilder max = new StringBuilder();

        while (!StdIn.isEmpty()) { // Build symbol table and count frequencies.
            String word = StdIn.readString();
            wordCount++;
            if (word.length() < minlen) continue; // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else {
                st.put(word, st.get(word) + 1);
                max.append(word);
                max.append(" ");
                uniqueWord++;
            }
        }

        // Find a key with the highest frequency count. to be or not to be that is the question
        for (String word : st.keys()) {

            if (HighNum < st.get(word)) {
                HighNum = st.get(word);
            }
        }

        StdOut.print(max);
        StdOut.println(HighNum);

        StdOut.println("Distinct = " + (wordCount - uniqueWord));
        StdOut.println("Words = " + wordCount);
    }
}
