public class Speaking
{
	//methods

	//returns the name in all capital letters
	public String yelling(String name)
	{
		return name.toUpperCase();
	}

	//returns the name in all lower case letters
	public String whisper(String name)
	{
		return name.toLowerCase();
	}

	//moves first letter to end, adds "ay"
	public String pigLatin(String word)
	{
		if (word.length() == 0)
		{
			return word;
		}
		return word.substring(1) + word.substring(0, 1) + "ay";
	}

	//first half of name1 + second half of name2
	public String nameJoin(String name1, String name2)
	{
		String firstHalf = name1.substring(0, name1.length() / 2);
		String secondHalf = name2.substring(name2.length() - name2.length() / 2);
		return firstHalf + secondHalf;
	}
}