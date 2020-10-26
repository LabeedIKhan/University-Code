import java.util.Random;

public class CreateTrain implements Runnable {
    private int trainNumGen;
	private int trainNum;
    private String trainType;
    private int trainSpeed;
    public CreateTrain(int trainNumGen, int trainNum, String trainType,int trainSpeed) {
    	this.trainNumGen = trainNumGen;
    	this.trainNum = trainNum;
    	this.trainType = trainType;
    	this.trainSpeed = trainSpeed;
    }
	@Override
	public void run() {
	   /*
	    * As the train creation should continue 
	    * indefinitely it becomes very difficult
	    * to see what is happening to slow it
	    * thread is made to sleep for 2 second
	    * so a new train is created every 2 seconds.
	    */
		while(true) {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {};
		// Random number is generated to provide
		// random selection of train category and 
		// Characteristics like speed and trainid number 
		 Random r = new Random();
		 // The probability of train being of either
		 // category is equal, If random number is 
		 // greater then 10 it is express train with 
		 // 100 speed else local train with 10 speed
	 trainNumGen = r.nextInt(20);
	 if (trainNumGen < 10) {trainType = "Local";trainSpeed = 10;trainNum = trainNumGen;
	 }else {
		 trainType = "Express";trainSpeed = 100;trainNum = trainNumGen; 
	 }
	 // create new train every two seconds 
	 // and run it on its own thread.
	 final Train train = new Train(trainType,trainSpeed ,trainNum);
	 Thread trainThread = new Thread(train);
	 trainThread.start();

	 }
  }
    
}