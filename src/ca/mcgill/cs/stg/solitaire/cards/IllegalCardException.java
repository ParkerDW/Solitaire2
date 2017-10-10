package ca.mcgill.cs.stg.solitaire.cards;

import ca.mcgill.cs.stg.solitaire.cards.Card7.Rank;

public class IllegalCardException extends Exception
{
	private static Card7 aCard;
	
	public IllegalCardException (Card7 card)
	{
		this.aCard=card;
	}
	
	public Card7 getCard()
	{
		return aCard;
	}
}
