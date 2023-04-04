// AvgGPA.java: Reads from standard input a list of letter grades and computes
// and prints the average GPA (the average of the numbers corresponding to
// the grades).


import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class AvgGPA {
    public static void main(String[] args) {

        ST<String, Double> st = new ST<>();
        st.put("A+", 4.33);
        st.put("A", 4.00);
        st.put("A-", 3.67);
        st.put("B+", 3.33);
        st.put("B", 3.00);
        st.put("B-", 2.67);
        st.put("C+", 2.33);
        st.put("C", 2.0);
        st.put("C-", 1.67);
        st.put("D", 1.00);
        st.put("F", 0.00);

        int numberOfGrades = 0;
        double totalScore = 0;
        double GpaAverage;

        while (!StdIn.isEmpty()) { // Build symbol table
            String word = StdIn.readString();
            numberOfGrades++;
            totalScore = totalScore + st.get(word);

        }
        GpaAverage = totalScore / numberOfGrades;
        StdOut.println(GpaAverage);

    }
}
