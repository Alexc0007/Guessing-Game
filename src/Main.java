import java.util.Scanner;

/**
 * @author Alex Cherniak
 *this is the main file of the guessing game
 *the goal of the game is to gess a randomly chosen word(from a database of words)
 *using the english letters provided by the program (the whole ABC at the start)
 *
 *each guess will removed the letter the user tried to guess and reveal the letter in the word in case the letter
 *appears in the word
 */
public class Main
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);//define a scanner object to read input
		
		final int FROMASCIICONVERT = 97; //the number represents 'a' in ascii and will help to reach the correct letter on the "remainingLetters" array
		final int FROMASCIICONVERTUPPER = 122;
		String input; //will hold the letter that the user inserts when he tries to guess the word
		char in; //will hold the input letter once the inserted input is a confirmed 1 char
		int guessed = 0; //a flag that will determine if game is complete or should continue till user guesses the word
		Words words = new Words(); //will create a DB of words
		ChosenWord chosen = new ChosenWord(words.getRandomWord()); //will pick one of the words from the DB and set it as chosen
		int count = 0; //count the number of guesses the user does until he fully guesses the word
		//an array of remaining letters to guess
		char[] remainingLetters  = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] displayed = new char[chosen.chosenWord.length]; //create an array that will be of the same length as the length of the chosen word
		for(int i=0;i<displayed.length;i++)//initialize the displayed array with '-' instead of every letter
		{
			displayed[i] = '-';
		}
		System.out.println("welcome to the guessing game - a random word has been chosen from the database please start guessing\n\n");
		while(guessed != 1)//while word is not guessed by user
		{
			System.out.println("\nthe remaining letters are:");
			printRemainingLetters(remainingLetters); //will print the remaining letters to guess from
			
			System.out.println("\n\nthe word to guess is:");
			printDisplayed(displayed); //will print the displayed array
			System.out.println("\n");
			input = scanner.next();
			count ++; //rise the number of guesses by 1 as the user inserts an input
			if(input.length() == 1)//means only 1 character is inserted - as it should be
			{
				in = input.charAt(0); //convert the inserted string into char
				if((int)in >= FROMASCIICONVERT && (int)in <= FROMASCIICONVERTUPPER) //means that the input is a small letter from the abc and we can proceed
				{
					remainingLetters[(int)in - FROMASCIICONVERT] = '*'; //replace the letter guessed by the user with '*'
					if(chosen.checkLetter(in)) //if true - means that letter is present at the chosen word
					{
						revealLetters(displayed , in , chosen); //will reveal the letters that the user guessed on the displayed array
						System.out.println("you guessed a letter from the word!");
						System.out.print("now the words appears to be:");
						printDisplayed(displayed); //print the displayed array again after revealing a letter/s
						System.out.println("\n");
						if(checkGuessed(displayed)) //if true - means there are no more letters to guess
						{
							System.out.println("word guessed successfuly");
							System.out.println("number of guesses is: " + count);
							scanner.close();
							try {
								Thread.sleep(30000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.exit(0); //exit the loop
						}
					}
					else
					{
						System.out.println("you guessed a wrong letter");
					}
				}
				
			}
			if(input.compareTo("exit") == 0)
			{
				System.exit(0); //end the game
				scanner.close();
			}
		}	
	}
	
	
	/*
	 * print remaining letters method
	 */
	public static void printRemainingLetters(char[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			if(array[i] != '*')
			{
				System.out.print(array[i]+",");
			}
		}
	}
	
	/*
	 * print displayed word on screen
	 */
	public static void printDisplayed(char[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]);
		}
	}
	
	/*
	 * a method that will modify the "displayed" array to reveal any discovered letters from the chosen word
	 */
	public static void revealLetters(char[] displayedArray , char letter, ChosenWord chosen)
	{
		for(int i=0;i<displayedArray.length;i++)
		{
			if(letter == chosen.chosenWord[i])
			{
				displayedArray[i] = letter; //sets the letter into its spot on displayed array
			}
		}
	}
	
	/*
	 * a method to check if the chosen word is completely gussed
	 */
	public static boolean checkGuessed(char[] displayedArray)
	{
		for(int i=0;i<displayedArray.length;i++)
		{
			if(displayedArray[i] == '-')
			{
				return false; //if there are still unguessed letters on the array - return false
			}
		}
		return true; //all the letters are guessed - return true
	}
	

}


