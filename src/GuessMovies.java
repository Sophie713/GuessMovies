import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class GuessMovies {

    public static void main(String [] args) throws Exception {
        int amountOfLines = 0;
        File file = new File("src/movies.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        //count amount of lines to make the array only as big as needed
        while (reader.readLine() !=null){
            amountOfLines++;
        }

        String [] moviesList = new String[amountOfLines];
        char[] movieChars;

        int i = 0;
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine())!=null) {
                //write down the name
                moviesList[i] = line;
                //increment i
                i++;
        }

        //choose a random movie
        int randomMovie = (int) ((Math.random() * amountOfLines)+1);
           String finalMovie = (moviesList[randomMovie]);
            //fill movieChars with the letters

        movieChars = finalMovie.toCharArray();
        //get number of letters of a chosen movie
        int numberOfLetters = movieChars.length;
        //write the number of letters
        System.out.println(numberOfLetters);
        //write _  for each letter
        char [] secretWord = new char[numberOfLetters];
        for (int ch = 0; ch < numberOfLetters; ch++){
            secretWord[ch] = '_';
        }
        //print out the secret word
        System.out.println(Arrays.toString(secretWord));
        int remainingLetters = numberOfLetters;
        while (remainingLetters >= 0) {
            //tell the user to guess
            System.out.println("Guess a letter");
            //read the input
            Scanner scannerS = new Scanner(System.in);
            String input = scannerS.next().toString().toLowerCase();
            //make it a char if ti isn't
            char guess = input.charAt(0);
            //limit the number of guesses
            //check the title for the input

            for (int s = 0; s < numberOfLetters; s++) {
                if (guess == movieChars[s]) {
                    //replace _  with the char in a correct position
                    secretWord[s] = guess;
                    remainingLetters--;
                }
            }
            System.out.println(Arrays.toString(secretWord));
        }

            System.out.println("Thats right! It is " + finalMovie + ".");
        }
        }




