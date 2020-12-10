

import java.util.ArrayList;
import java.util.Iterator;

          
public class JavaExercise1<E>{
	
	
	   public static <E> Iterator<E> MyListIterator(ArrayList<E> likList) 
	    {   
		   Iterator<E> I = likList.iterator();
		   
		   System.out.println("Title - Original ArrayList"+"\n");
		   
		   while(I.hasNext())
		   {
			   E listElements = I.next();
			   System.out.println(listElements);
		   }
			return null; 
	    } 
	
	   public static void MyEnhancedLoop(ArrayList<String> likList) 
		   
	   {      
		   System.out.println("\n"+"Title - ArrayList after adding elements"+"\n");
	            
	           likList.add(0,"Peterhead Prison Museum");
	           likList.add(1,"Wick Heritage Museum");
	           
			  for (String lik : likList)
			  {
				  System.out.println(lik);
			  }
		         
	   } 
		 
	   public static <E> void MyWhileLoop(ArrayList<E> likList) 
	  { 
			       int i=0;
			       System.out.println("\n"+"Title - ArrayList after remove operation"+"\n");
			      
			       while(i < likList.size()) 
			       {
			    	   if(likList.get(i).equals("Camera Obscura and World of Illusions")) 
			    	   {
			    		   likList.remove(i);
			    	   }
			    	   System.out.println(likList.get(i));
			    	   i++;
			       }
	   } 
		 

	 public static <E> void MyForLoop(ArrayList<E> likList) 
	 { 
		 System.out.println("\n"+"Title - Final ArrayList"+"\n");
			
		   for (int i=0;i<likList.size();i++) 
			 {
				 if(i==4 && !likList.get(i).equals(null))
				 {
					 likList.remove(i);
				 }
				 System.out.println(likList.get(i));
			 }
	 }
	   
	 public static void main(String args[]) {
		 
		      
		 ArrayList<String> likList = new ArrayList<String>();
		 likList.add("Kelvingrove Art Gallery and Museum");
		 likList.add("National Museum of Scotland");
		 likList.add("Royal Yacht Britannia");
		 likList.add("Camera Obscura and World of Illusions");
		 likList.add("Morayvia");
		 likList.add("Montrose Air Station Heritage Centre");
		 MyListIterator(likList);
		 MyEnhancedLoop(likList);
		 MyWhileLoop(likList);
		 MyForLoop(likList);
	      
	       
	  }
}