package tcc;

import java.util.Map;

public class TM {

	public void TuringMachine(String input,String lang,String endState,String startingState,Map<String,String> kvset)
	{
		//Consider Blank space as $ and appending a extra $ at last position of the input
		String tempInput = input+"$";
		String state = startingState;
		String nextState = "";
		String[] temp = tempInput.split("");
		for(int i=0;i<temp.length;i=i)
		{
			System.out.print(state+" , "+temp[i]+" -> "+ nextState+"; ");
			String temp1 = kvset.get(state+","+temp[i]);
			nextState = temp1.split(":")[0];
			state = nextState;
			String temp2 = temp1.split(":")[1].replace(":", "");
			System.out.println(temp[i]+" -> "+temp2);
			String[] temp3 = temp2.split(",");
			if(temp3[0].length() != 0)
			{
			temp[i] = temp3[0];
			}
			if(temp3[1].contains("l"))
			{
				i = i - 1;
				if(i < 0)
				{
					i = 0;
				}
			}
			else
			{
				i = i + 1;
			}
		}
		if(!endState.contains(state))
		{
			System.out.println();
			System.out.println("String "+input + " is REJECTED");
			System.out.println(lang+"  Struck in state "+state);
		}
		else
		{
			System.out.println();
			System.out.println("String "+input+" is ACCEPTED");
		}
	}
	
}
