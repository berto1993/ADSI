package packModelo;

import java.util.Comparator;

public class comparatorString implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) 
	{
		int a,b;
		a = (int) Integer.parseInt(arg0.split("->")[1]);
		b = (int) Integer.parseInt(arg1.split("->")[1]);
		return a-b;		
	}

}
