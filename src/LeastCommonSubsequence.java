import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LeastCommonSubsequence {
	static ArrayList<String> strandGenerated;
	static String lcsVal;
	static ArrayList<String> lcsValList;
	
	public static void main(String[] args) throws IOException {

		Scanner cmd;
		boolean isCommand=true;
		do
		{
			System.out.println("Enter the command. The commands are\n");
			System.out.println("1.new\n2.LCS <filename>\n3.LCS\n4.print\nexit\n");
			cmd=new Scanner(System.in);
			String command=cmd.nextLine();
			System.out.println(command.split(" ")[0]);
			if(command.equals("new"))
			{
				GenerateStrands generateStrandsObj=new GenerateStrands();
				strandGenerated=generateStrandsObj.generateStrands();
				System.out.println("Strands generated Successfully="+strandGenerated);
			}
			else if(command.split(" ")[0].equals("LCS")&&command.split(" ").length>1)
			{
			 System.out.println(command.split(" ")[1]); 
			 System.out.println("Generated strands to store in the file="+strandGenerated); 
			 try {
				PrintWriter pw=new PrintWriter(new FileWriter(command.split(" ")[1],true),true);
				for(int i=0;i<strandGenerated.size();i++){
					pw.write(strandGenerated.get(i));
					pw.write("\n");
				}
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println("Strands stored Successfully="+strandGenerated);
			}
			else if(command.equals("LCS"))
			{
				lcsValList=new ArrayList<String>();
				FileInputStream fi=new FileInputStream("strands.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fi));
				String strand1,strand2;
				int count=0;
				String line;
				while((line = br.readLine()) != null)
				{
					System.out.println(line);
					strand1=line;
					strand2=br.readLine();
					count++;
					if(count==1)
					{
						count=0;
						System.out.println(strand1+" "+strand2); 
						lcsVal=LCSAlgo.findLCS(strand1,strand2);
						System.out.println("main print="+lcsVal);						
						lcsValList.add(lcsVal);
						//lcsVal=LCSAlgo.findLCS("dcbaab","abcdcba");
						//lcsValList.add(lcsVal);
					}
				}
				
			}
			else if(command.equals("print"))
			{
				FileInputStream fi=new FileInputStream("strands.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(fi));
				String strand1,strand2;
				int count=0;
				String line;
				while((line = br.readLine()) != null)
				{
					System.out.println("-----------------------");
					System.out.println("The DNA Strands:\n");
					System.out.println(line);
					System.out.println(br.readLine());
					System.out.println("LCS is "+lcsValList.get(count));
					System.out.println("LCS length is "+lcsValList.get(count).length());
					count++;
				}
				
			}
			System.out.println("would you like another command to enter.Press e to exit");
			if(cmd.nextLine().equals("e"))
			{
				isCommand=false;
			}
		}while(isCommand);
		
	}

}
