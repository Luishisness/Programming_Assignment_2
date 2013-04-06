
public class MyList 
{
	public MyList selectLarger(int x)
	{
		if(next==null)
		{
			if(value>x)
			{
				return this;
			}
			else
			{
				return null;
			}
		}
		else if(value>x)
		{
			next= next.selectLarger(x);
			return this;
			
		}
	}
	
	

}
