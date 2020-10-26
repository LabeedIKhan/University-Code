import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
      /*
       * Station class is extending segment
       * as both have similarities that make
       * inheritance reasonable here
       */
public class Station extends Track {
    /*
     * ArrayList has been added with assumption
     * that trains can be added and removed by
     * capacity specified in Station object 
     * Station objects have been created in Train 
     * class
     */
	private static boolean confirm = false;
	int[] stationaryTrains = new int[10];
	static int counter;
	private static int arrivingTrain;
	
    private String stationName;
    private int trainSpeed;
	public Station(String stationName,int capacity, int length, int trainOnTrack, int trainSpeed ) {
		// Inherited from track
		super(capacity, length, trainOnTrack);
		// new variables added
		this.stationName = stationName;
		this.trainSpeed = trainSpeed;
	}
	/*
	 * Getter and setter of variables added 
	 * by Station class while extending Track
	 */
	public void setStationName(String sname) {
		this.stationName = sname;
	}
	public String getStationName() {
		return stationName;
	}
     ReentrantLock lock = new ReentrantLock();
    ReentrantLock Alock = new ReentrantLock();
    Condition cond = lock.newCondition();
    Track track = new Track(1,1000, trainOnTrack);
	public void trainEnterStation(String stationName, int capacity, int length, int trainOnTrack, int speed) {
		
		lock.lock();
		// If station has capacity check all
		// segment on station and place station
		// on empty segment
		 if(counter<capacity) {
			 if(stationaryTrains[0]==0) {
			stationaryTrains[counter] = trainOnTrack;
			 counter++;}
			 if(stationaryTrains[1]==0) {
					stationaryTrains[1] = trainOnTrack;
			 counter++;}
			 if(stationaryTrains[2]==0) {
					stationaryTrains[2] = trainOnTrack;
			 counter++;}
			 
			 if(stationaryTrains[3]==0) {
					stationaryTrains[3] = trainOnTrack;
		     counter++;}
			 
		}
		 // If station is full wait
		 else if(counter == capacity) {
			try {
			cond.await();
		}catch (InterruptedException e) {
			e.printStackTrace();
		     }
		}
//		cond.signalAll();
//		lock.unlock();
		// Pass values of array to pritstatus 
		// object if they are empty printstatus 
		// will print empty station or segment
		PrintStatus print = new PrintStatus(stationName,
				stationaryTrains[0],
				stationaryTrains[1],
				stationaryTrains[2],
				stationaryTrains[3]);
		System.out.print(print);
		// There is no track after Iverness
		if(!stationName.equals("Iverness")) {
			Random r = new Random();
			int goTrain = r.nextInt(capacity);
			//Random train to leave station
		track.enterTrack(speed,stationaryTrains[goTrain]);
		// Leaving train is arriving train for 
		// new station
		// so set it trainontrack so other 
		// station object can call it
		this.trainOnTrack = stationaryTrains[goTrain];
		// empties track for new train
		stationaryTrains[goTrain]=0;}
		counter =0;
		// As train one random train has left station
		// singnal all threads waiting
		cond.signalAll();
		lock.unlock();
		
		}
	   
	   
	}
	






