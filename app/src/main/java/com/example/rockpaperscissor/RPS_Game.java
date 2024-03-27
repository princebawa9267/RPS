package com.example.rockpaperscissor;
import java.util.Random;
public class RPS_Game {
    char userInput;
    char Output;
    public RPS_Game(char userInput)
    {
        this.userInput = userInput;
        computerInput();
        takeInput();
    }
    String Alphabet = "RPS" ; //This String will be used to generate random from R (Rock),P (Paper) and S (Scissor)
    void computerInput()
    {
        //This will generate random from R,P,S
        Random Rand = new Random();
        Output = Alphabet.charAt(Rand.nextInt(Alphabet.length()));
    }
    char takeInput()
    {
        //Condition where User won the match
        /*
         User           Computer

         Rock           Scissor
         Paper          Rock
         Scissor        Paper
         */
        if((userInput == 'R' && Output == 'S') || (userInput == 'P' && Output == 'R') ||( userInput == 'S' && Output == 'P' ))
        {
            return 'W';// W used for Winning
        }
        //Condition where Computer won the match
        /*
         User           Computer

         Rock           Paper
         Paper          Scissor
         Scissor        Rock
         */
        else if((userInput == 'R' && Output == 'P') || (userInput == 'P' && Output == 'S') ||( userInput == 'S' && Output == 'R' ))
        {
            return 'L';//L used for Lose
        }
        //Match will Draw when User and Computer have the same choose
        else
        {
            return 'D';//D used for Draw
        }
    }
}
