/* Author:  Shawn Vega 
   Due Date:    3/27/2013 
*/ 
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
//import java.util.Comparator;
 
public class MicroFB2 
{
	//create a global hash table allPeople that indexes
	// each person object under the name 
							  //key,  value//
	private static Hashtable<String, Person2>  allPeople = new Hashtable<String, Person2>();
	
	//uses a key a pair of names
	//This second hash table allFriends uses strings as keys and booleans as values 
	private static Hashtable<String, Boolean>  allFriends = new Hashtable<String, Boolean>();

	
	//Create a method Person findPerson(String name) 
	//which searches through allPeople 
	public static Person2 findPerson(String person) 
	{ 	
		//locate person within hash table: utilize Hash table class 

		//Set an iterator using the Iterator class and utilize map.entry from the Map class to 
		//access keys and values. 
		 Iterator<Map.Entry<String, Person2>> search = allPeople.entrySet().iterator();
	      
		 //Returns true if the iteration has more elements.
		 if (person!=null)
		 {
			 while(search.hasNext()) 
			 {
				 Map.Entry<String, Person2> entry = search.next();
				 
				 if(entry.getKey().equals(person))
				 {
					 return (Person2)entry.getValue();
				 }
			 }
		 }
		 else
		 {
		 System.out.println("The person you are trying to locate cannot be found");
		 }
		 return null;
	}
	
	//This custom method addPerson adds a friend to the hash table
	//allPeople
	public static void addPerson(String name)
	{
		//set up a value
		Person2 member=new Person2(name);
		allPeople.put(name,member);
	}
	//This custom method returns true if people actually exists 
	public static boolean validPeople(String x, String y)
	{
		return (findPerson(x)!=null & findPerson(y)!=null);
	}
	//This custom method returns true if people actually exists 
	public static boolean validPerson(String x)
	{
		return (findPerson(x)!=null);
	}
	//This custom method organizes the names alphabetically 
	//Utilizing the compareTo method within the String class
	public static String makeKey(String x,String y)
	{
		String names="";
		
		// If x(liza) and y(sam) this portion would 
		// place liza first 
		if(x.compareTo(y)<0 || x.compareTo(y)==0)
		{
			names=x+"*"+y;
		}
		//If x(sam) and y(liza) this portion would
		//place y first based off of the names 
		//We are using the campareTo method located within
		//the String class
		else if(x.compareTo(y)>0)
		{
			names=y+"*"+x;
		}
		return names;
	}
	
	
	//This custom method utilizes some of my previous 
	//methods 
	public static void assignFriend(String x, String y){
		if(validPeople(x,y))
		{
			//friend people in LinkedList
			findPerson(x).addFriend(findPerson(y)); 
			//generate key and add entry to Hashtable
			allFriends.put(makeKey(x,y),true);
		}
		else
		{
			System.out.print("One of these people does not exists\n");
		}
	}
	
	//This custom method lists friends in allPeople
	public static void list(String name){
		String a=findPerson(name).showFriends();
		System.out.println(a);
		
	}
	public static boolean areFriends(String x, String y){
		Iterator<Map.Entry<String,Boolean>> person=allFriends.entrySet().iterator();
		String xmatch=x+"*"+y;
		String ymatch=y+"*"+x;
		while(person.hasNext()){
			Entry a=(Entry)person.next();
			if(a.getKey().equals(xmatch) || a.getKey().equals(ymatch)){
				return true;
			}
		}
		return false;
	}
/////Beginning of main class///////	
	public static void main(String[] args) 
	{
		// create a scanner for user input 
		Scanner sc=new Scanner(System.in); 
		// give the user a prompt 
		System.out.println("Enter a command: (P,F,U,L,Q,X) "); 
		 
	    String line = ""; 
		 
	    while(line.equals("X")==false) 
		 { 
		    	System.out.print("Enter a new command "); 
		    	// create a line break 
		    	System.out.println(""); 
				line= sc.next().toUpperCase(); 
			 
			 
			if(line.equals("P")) 
			 { 
				// prompt the user to use enter a name 
				System.out.print("Enter a name: "); 
				System.out.println(""); 
				String name=sc.next(); 
				// call on the pCommand with the name  
				pCommand(name); 
				System.out.println(""); 
			 
			 } 
			 
			else if(line.equals("F")) 
			 { 
				// prompt the user to use enter a name 
				System.out.print("Enter a name: "); 
				String name=sc.next(); 
			    // prompt the user to use enter a name 
				System.out.print("Enter another name: "); 
				String name1=sc.next(); 
				// call the fCommand 
				fCommand(name,name1); 
				System.out.println(""); 
			 } 
			 
			else if(line.equals("U")) 
			 { 
				// prompt the user to use enter a name 
				System.out.print("Enter a name: "); 
				String name=sc.next(); 
				// prompt the user to use enter a name 
				System.out.print("Enter another name: "); 
				String name1=sc.next(); 
				// call the unFriend uCommand 
				uCommand(name,name1); 
				System.out.println(""); 
			 } 
			else if(line.equals("L")) 
			 { 
				// prompt the user to use enter a name 
				System.out.print("Enter a name you would like to find: \n"); 
				String name= sc.next();  
				//call the search lcommand 
				lCommand(name); 
				System.out.println(""); 
			 } 
			 
			else if(line.equals("Q")) 
			 { 
				// find the two people and check whether the first is on the list of friends of the second  
				// prompt the user to use enter a name 
				System.out.print("Enter a name: "); 
				String name=sc.next(); 
				// prompt the user to use enter a name 
				System.out.print("Enter another name: "); 
				String name1=sc.next(); 
				// call the qCommand 
				qCommand(name,name1); 
			 
			 } 
			else 
			 { 
				System.out.print("Thank you for using FaceBook"); 
			 } 
	 
		 } 
					 
	} //end microfb
	
		
	// P command record a person
	public static void pCommand(String name) 
	 { 
		addPerson(name);
		System.out.println(name.toString()+" "+"has been added");
	 } 
	// F command friends two people
	public static void fCommand(String pName, String qName) 
	 { 
		assignFriend(pName,qName);
	 }
	
	// U command un-friends two people 
	public static void uCommand(String pName, String qName)
	{
		//Find the two Person objects in the allPeople.
		if (validPeople(pName,qName))
		{
			System.out.println(pName.toString()+" "+ "and"+" "+qName.toString()+" "+"are no longer friends");

			
			
			//remove entry from allFriends hashtable
			if(areFriends(pName,qName)){
			    //Delete each person from the linked lists of the friends of the other person.
				findPerson(pName).friends.remove(findPerson(qName));
				findPerson(qName).friends.remove(findPerson(pName));
				String xmatch=pName+"*"+qName;
				String ymatch=qName+"*"+pName;
				allFriends.remove(xmatch);
				allFriends.remove(ymatch);
			}
			else{
				System.out.println("were not friends can't unfriend");
			}
		}
		else
		{
			System.out.print(pName.toString()+" "+ "or"+" "+qName.toString()+" "+"cannot be located\n");
		}
	}
	
	//search for list of friends 
	public static void lCommand(String name)
	{
		if (validPerson(name))
		{
		list(name);	
		}
		else
		{
			System.out.print("This person does not exists");
		}
	}
		
	 
	//check whether two people are friends 
	public static void qCommand(String pName, String qName) 
	 { 
		//This method utilizes the second hash table allFriends.
		//Construct the two-name key and look it up in allFriends.
		//Find the two Person objects in the allPeople.
		if (validPeople(pName,qName))
		{
			boolean a=areFriends(pName,qName);
			if(a)
			{
			System.out.print(pName.toString()+" "+ "and"+" "+qName.toString()+" "+"are friends.\n");
	
			}
			else
			{
			System.out.print(pName.toString()+" "+ "and"+" "+qName.toString()+" "+"are not friends.\n");
			}
			}
		}		
	 } 




