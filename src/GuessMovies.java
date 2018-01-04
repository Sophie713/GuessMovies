import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class GuessMovies {

    public static void main(String [] args) throws Exception {
        String [] moviesList = new String[1000];
        int moviesNumber = 0;
        char[] movieChars;


        File file = new File("src/movies.txt");
        Scanner scanner = new Scanner(file);
            int i = -1;
            while (scanner.hasNextLine()) {

                //scan next line
                String line = scanner.nextLine();
                //count movies
                moviesNumber += line.split("\n").length;
                //write down the name
                moviesList[i+1] = line;
                //increment i
                i++;

        }
        //choose a random movie
        int randomMovie = (int) ((Math.random() * moviesNumber)+1);
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




