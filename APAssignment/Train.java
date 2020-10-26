import java.util.ArrayList;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Train implements Runnable {
	   private String category;
	   private int speed;
	   private static int trainId;
	   public Train(String category,int speed,int trainId) {
		   this.category = category;
		   this.speed = speed;
		   this.trainId = trainId;
  }
	   public void setCateogry(String category) {
		   this.category = category;
	   }
	   public void setSpeed(int speed) {
		   this.speed = speed;
	   }
	   public void setId(int Id) {
		   this.trainId = Id;
	   }
	   public String getCategory() {
		   return category;
	   }
	   public int getSpeed() {
		   return speed;
	   }
	   public int getId() {
		   return trainId;
	   }
	   // ArrayList object so every station can
	   // it own arraylist
	   // station objects
	   final Station s = new Station("Glasgow", 3, 100, trainId,speed);
	   final Station s1 = new Station("Perth", 2, 100, trainId,speed);
	   final Station s2 = new Station("Striling", 2, 100, trainId,speed);
	   final Station s3 = new Station("Iverness", 4, 100, trainId,speed);
	   
	@Override
	public void run() {
		// Pass train to Station objects
		s.trainEnterStation(s.getStationName(),s.capacity,s.length,trainId,speed);
		trainenterStation2();
	   }
		public void trainenterStation2() {
			/* Next station would only
			 * Have train arrving from 
			 * previous station  
			 */
		s1.trainEnterStation(s1.getStationName(),s1.capacity,s1.length,s1.getTrainOnTrack(),speed);
		trainenterStation3();
		}
		public void trainenterStation3() {
		s2.trainEnterStation(s2.getStationName(),s2.capacity,s2.length,s2.getTrainOnTrack(),speed);
		trainenterstation4();
		}
		public void trainenterstation4() {
		s3.trainEnterStation(s3.getStationName(),s3.capacity,s3.length,s3.getTrainOnTrack(),speed);
		System.out.println("\n");
		}
	}


