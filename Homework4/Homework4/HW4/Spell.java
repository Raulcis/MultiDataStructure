// Spell.java: Takes a command-line argument specifying the name of the file
// containing common misspellings (a line-oriented file with each
// comma-separated line containing a misspelled word and the correct spelling),
// then reads text from standard input and prints out the misspelled words in
// the text along with the line numbers where they occurred and their correct
// spellings.

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Spell {
    public static void main(String[] args) throws IOException {

        ArrayST<String, String> st = new ArrayST<>();
        int count = 0;
        String filename = "data/";
        filename = filename + args[0];
        FileReader file = new FileReader(filename);
        BufferedReader buff = new BufferedReader(file);
        boolean eof = false;

        while (!eof) //does this while its not the end of file
        {
            String line = buff.readLine();

            if (line == null)
                eof = true; // if the line is null then its the end of the file

            if (line != null) {
                String[] arrOfStr = line.split(",");
                st.put(arrOfStr[0], arrOfStr[1]);
            }
        }

        filename = "data/";
        filename = filename + args[1];
        file = new FileReader(filename);
        buff = new BufferedReader(file);
        eof = false;
        while (!eof) //does this while its not the end of file
        {
            String line = buff.readLine();

            if (line == null)
                eof = true; // if the line is null then its the end of the file

            if (line != null) {
                String[] book = line.split(" ");
                String check;
                count++;
                for (int i = 0; i < book.length; i++) {
                    if (st.contains(book[i])) {
                        StdOut.print(book[i] + ":" + count + " " + "->" + " ");
                        check = book[i];
                        for (String word : st.keys()) {
                            if (check.equals(word)) {
                                StdOut.println(st.get(word));
                            }

                        }
                    }
                }

            }

        }
    }


}
