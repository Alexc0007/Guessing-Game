import java.util.Random;
/*
 * @author Alex Cherniak
 * this class represents the words database that the game choose the words from
 */
public class Words
{
	/*
	 * create an array of words
	 */
	private String[] words = {"hello", "world", "java", "project", "assign", "you", "people", "restaurant","guess","today"
			,"game","work","dog","animals","computer","programmer"};
	
	/*
	 * empty constructor
	 */
	public Words(){}
	
	
	
	/*
	 * get random word method
	 */
	public String getRandomWord()
	{
		int min = 0;
		int max = words.length-1;
		Random rn = new Random();
		int random = rn.nextInt(max - min + 1)+ min;
		return words[random];
	}
	
	
}
