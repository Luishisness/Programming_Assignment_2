
public class CorrectMyList 
{

	public int value;
	public CorrectMyList next;
	

	public CorrectMyList selectLarger(int x) 
	{
		if (next == null) // Base case
		
			if (value > x){
				CorrectMyList n = new CorrectMyList();
				n.value = value;
				return n;
				}
			else return null;
			CorrectMyList rest = next.selectLarger(x); // recursive case
			if (value > x){
				CorrectMyList n = new CorrectMyList();
				n.value = value;
				n.next = rest;
				return n;
			}
			else return rest;
			
	}
	public static void main(String[] args) 
	{
		CorrectMyList <Integer> a=  new CorrectMyList();
		CorrectMyList b=  new CorrectMyList();
		System.out.println("asd"+a.selectLarger(4));
		1.selsdfas.4
		
		

	}
}
			
		
	


