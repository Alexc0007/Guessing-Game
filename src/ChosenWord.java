/*
 * @author Alex Cherniak
 * this class will represent a random chosen word that the player will have to guess
 */
public class ChosenWord 
{
	private String word;
	protected char[] chosenWord; //will represent the chosen word as an array of characters
	
	////////////////////////////////////////////////////////////////////////////////
	////////////////////////     constructors         //////////////////////////////
	
	/*
	 * empty constructor
	 */
	public ChosenWord()
	{
		
	}
	/*
	 * constructor that sets the chosen word
	 */
	public ChosenWord(String word)
	{
		this.word = word;
		chosenWord = word.toCharArray();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////            getters & setters     //////////////////////////
	public String getWord() 
	{
		return word;
	}

	public void setWord(String word) 
	{
		this.word = word;
	}
	
	////////////////////////////////////////////////////////////////////////////
	//////////    methods         //////////////////////////////////////////////
	
	/*
	 * check if letter is in the chosen word
	 */
	public boolean checkLetter(char let)
	{
		String letter = String.valueOf(let);
		if(word.contains(letter))//true if chosen word contains the letter provided as a param
		{
			return true;
		}
		else 
		{
			return false; //letter isnt in the chosen word
		}
	}
	
}
