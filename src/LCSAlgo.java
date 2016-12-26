
public class LCSAlgo {
	

	public static int LEFT=1;
	public static int RIGHT=2;
	public static int UP=3;
	public static int DIAGONAL=4;

	public static String findLCS(String test1, String test2) {
		//String test1="dcbaab",test2="abcdcba";
		int lengthOfString1=test1.length();
		int lengthOfString2=test2.length();
		
		Integer[][] lcsMatrix = new Integer[lengthOfString1+1][lengthOfString2+1];
		Integer[][] backTrack = new Integer[lengthOfString1+1][lengthOfString2+1];
		
		for(int i=0;i<lengthOfString1+1;i++)
		{
			for(int j=0;j<lengthOfString2+1;j++)
			{
				lcsMatrix[i][j]=0;
				backTrack[i][j]=0;
			}
		}
		for(int i=1;i<lengthOfString1+1;i++)
		{
			for(int j=1;j<lengthOfString2+1;j++)
			{
				if(test1.charAt(i-1)==test2.charAt(j-1))
				{
					lcsMatrix[i][j]=lcsMatrix[i-1][j-1]+1;
					backTrack[i][j]=DIAGONAL;
				}
				else{
					  if(lcsMatrix[i-1][j]>lcsMatrix[i][j-1]){ lcsMatrix[i][j]=lcsMatrix[i-1][j]; backTrack[i][j]=UP;}
					  else{ lcsMatrix[i][j]=lcsMatrix[i][j-1];  backTrack[i][j]=LEFT;}
				}
			}
		}
		
		 /* Backtracking */
		String lcs = new String();
        int i=lengthOfString1;
        int j=lengthOfString2;
        while (i!=0 && j!=0) {
        	System.out.println("i and j="+i+j);
            if (backTrack[i][j] ==DIAGONAL) {
                lcs =test1.charAt(i-1) + lcs;
                i=i-1;
                j = j - 1;
            }
            if (backTrack[i][j] == UP && i>0 && j>0) {
                i = i - 1;
            }
            if (backTrack[i][j] == LEFT) {
                j = j - 1;
            }
        }
        System.out.println("here is LCS="+lcs);
		return lcs;
	}



}
