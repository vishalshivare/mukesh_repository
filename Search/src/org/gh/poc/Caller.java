package org.gh.poc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Caller 
{
	ArrayList<String> lines = new ArrayList<String>();   
    String line= null;

	public static void main(String[] args) 
	{
		/*System.out.println("Enter Directory: ");
		@SuppressWarnings("resource")
		String dir=new Scanner(System.in).next();
				
		File currentDir = new File(dir); // current directory
		if(currentDir.exists())
		displayDirectoryContents(currentDir);
		else
			System.out.println("Invalid Directory");*/
		Caller cal=new Caller();
		cal.findReplace();

	}
	
	//Search for file and folder
	public static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Find & Replace Content
	public void findReplace()
	{   
        try
        { 
        	File f1=new File("E:\\upload\\file 4\\txt.txt");
        	System.out.println(f1.getParentFile()+"\\"+f1.getName());
        	
        	File f2=new File("E:\\upload\\"+f1.getName());  //"E:\\upload\\mkm_temp.txt"
        	String str="E:\\upload\\";  
    FileReader fr = new FileReader(f1);   
    BufferedReader br = new BufferedReader(fr);   
    FileWriter fw = new FileWriter(f2);   
    PrintWriter out = new PrintWriter(fw);   System.out.println("ok"); 
    while((line=br.readLine()) != null)
    {  
        line = line.replace("project", "pritish");   
        lines.add(line);   
        //out.write(line+"\n");
    }
    /*br.close();
    fw = new FileWriter(f1);   
     out = new PrintWriter(fw); 
     out.write(lines.toString());
        */        
        
        }   
    catch(Exception e)
        {System.out.println(e);}   
    } 
	
	
	

}
