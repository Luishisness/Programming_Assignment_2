/* Author:  Shawn Vega
   Due Date:    3/27/2013
*/
// import exact classes you need!!! 
import java.util.Iterator;
import java.util.LinkedList;


//import java.util.ListIterator;

////////////////Programming Assignment 2/////////////////////////
public class Person2
{
	private String name;
	
	// linked list to store friends when using the addFriend method 
	LinkedList<Person2> friends= new LinkedList<Person2>();
	
	// Gets the name
	public String getName()
	{ 
		return name;
	}
	//Gets the friend
	public LinkedList<Person2> getFriend()
	{
		return friends;
	}
	
	// create a constructor
	public Person2(String n)
	{
		name=n;
	}
	
	// method - search friend boolean test
	public boolean searchFriend(Person2 q)
	{
		//Set an iterator using the ListIterator class
		Iterator<Person2> search=friends.iterator();		
		
		//We need to iterate over the list to make sure that q
		//is not already in it! 
		// hasNext  Returns true if this list iterator has more 
		//elements when traversing the list in the forward direction.

		while(search.hasNext())
		{
			// set up Person2 object as a variable :ListIterator class
			//.next() returns next element in the list 
			Person2 a=(Person2) search.next();
			if(a.getName().equals(q.getName()))
			{
				return true;
			}
		}
		return false;
	 }	
	public String showFriends(){
		//Set an iterator using the ListIterator class
		Iterator<Person2> search=friends.iterator();
		String fdNames="";
		while(search.hasNext())
		{
			Person2 friendName=(Person2)search.next();
			fdNames+=String.format(friendName.getName()+"\n");
		    	
		}
		return fdNames;
	}
	
		
		// method - add friend
		public void addFriend(Person2 q)
		{
			// create the condition to make sure q is not null
				// Add q to the beginning of the list only if it does not already
				//exists in the list
				//addFirst is equivalent to push LinkedList class
				if(!searchFriend(q))
				{
					System.out.println("Your friend has been added");
					friends.addFirst(q);
					q.friends.addFirst(this);
				}
				else 
				{
				System.out.println("Sorry, but you are unable to add this friend.");
				
				}
			}
	}
		
				
	

