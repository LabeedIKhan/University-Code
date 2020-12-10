
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

           
public class MyBST_Excercise {

	   private static <E> void iterateMyList(LinkedList<E> likFruits) 
	   
	    {   
		   System.out.println("This is likFruits linkedList using Java LinkedList class:"+"\n");
		   
		   for(E lik: likFruits)
		   {
			   System.out.println(lik);
		   }
	          
	    } 

	   private static <T> void checkGoose(LinkedList<T> likFruits) 
	    { 
		   String goose = "Gooseberries";
              if (likFruits.contains(goose)) 
              {
            	  System.out.println("\n"+"LinkedList contains the element 'Gooseberries"+"\n");
              }else {
            	  System.out.println("\n"+"LinkedList doesn't contains the element 'Gooseberries"+"\n");
              }
	         
	    } 
	   
	   
	   private static void insertGoose(LinkedList<String> likFruits) 
	    {         
		       String goose = "Gooseberries";
                 for(int i=0;i<likFruits.size();i++) 
                 {
                	 if(likFruits.get(i).equals("Blackberries"))
                	 {
                		 likFruits.add(i+1,goose);
                	 }
                 } 
                 System.out.println("\n"+"Updated list with Gooseberries"+"\n"); 
                    System.out.println(likFruits);
	    }
	   
	   private static void notEndingWithBerries(LinkedList<String> likFruits) 
	    { 
		       String notBerries;     
		   for (int i=0;i<likFruits.size();i++)
		   {
		        if(!likFruits.get(i).endsWith("berries"))
		         {
		        	notBerries = likFruits.get(i);
		            System.out.println("\n"+
		                    "Element not ending with berries"+"\n"+
		            		notBerries);
		        	likFruits.remove(i);
		         }
		   }
		           System.out.println("\n"+"LinkedList after removing Apples"+"\n");
		           
		           System.out.println(likFruits);
	     }


	   private static String[] convertLinkedListToArray (LinkedList<String> likFruits) 
	   
	    { 
	          String[] bstFruits = likFruits.toArray(new String[likFruits.size()]);
	          
	          System.out.println("\n"+"likFruits after converting LinkedList to Array"+"\n");
	          
	          for (int i=0;i<bstFruits.length;i++)
	          {
	        	  System.out.println(bstFruits[i]);
	          }
	          return bstFruits;
	    } 
	   

	   private static void sortedLinkedList(LinkedList<String> likFruits) 
	   
	    { 
                 Collections.sort( likFruits);
                 
                 System.out.println("\n"+"This is likFruits LinkedList sorted in ascending order"+"\n");
                 
                 System.out.println(likFruits);
	    } 
	   
		public static void main(String[] args) {
			
			   LinkedList<String> likFruits = new LinkedList<String>();
			   likFruits.add("Strawberries");
			   likFruits.add("Raspberries");
			   likFruits.add("Blueberries");
			   likFruits.add("Cranberries");
			   likFruits.add("Blackberries");
			   likFruits.add("Apples");
			   likFruits.add("Honeyberries");
			   likFruits.add("Gojiberries");
			   likFruits.add("Wineberries");
			   likFruits.add("Tayberries");
			   
		       iterateMyList(likFruits);
  
			    checkGoose(likFruits);
		     
				insertGoose(likFruits);
		
				notEndingWithBerries(likFruits);
			   
				String[] bstFruits = convertLinkedListToArray (likFruits);
			 	 
				sortedLinkedList(likFruits);
	
				BSTree myTree = new BSTree();
				for(int i=0;i<bstFruits.length;i++) {
					myTree.insert(" "+bstFruits[i]+" ");
				}

		      myTree.inOrder();
		      myTree.postOrder();
		      myTree.preOrder();
              
			}
		}

	
	class FruitNode {
		String fruitName;
		
    	FruitNode leftChild;
    	FruitNode rightChild;
    	FruitNode(String fruitName){
    		this.fruitName=fruitName;
    	}
    	public String toString() {
    		return fruitName;
    	}
	}

	
	class BSTree {
	   private static FruitNode root; 
	   
	   public void insert(String fruitName) {
	           int direc = 0;
	           FruitNode parent = null;
	           FruitNode currFruit = root;
	           for(;;) {
	        	   if(currFruit == null) {
	        		   FruitNode frNode = new FruitNode(fruitName);
	        		   if (root == null)
	        			   root = frNode;
	        		   else if(direc<0) 
	        			   parent.leftChild =  frNode;
	        		   else
	        			   parent.rightChild = frNode;
	        		   break;
	        	   }
	        		   direc = fruitName.compareTo(currFruit.fruitName);
	        		   if(direc == 0) 
	        			   break;
	        		   parent = currFruit;
	        		   if(direc<0)
	        			   currFruit = currFruit.leftChild;
	        		   else
	        			   currFruit = currFruit.rightChild;
	        	   }
	           }

           public void inOrder() {
        	   System.out.println("\n"+"This is myTree inOrder traversal"+"\n");
        	    inOrderT(root);
        	   
           }
           public void postOrder() {
        	   System.out.println("\n"+"This is myTree postOrder traversal"+"\n");
        	   postOrderT(root);
           }
           public void preOrder() {
        	   System.out.println("\n"+"This is myTree pre Order traversal"+"\n");
        	   preOrderT(root);
           }

		    
	   private static void inOrderT(FruitNode frNode) {
		   if(frNode != null) {
			   inOrderT(frNode.leftChild);
			   System.out.print(frNode);
			   inOrderT(frNode.rightChild);
		   }
		  
	   }
       
        private static void postOrderT(FruitNode frNode) {
        	if(frNode != null) {
        		postOrderT(frNode.leftChild);
        		postOrderT(frNode.rightChild);
        		System.out.print(frNode);
        		
        	} 
        }
        private static void preOrderT(FruitNode frNode) {
        	if(frNode != null) {
        		System.out.print(frNode);
        		preOrderT(frNode.leftChild);
        		preOrderT(frNode.rightChild);
        	} 
        }        
	
}

