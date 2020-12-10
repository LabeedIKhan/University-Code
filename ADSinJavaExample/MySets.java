
import java.util.*;

public class MySets  {
	
	
   
        /******
	 * @param args
	 */
   
	public static void main(String args[]) 
    { 
		 
        
          Set<String> likSet1 = new HashSet<String>();
          Collections.addAll(likSet1, "Radishes", "Purple Sprouting Broccoli","Artichoke",
        		  "Beetroot","Cabbage","Sorrel","Spring Greens","Carrots","Spring Onions",
        		  "Watercress","Chicory","Cucumber","Leeks","Parsnip","Rhubarb");
          Set<String> treeset = new TreeSet<String>(likSet1);
          System.out.println();
          System.out.println("likSet1: "+treeset);
          
          Set<String> likSet2 = new HashSet<String>();
          Collections.addAll(likSet2,"Beetroot","Kale","Spring Onions","Morel Mushrooms","Parsnips",
        		  "Radishes","Rhubarb","Rocket","Cabbage","Carrots","Sorrel","Spinach","Chicory",
        		  "New Potatoes","Spring Greens","Watercress","Artichoke");
          Set<String> treeset2 = new TreeSet<String>(likSet2);
          System.out.println();
          System.out.println("likSet2 :"+treeset2);
          
          Set<String> likSet3 = new HashSet<String>();

          Collections.addAll(likSet3, "Beetroot","Chillies","Lettuce","Marrow","Rhubarb","Rocket",
        		  "Pineapple","Asparagus","Aubergine","Samphire","Orange","Spinach","Banana",
        		  "Spring Onions","Peppers","Radishes","Watercress");
          System.out.println();
          System.out.println("likSet3: "+likSet3);
          
          Set<String> lik3 = new HashSet<String>();
          
          Set<String>	unionset1and2 = union(likSet1,likSet2); 
     
          Set<String>	unionset2and3 = union1(likSet2,likSet3); 
        
          convSet(unionset2and3);
        
          intersection1(likSet1,likSet2,likSet3);
        
          diff(likSet1,likSet2);
        
          iterator(likSet3);
        }
        	 
	
   	 public static Set<String> union(Set<String> likSet1,Set<String> likSet2) 
   	 {
   		 
   		 likSet1.addAll(likSet2);
   		 
   		 Set<String> union = new TreeSet<String>(likSet1);
   		 System.out.println("\n"+"Union of LikSet1 and Likset2");
   		 
   		 System.out.println(union);
   		 
		return (union); 
  
   	 } 
     
   	 public static  Set<String> union1(Set<String> likSet2,Set<String>likSet3) 
    	{
   		   likSet2.addAll(likSet3);
   		
   		System.out.println("\n"+"Union of LikSet2 and Likset3");
   		
  		System.out.println(likSet2);
  		
			return likSet2; 
   	 } 

   	 public static <E> ArrayList<E> convSet(Set<E> outputunion1) 
   	 {
   		 
   		 List<E> uList = new LinkedList<E>();
   		 
   		 uList.addAll(outputunion1);
   		 
   		 System.out.println("\n"+"Union of likSet2 and likSet3 converted into uList");
   		 
   		 System.out.println(uList);
   		 
   		 System.out.println("\n"+"Size of uList = "+uList.size());
   		 
		return null; 
       
   	 }
    
    
   
    	public static Set<String> intersection1(Set<String> likSet1,Set<String> likSet2,Set<String> likSet3) 
   	 {
    		Set<String> intersect = new HashSet<String>(likSet1);
    		
    	    intersect.retainAll(likSet2);
    	    
            intersect.retainAll(likSet3);
            
            System.out.println("\n"+"Intersection of likSet1, likSet2 and likSet3 is:");
            
    		System.out.println(intersect);
    		
		return null;    
   	 } 
   
  	  public static Set<String> diff(Set<String> likSet1,Set<String> likSet2) 
   	 {  
  		Set<String> diff = new HashSet<String>(likSet1);
  		
	    diff.removeAll(likSet2);
	    
        System.out.println("\n"+"Difference of likSet1 and likSet2is:");
        
		System.out.println(diff);
		
		return null; 
      } 
    
   	
   	 public static Iterator<String> iterator(Set<String> likSet3) 
   	 {   
   		System.out.println("\n"+"Size of LikSet3 is "+likSet3.size());
   		System.out.println("\n"+"Check the presence of banana, pineapple, orange and strawberries");
		if(likSet3.contains("Banana")) {
			System.out.println("Set contains banana");
			likSet3.remove("Banana");
		}else {
			System.out.println("Set does not contains banana");
		}
		
        if(likSet3.contains("Pineapple")) {
        	System.out.println("Set contains pineapple");
        	likSet3.remove("Pineapple");
		}else {
			System.out.println("Set does not contains pineapple");
		}
        
        if(likSet3.contains("Orange")) {
        	System.out.println("Set contains orange");
        	likSet3.remove("Orange");
		}else {
			System.out.println("Set does not contains orange");
		}
        
        if(likSet3.contains("Strawberries")) {
        	System.out.println("Set contains strawberries");
        	likSet3.remove("Strawberries");
		}else {
			System.out.println("Set does not contains strawberries");
		}
        
   		 System.out.println("\n"+"Iterating likSet3 after removing the fruits"+"\n");
   		 
   		 Iterator itr = likSet3.iterator();
   		 
   		 while(itr.hasNext()) 
   		 {
   			 System.out.println(itr.next());
   		 }
   		 System.out.println("\n"+"Size of likSet3 now: "+ likSet3.size());
   		 
	         return null; 
   	 }
   	 } 
   

