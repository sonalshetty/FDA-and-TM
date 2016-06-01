package tcc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FiniteAutomation {
		Map<String,String> kvset = new HashMap<String,String>();
		String startingState = "";
		String endState = "";
		
				public void readFile(String path,String lang)
				{
					try
					{
						@SuppressWarnings("resource")
						BufferedReader b_read = new BufferedReader(new FileReader(path));
						String line = "";
						String[] temp = null;
						System.out.println(lang+" Loading..");
						int count = 0;
						while((line= b_read.readLine()) != null)
						{
							//Starts from 2nd line in the transition table
							if(count != 0)
							{
								String[] temp1 = line.split(" ");
								String state = temp1[0];
								
								if(state.contains(">") && state.contains("*"))
								{
									state = state.replace("*", "");
									state = state.replace(">", "");
									startingState = state;
									endState = endState+","+state;
								}
								else if(state.contains("*"))
								{
									state = state.replace("*", "");
									endState = endState+","+ state;
								}
								else if(state.contains(">"))
								{
									state = state.replace(">", "");
									startingState = state;
								} 
								
								for(int i=1;i<temp1.length;i++)
								{
									kvset.put(state+","+temp[i], temp1[i]);
								}
							}
							
							//Reads the first line to get Alphabets
							else
							{
								temp = line.split(" ");
							}
							count = count + 1;
						}
					System.out.println(lang+" Loaded.");
					}
					catch(Exception e)
					{
						System.out.println("Issue in reading the txt file");
						e.printStackTrace();
					}
				}
		
		public static void main(String args[])
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String retry = "y";
			String path = "";
			FiniteAutomation fa = new FiniteAutomation();
			String input = "";
			boolean check = false;
			
			while(retry.contains("y"))
			{
				System.out.println();
				System.out.println("Choose a machine: \n 1.Deterministic Finite Automation \n 2.Turing Machine");
				int type = sc.nextInt();
			
				if(type == 1)
				{
					System.out.println();
					System.out.println("You chose : "+type);
					System.out.println();
					System.out.println("Available Deterministic Finite Automation and Languages:\nMachine\t\tLanguage\n--------\t--------\nM1\t\tL={w/w divisble by 3}\nM2\t\tL={w/w string should contains substring '0100'}");
					System.out.println();
					System.out.println("Select a Deterministic Finite Automation");
					String lang = sc.next();
					lang = lang.toUpperCase();
					System.out.println();
					if (lang.contains("M1"))
					{
						path = "Divide_by_3.txt";
						check = true;
					}
					else if(lang.contains("M2"))
					{
						check = true;
						path ="Substring_0100_checking.txt";
					}
					else 
					{
						System.out.println("Input not recognized");
					}
					if(check)
					{
					fa.readFile(path,lang);
					System.out.println();
					System.out.println("Enter a String:");
					input = sc.next();
					System.out.println();
					DFA dfa = new DFA();
					dfa.DeterministicFiniteAutomation(input, lang,fa.endState,fa.startingState,fa.kvset);
					System.out.println();
					}
					System.out.println("Try again ?");
					retry = sc.next();
					retry = retry.toLowerCase();
				}
				else if(type == 2)
				{
					System.out.println();
					System.out.println("You chose : "+type);
					System.out.println();
					System.out.println("Available Turing Machines and Languages:\nMachine\t\tLanguage\n--------\t--------\nM1\t\tL={w/w accept single a}\nM2\t\tL={w/w accept 0^2^n 0's|n>=0}");
					System.out.println();
					System.out.println("Select a Turing Machine");
					String lang = sc.next();
					lang = lang.toUpperCase();
					System.out.println();
					if (lang.contains("M1"))
					{
						path = "Accept_a.txt";
						check= true;
					}
					else if (lang.contains("M2"))
					{
						path ="Accepts_zero_power_2^n.txt";
						check= true;
					}	
					else 
					{
						System.out.println("Input not recognized");
						check = false;
					}
					if (check)
					{
					fa.readFile(path,lang);
					System.out.println();
					System.out.println("Enter a String:");
					input = sc.next();
					System.out.println();
					TM tm = new TM();
					tm.TuringMachine(input, lang,fa.endState,fa.startingState,fa.kvset);
					System.out.println();
					}
					System.out.println("Try again ?");
					retry = sc.next();
					retry = retry.toLowerCase();
				}
				else
				{
					System.out.println("Type number 1 or 2 to choose a machine..!!");
					System.out.println();
					System.out.println("Try again ?");
					retry = sc.next();
					retry = retry.toLowerCase();
				}
			}
			System.out.println("Thank you!");
		}
	}