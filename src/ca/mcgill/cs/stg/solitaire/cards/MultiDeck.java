package ca.mcgill.cs.stg.solitaire.cards;

import java.util.*;

public class MultiDeck
{
	
	private List<Deck> listDeck;
	
	public MultiDeck()
	{
		this.listDeck = new ArrayList<Deck>();
	}
	
	
	public void addDeck(Deck d)
	{
		assert d!=null; 
		
		this.listDeck.add(d);
	}
	
	public MultiDeck shallowCopy()
	{
		MultiDeck shallowCopy = new MultiDeck();
		for (Deck d : listDeck)
		{
			Deck copyDeck = d;
			shallowCopy.addDeck(copyDeck);
		}
		return shallowCopy;
	}
	
	public static void main (String[] args)
	{
		
	}
	
}
