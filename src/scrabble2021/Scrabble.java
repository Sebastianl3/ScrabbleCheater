package scrabble2021;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;


public class Scrabble {

    static void  acceptanceWordFinder(String[] wordsArray, String[] permArray) {
        if (permArray[0].length() <= 1) {
            return;
        } else {
            ArrayList<String> arrayList1 = new ArrayList<>();
            for (int i = 0; i < permArray.length; i++) {
                BinarySearch BS = new BinarySearch();
                int index = BS.binarySearch(wordsArray, permArray[i]);

                if (index >= 0) {
                    arrayList1.add(wordsArray[index]);
                    wordsArray[index] = wordsArray[index].concat("&");
                }
            }
            String[] acceptedWords = arrayList1.toArray(new String[arrayList1.size()]);

            for (int j = 0; j < acceptedWords.length; j++) {
                System.out.print(acceptedWords[j] + "   ");
            }
            System.out.println();
            for (int k = 0; k < permArray.length; k++) {
                permArray[k] = permArray[k].substring(0, permArray[k].length() - 1);
            }
            acceptanceWordFinder(wordsArray,permArray);

        }
    }

        public static void main (String args[])throws FileNotFoundException {
            System.out.println("Welcome to Scrabble Cheater, all you have to do is enter your letters, and I will show all the words you can play!");

            System.out.println("What are the letters?");
            Scanner scan = new Scanner(System.in);
            String stringOfLetters = scan.nextLine(); // Reads in the user's input as a string
            char[] Letters = stringOfLetters.toCharArray(); // Turns string into char array
            insertionSort Sort = new insertionSort();
            Sort.sort(Letters); // Sorts the array to set up for permutation algorithm

            Lexico Lex = new Lexico();
            String[] permutationArray = Lex.permutations(Letters); // generates the permuatations
            File file1 = new File("Data/Words.txt");
            Scanner scanFile = new Scanner(file1);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList1 = new ArrayList<>();
            while (scanFile.hasNextLine()) {  // Read from text file
                arrayList.add(scanFile.nextLine());
            }
            String[] ScrabbleWords = arrayList.toArray(new String[arrayList.size()]);

            for (int i = 0; i < permutationArray.length; i++) {
                BinarySearch BS = new BinarySearch();
                int index = BS.binarySearch(ScrabbleWords, permutationArray[i]);

                if (index >= 0) {
                    arrayList1.add(ScrabbleWords[index]);
                }
            }
            String[] acceptedWords = arrayList1.toArray(new String[arrayList1.size()]);
            for (int i = 0; i < acceptedWords.length; i++) {
                System.out.println(acceptedWords[i]);
            }
            acceptanceWordFinder(ScrabbleWords, permutationArray);
        }
    }

