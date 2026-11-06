public class Wordplay
{
	//no attributes nor constructors needed
	
	//methods
	/* Hint: You may want to use API documentation to understand 
	.split(), charAt(), substring(), replace()*/

	//returns first word of the full name
	public String getFirstName(String fullName)
	{
		String[] parts = fullName.trim().split("\\s+");
		return parts[0];
	}

	//returns last word of the full name
	public String getLastName(String fullName)
	{
		String[] parts = fullName.trim().split("\\s+");
		return parts[parts.length - 1];
	}

	//returns first letter of each name, uppercased
	public String getInitials(String fullName)
	{
		String first = getFirstName(fullName);
		String last = getLastName(fullName);
		String initials = "" + first.charAt(0) + last.charAt(0);
		return initials.toUpperCase();
	}

	//length + first half + last name + last half + length
	public String makePassword(String fullName)
	{
		String first = getFirstName(fullName);
		String last = getLastName(fullName);

		//odd lengths include middle letter, e.g. Bernard -> Bern
		String firstHalf = first.substring(0, (first.length() + 1) / 2);
		String lastHalf = last.substring(last.length() / 2);

		return first.length() + firstHalf + last + lastHalf + last.length();
	}

	//replaces every c with b, keeping capitalization
	public String ceeBee(String phrase)
	{
		return phrase.replace('c', 'b').replace('C', 'B');
	}
}