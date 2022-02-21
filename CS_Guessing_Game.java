/*programmer: Charanvir Singh
Class: CS 145
Date 01/10/2022
Assignment Lab 1 Guessing Game
Purpose - this code will generate a number that the user will try to guess
I used do while loop for repetition depending on user choice
I used try catch to catch invalid guess input
*/

import java.util.Scanner;//import for random number generator
import java.util.Random;

public class CS_Guessing_Game//Guessing game
{
    public static void main(String[] args) {
        //define variables
        int game = 0;
        int numTries;
        int totalTries = 0;
        int bestgame = 9999;
        String gameChoice;

        instrutions();

        do {//repeat the games until user says no
            numTries = playGame();
            if (numTries < bestgame){
                bestgame = numTries;//best game calculation
            }
            totalTries += numTries;
            game++;//count total games
            gameChoice = userChoice();
        } while (gameChoice.equalsIgnoreCase("y"));//ignore the case of the user input

        results(game, totalTries, bestgame);
    }//end of the main method

    public static void instrutions() {//instructions begin
        System.out.println("This program allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println("100 and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
    }//end of the instructions

    public static String userChoice(){ //this method will prompt the user if they want to play again
        Scanner input = new Scanner(System.in);
        String gameChoice;
        System.out.println("This was fun! Would you like to give it another go(y for yes, n for no)?");
        gameChoice = input.nextLine();
        return gameChoice;
    }//end of userChoice method


    public static int playGame() {//start of playGame
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //define variables
        int guess = 0;
        String guessCheck;
        int numTries = 0;
        int range = 100;

        int randomNumber = rand.nextInt(range) + 1;//this is the random number
        System.out.print("I am thinking of a number between 1 and "+ range + " \n Your Guess?\n");
        while  (guess != randomNumber){//when the guess is not correct
            guessCheck = input.nextLine();

            try {  //this try catch statement for catch non-int values
                guess = Integer.parseInt(guessCheck);
            }
            catch (Exception e) {
                System.out.println("Please enter a valid interger!"); //this will be printed out for non-int inputs
                continue; // this allows the user to guess again
            }

            if(guess > randomNumber) {
                System.out.println("It\'s lower.\n Try again!");//when the random number is higher than the guess
                numTries++;
            } else {
                System.out.println("It\'s higher.\n Try again!");//when the random number is lower than the guess
                numTries++;
            }
        }
        if (guess == randomNumber) {//when the answer is correct
            System.out.println("Congratulations! You got it in " + numTries +  " tries.");
        }
        return numTries;

    }//end of playGame

    public static void results(int game, int numTries, int bestgame){//this will print the result at the end
        System.out.println("");
        System.out.println("Overall results:");
        System.out.println("	total games = " + game);
        System.out.println("	total guesses = " + numTries);
        System.out.println("	guesses/game  = " + (numTries/game));
        System.out.println("	best game     = " + bestgame);
    }//end of results

}//end of class
