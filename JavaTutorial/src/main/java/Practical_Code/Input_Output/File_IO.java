package Practical_Code.Input_Output;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class File_IO 
{
    public static void main(String[] args) throws IOException
    {
    	/** Path */
    	Path dir = Paths.get("D:\\FCIH\\Self-Study\\Java\\Projects\\Advanced Java\\mydata.dat");
    	if (Files.exists(dir)) 
    	{
		    System.out.println("File Found");
		}else {
			System.out.println("File Not found");            //else it will fire  FileNotFound or FileAlreadyexist if i try to create it 
		}
    	/** File exist , Creat() */
    	File myfile = new File("D:\\FCIH\\Self-Study\\Java\\Projects\\Advanced Java\\mydata2.dat");
    	if (myfile.exists()) {
			System.out.println("already exists");
			System.out.println(myfile.getName());
			System.out.println(myfile.getParent());
		}else
		{
			if(myfile.createNewFile())
			{
				System.out.println("File Not exist and it Created it");
			}
		}
    	
    	/** Copy and Replace */
    	//deh mezt 2nk t3mlo be path a7sn mn kda
    	Path dis = Paths.get("D:\\FCIH\\Self-Study\\Java\\Projects\\Advanced Java\\mydata2.dat");
    	Files.copy(dir,dis, StandardCopyOption.REPLACE_EXISTING);   // StandardCopyOption 3shan tsht8l
    }
}
