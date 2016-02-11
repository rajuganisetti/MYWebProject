package com.login;
import java.io.File;

public class Foldercreate {

		public void FolderCreation(String foldername)
		{
			
			File theDir = new File(foldername);
			

			// if the directory does not exist, create it
			if (!theDir.exists()) {
			    System.out.println("creating directory: " + foldername);
			    boolean result = false;

			    try{
			        theDir.mkdir();
			        result = true;
			        
			    } 
			    catch(SecurityException se){
			        //handle it
			    }        
			    if(result) {    
			        System.out.println("DIR created");  
			    }
			}

		}
}		
