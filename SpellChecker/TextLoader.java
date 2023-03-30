import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class TextLoader
{
	String dictionary1 = "";
	FileReader fr = null;
	Scanner scan;
	ArrayList<String> currentWord = new ArrayList<String>();


	public TextLoader(String file)
	{
		try
		{
			fr = new FileReader(file);
			scan = new Scanner(fr);
			scan.useDelimiter("'");

			while(scan.hasNext())
			{
				String a = scan.next();
				currentWord.add(a);
				dictionary1 = dictionary1 + a+ " ";
			}

		}
			catch(Exception e)
		{
			System.out.println("File Not Found");
		}
	}

	public String getFile()
	{
		return dictionary1;
	}
}
