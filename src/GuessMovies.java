import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class GuessMovies {

    public static void main(String [] args) throws Exception {
        int amountOfLines = 0; // variable for amount of lines in file
        File file = new File("src/movies.txt"); // file with movie names
        BufferedReader reader = new BufferedReader(new FileReader(file));   // reader for counting the lines in file
        BufferedReader br = new BufferedReader(new FileReader(file));   // reader for storing the line in array
        String line = "";   // variable for storing the current line in while loop
        int i = 0;  // variable for while loop
        char[] movieChars; //array for chosen movie
        Scanner scannerS = new Scanner(System.in);  // scanner for reading the user letter guess
        int guesses = 10;   // number of guesses

        //count amount of lines to make the array only as big as needed
        while (reader.readLine() !=null){
            amountOfLines++;
        }
        String [] moviesList = new String[amountOfLines];   //array for storing the movie names

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
        //write the number of letters
        System.out.println(movieChars.length);
        //write _  for each letter
        char [] secretWord = new char[movieChars.length];
        for (int ch = 0; ch < movieChars.length; ch++){
            secretWord[ch] = '_';
        }
        //print out the secret word
        System.out.println(Arrays.toString(secretWord));
        int remainingLetters = movieChars.length;
        while (remainingLetters  > 0 && guesses > 0 ) {
            //tell the user to guess
            System.out.println("Guess a letter");
            //read the input
            String input = scannerS.next().toString().toLowerCase();
            //make it a char if ti isn't
            char guess = input.charAt(0);
            //limit the number of guesses
            guesses--;
            if(guesses>1){
                System.out.println( guesses+ " guesses remaining. ");
            }else
                System.out.println( guesses+ " guess remaining. ");

            //check the title for the input
            for (int s = 0; s < movieChars.length; s++) {
                if (guess == movieChars[s]) {
                    //replace _  with the char in a correct position
                    secretWord[s] = guess;
                    remainingLetters--;
                }

            }
            System.out.println(Arrays.toString(secretWord));
        }
        if(remainingLetters==0){
            System.out.println("Thats right! It is " + finalMovie + ".");
        }else
            System.out.println("You lost! The movie name is " + finalMovie + ".");

        }
        }