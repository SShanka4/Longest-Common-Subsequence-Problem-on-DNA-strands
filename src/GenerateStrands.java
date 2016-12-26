import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class GenerateStrands {
	
	public static String[] bases={"A","C","G","T"};
	
/*	public void generateStrandsInFile()
	{
		ArrayList<String> strandsList=new ArrayList<String>();
		Random random=new Random();
		try {
			PrintWriter out=new PrintWriter("strands.txt");
			for(int j=0;j<5;j++)
			{
				int stringRandomLength=random.nextInt(14)+6;
				String strands = "";
				for(int i=0;i<stringRandomLength;i++)
				{
				int randomPointAtString=random.nextInt(4);
				strands=strands.concat(bases[randomPointAtString]);
				}
			strandsList.add(strands);
			out.write(strands+"\n");
			}
			System.out.println(strandsList);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}*/
	
	public ArrayList<String> generateStrands()
	{
		ArrayList<String> strandsList=new ArrayList<String>();		
		Random random=new Random();
			for(int j=0;j<2;j++)
			{
				int stringRandomLength=random.nextInt(14)+6;
				String strands = "";
				for(int i=0;i<stringRandomLength;i++)
				{
				int randomPointAtString=random.nextInt(4);
				strands=strands.concat(bases[randomPointAtString]);
				}
				strandsList.add(strands);
			}
			return strandsList;
	}

}
