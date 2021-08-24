package scrabble2021;
import java.util.ArrayList;

public class Lexico {

        private static void swap(char[] chars, int i, int j) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
        }

        private static void reverse(char[] chars, int start) {
            for (int i = start, j = chars.length - 1; i < j; i++, j--) {
                swap(chars, i, j);
            }
        }

        // Function to find lexicographically next permutations of a string.
        // It returns true if the string could be rearranged as a lexicographically
        // greater permutation; otherwise, it returns false.
        public static boolean next_permutation(char[] chars)
        {
            // find the largest index `i` such that `chars[i-1]` is less than `chars[i]`
            int i = chars.length - 1;
            while (chars[i - 1] >= chars[i])
            {
                // if `i` is the first index of the string, that means we are already
                // at the highest possible permutation, i.e., the string is sorted in
                // descending order
                if (--i == 0) {
                    return false;
                }
            }

        /*
            if we reach here, the substring `chars[i…n)` is sorted in descending order
            i.e., chars[i-1] < chars[i] >= chars[i+1] >= chars[i+2] >= … >= chars[n-1]
        */

            // find the highest index `j` to the right of index `i` such that
            // chars[j] > chars[i-1]
            int j = chars.length - 1;
            while (j > i && chars[j] <= chars[i - 1]) {
                j--;
            }

            // swap character at index `i-1` with index `j`
            swap(chars, i - 1, j);

            // reverse substring `chars[i…n)` and return true
            reverse(chars, i);

            return true;
        }

        // Function to find all lexicographically next permutations of a
        // string sorted in ascending order
    public static String[] permutations(char[] str)
        {
            // convert the string to a char array and sort it in ascending order
            //char[] chars = str.toCharArray();
            //Arrays.sort(chars)
            ArrayList<String> arrayList = new ArrayList<>();
            boolean A = true;
            while (A)
            {
                // print the current permutation
                //System.out.print(new String(str) + " ");
                arrayList.add(new String(str));
                // find the next lexicographically ordered permutation
                if (!next_permutation(str)) {
                    A = false;
                }
            }
            Object[] scrabbleWords = arrayList.toArray(); // file read into array list
            String String_Array[]=new String[scrabbleWords.length];
            for (int i=0; i<String_Array.length; i++) {
                String_Array[i] = scrabbleWords[i].toString();
            }

            return String_Array;
        }

        public static int Factorial(int number){
        int fact = 1;
            for(int i=1; i <= number; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
