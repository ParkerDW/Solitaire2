package ca.mcgill.cs.stg.solitaire.cards;

import ca.mcgill.cs.stg.solitaire.cards.Card7.Rank;

/**
 * Same as version 6 but with design by contract
 * instead of defensive programming.
 */
public class Card7
{
	
	public static void main (String args[])
	{
		Card7 cardEx = new Card7(Rank.ACE,Suit.CLUBS);
		//System.out.println(cardEx.toString());
		try
		{
			if(isLegalCard(cardEx)) 
			{
				System.out.println("Legal Card");
			}
		}catch(IllegalCardException e)
		{
			System.out.printf("%s is not a legal card",e.getCard().toString());
		}
	}
	
	
	/**
 	 * A card's rank.
	 */
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, JOKER;
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS, JOKER;
	}
	
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	
	public static final String[] SUITS = {"Clubs", "Diamonds", "Spades", "Hearts"};
	
	private Rank aRank; // Invariant: != null
	private Suit aSuit; // Invariant: != null
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null && pSuit != null
	 */
	public Card7(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank = pRank;
		aSuit = pSuit;
	}
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @post return != null
	 */
	public Rank getRank() 
	{
		return aRank;
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 * @post return != null
	 */
	public Suit getSuit()
	{
		return aSuit;
	}
	
	/**
	 * Assigns a new rank to the card.
	 * @param pRank The new rank.
	 * @pre pRank != null
	 */
	public void setRank(Rank pRank)
	{
		aRank = pRank;
	}
	
	/**
	 * Assigns a new suit to the card.
	 * @param pSuit The new suit.
	 * @pre pSuit != null
	 */
	public void setSuit(Suit pSuit)
	{
		aSuit = pSuit;
	}
	
	@Override
	public String toString()
	{
		return aRank + " of " + aSuit;
	}
	
	/**
	 * 
	 * @param pCard The card to verify validity.
	 * @return true if card is legal, else false
	 */
	public static boolean isLegalCard(Card7 pCard) throws IllegalCardException
	{
		if((pCard.getRank()==Rank.JOKER && pCard.getSuit()!=Suit.JOKER)||(pCard.getRank()!=Rank.JOKER && pCard.getSuit()==Suit.JOKER))
		{
			throw new IllegalCardException(pCard);
		}
		return true;
	}
}