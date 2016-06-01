package tcc;

import java.util.Map;

public class DFA {
	
	public void DeterministicFiniteAutomation(String input,String lang,String endState,String startingState, Map<String,String> kvset)
	{
		String state = startingState;
		
		String in[] = input.split("");
		String nextState = null;
		
		for(int i=0;i<in.length;i++)
		{
			nextState = kvset.get(state+","+in[i]);
			if(nextState != null)									/*transtion of states*/
			{
				System.out.println(state+" , "+in[i]+" -> "+ nextState);
				state = nextState;
			}
			else
			{
				System.out.println();
				System.out.println(state+" , "+in[i]+" -> N/A");
				state = " ";
				break;
			}
		}
		if(!endState.contains(state))
		{
			System.out.println();
			System.out.println("String "+input + " is REJECTED");
			System.out.println(lang+" got Struck in state "+state);
		}
		else
		{
			System.out.println();
			System.out.println();
			System.out.println("String "+input+" is ACCEPTED");
		}
	}

}
