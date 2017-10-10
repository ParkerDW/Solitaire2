package ca.mcgill.cs.stg.solitaire.cards;

import java.util.*;

import ca.mcgill.cs.stg.solitaire.cards.Card.Rank;

public class Hand implements Iterable<Card>, Comparable<Hand>
{
	private final List<Card> myHand = new ArrayList<>(); 
	
	private final int sizeOfHand; 
	
	private final String NAME;
	
	
	public Iterator<Card> iterator()
	{
		return myHand.iterator();
	}
	
	
	public Hand (Deck d, int size, String pName)
	{
		 
		 this.sizeOfHand = size; 
		 
		 this.NAME = pName;
		 
		 for(int i=0;i<size;i++)
		 {
			 this.myHand.add(d.draw());
		 }
	}

	public void add(Card c)
	{
		this.myHand.add(c);
	}
	
	
	public Card remove(Card c)
	{
		assert myHand.contains(c);
		
		Card r = myHand.get(myHand.indexOf(c));
		myHand.remove(myHand.indexOf(c));
		
		return r;
	}
	
	public boolean contains(Card c)
	{
		return myHand.contains(c);
	}
	
	public boolean isFull()
	{
		return myHand.size()==this.sizeOfHand;
	}
	
	public boolean isEmpty()
	{
		return myHand.isEmpty();
	}
	
	public int size()
	{
		return myHand.size();
	}
	
	@Override
	public int compareTo(Hand h)
	{
		return this.size()-h.size();
	}
	
	public class CompareAscending implements Comparator<Hand>
	{
		@Override
		public int compare(Hand one, Hand two)
		{
			return two.myHand.size()-one.myHand.size();
		}
	}
	
	public class CompareDescending implements Comparator<Hand>
	{
		@Override
		public int compare(Hand one, Hand two)
		{
			return one.myHand.size()-two.myHand.size();
		}
	}
	
	public static Comparator<Hand> createDescendingComparator()
	{
		return new Comparator<Hand>() {
			
			@Override
			public int compare(Hand one, Hand two)
			{
				return one.myHand.size() - two.myHand.size();
			}
		};
	}
	
	public enum ComparatorType
	{
		DESCENDING, ASCENDING;
	}
	
	public class UniversalComparator implements Comparator<Hand>
	{
		
		ComparatorType ct;
		
		public UniversalComparator(ComparatorType t)
		{
			ct = t;
		}
		
		@Override
		public int compare(Hand one, Hand two)
		{
			if (this.ct == ComparatorType.DESCENDING){
				return one.myHand.size() - two.myHand.size();
			}
			else if (this.ct == ComparatorType.ASCENDING)
			{
				return two.myHand.size() - one.myHand.size();
			}
			return 0;
		}
	}
	
	public Comparator<Hand> createComparatorByRank(Rank pRank)
	{
		return new Comparator<Hand>() {
			
			@Override
			public int compare(Hand one, Hand two)
			{
				
				return countCards(one) - countCards(two); 
				
			}
			private int countCards(Hand pHand)
			{
				int numCard = 0;
				
				for (Card c : pHand)
				{
					if (c.getRank()==pRank)
					{
						numCard++;
					}
				}
				
				return numCard;
			}
			
		};
	}
	
	public void printName()
	{
		System.out.printf("%s",this.NAME);
	}
	
	public static void main (String[] args)
	{
		Deck d = new Deck();
		String f = "Hello";
		Hand ss = new Hand(d,7,"ss");
		Hand xx = new Hand(d,5,"xx");
		Hand vv = new Hand(d,3,"vv");
		
		List<Hand> sss = new ArrayList<>();
		sss.add(vv);
		sss.add(ss);
		sss.add(xx);
		Collections.sort(sss); 
		
		for (Hand h : sss)
		{
			h.printName();
		}
		System.out.println(ss == xx);
		
	}
	
}
