/*
      * Class to provide object that would
      * print status of trains, it is based on
      * assumption that station would have maximum
      * capacity of holding four train so 
      * four variables to be printed by printing
      * object
      */
public class PrintStatus {
     private String entity;
     private int trainId1;
     private int trainId2;
     private int trainId3;
     private int trainId4;
     public PrintStatus(String entity,int trainId1,int trainId2,int trainId3, int trainId4) {
    	 this.entity = entity;
    	 this.trainId1 = trainId1;
    	 this.trainId2 = trainId2;
    	 this.trainId3 = trainId3;
    	 this.trainId4 = trainId4;
     } 
     
       String trainLabel1;
       String trainLabel2;
       String trainLabel3;
       String trainLabel4;
     // toString so object can print it.
     public String toString() {
    	 // If statement to check whether trains are
    	 // present or print empty station or
    	 // particular track on station.
    	 if(trainId1==0) {
    		 trainLabel1 = "";
    	 }else {
    		 trainLabel1 = Integer.toString(trainId1);
    	 }
    	 if(trainId2==0) {
    		 trainLabel2 = "";
    	 }else {
    		 trainLabel2 = Integer.toString(trainId2);
    	 }
    	 if(trainId3==0) {
    		 trainLabel3 = "";
    	 }else {
    		 trainLabel3 = Integer.toString(trainId3);
    	 }
    	 if(trainId4==0) {
    		 trainLabel4 = "";
    	 }else {
    		 trainLabel4 = Integer.toString(trainId4);
    	 }
    	 // To printed while printing printstatus object
		return "|-----"+entity+"-"+trainLabel1+"-"+trainLabel2+"-"+trainLabel3+ "-"+trainLabel4+"---|";
    	 
     }
	
}

