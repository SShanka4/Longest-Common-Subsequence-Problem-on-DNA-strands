import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestCommonSubsequence {
	static ArrayList<String> strandGenerated;
	static ArrayList<String> lcsValList;
	static ArrayList<String> generatedList;
	
	public static void main(String[] args) throws IOException {

		Scanner cmd;
		boolean isCommand=true;
		lcsValList=new ArrayList<String>();
		strandGenerated=new ArrayList<String>();
		while(isCommand)
		{
			System.out.println("Enter the command. The commands are\n");
			System.out.println("-new\n-LCS <filename>\n-LCS\n-print\n-quit\n");
			cmd=new Scanner(System.in);
			String command=cmd.nextLine();
			System.out.println(command.split(" ")[0]);
			if(command.equals("new"))
			{
				GenerateStrands generateStrandsObj=new GenerateStrands();
				strandGenerated.addAll(generateStrandsObj.generateStrands());
				System.out.println("Strands generated Successfully="+strandGenerated);
			}
			
			
			else if(command.split(" ")[0].equals("LCS")&&command.split(" ").length>1)
			{
			    System.out.println(command.split(" ")[1]);
				lcsValList=new ArrayList<String>();
				try{
				FileInputStream fi=new FileInputStream(command.split(" ")[1]);
				BufferedReader br = new BufferedReader(new InputStreamReader(fi));
				String strand1,strand2;
				int count=0;
				String line;
				while((line = br.readLine()) != null)
				{
					count++;
					strandGenerated.add(line);
				}
				if(count==0){ System.out.println("File is empty");}
				else{System.out.println("Strands stored Successfully="+strandGenerated);
				}
				}catch(FileNotFoundException e){ System.out.println("File not found!! Please enter correct filename");}
				
			}
			
			else if(command.equals("LCS"))
			{
				int totalLength=0;
				if(strandGenerated.size()==0) 	System.out.println("No strands available in memory!");
				if(strandGenerated.size()%2==0) totalLength=strandGenerated.size();
				else totalLength=strandGenerated.size()-1;
					
				for(int i=0;i<totalLength-1;i+=2)
				{
					String lcsVal=LCSAlgo.findLCS(strandGenerated.get(i),strandGenerated.get(i+1));
					System.out.println("main print="+lcsVal);						
						lcsValList.add(lcsVal);
				}
			}
			
			else if(command.equals("print"))
			{
				int count=0;
				int i=0;
				if(lcsValList.size()==0) 	System.out.println("Nothing to print!");
				while(count<lcsValList.size())
				{
					System.out.println("-----------------------");
					System.out.println("The DNA Strands:\n");
					System.out.println(strandGenerated.get(i));i++;
					System.out.println(strandGenerated.get(i));
					System.out.println("LCS is "+lcsValList.get(count));
					System.out.println("LCS length is "+lcsValList.get(count).length());
					System.out.println("-----------------------");
					count++;
					i++;
				}
				
			}
			else if(command.equals("quit")) {isCommand=false;}
		}
		
	}

}
