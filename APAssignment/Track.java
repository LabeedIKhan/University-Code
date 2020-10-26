
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class Track {
    protected int capacity;
    protected int length;
    protected int trainOnTrack;
    public Track(int capacity, int length, int trainOnTrack) {
    	this.capacity = capacity;
    	this.length = length;
    	this.trainOnTrack = trainOnTrack;
    }
    public void setTrainOnTrack(int trainOnSegment) {
    	this.trainOnTrack = trainOnSegment;
    }
    public int getTrainOnTrack() {
    	return trainOnTrack;
    }
    public void setLength(int len) {
    	this.length = len;
    }
    public int getLength() {
    	return length;
    }
    public void setCapacity(int cap) {
    	this.capacity = cap;
    }
    public int getCapacity() {
    	return capacity;
    }
    // create lock object of track segment
    ReentrantLock lock = new ReentrantLock();
    Condition lockCond = lock.newCondition();
    // being passed train speed and trainId number
    public void enterTrack(int trainSpeed,int trainId) {
    	String trainOnSegment;
    	if(trainId>0) {
    	    trainOnSegment = Integer.toString(trainId);
    	}else {
    		trainOnSegment = "track";
    	}
    	//int trainOnSegment = trainId;
    	lock.lock();
    	/* Let's assume
    	 * If it is a slow train with speed
    	 * of 10 it would take 4 seconds
    	 * to complete track segment otherwise
    	 * it would cross it in 1 second 
    	*/
    	if(trainSpeed == 10) {
    		try {
    			Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}else {
    		try {
    			Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	System.out.print("|-----"+trainOnSegment+"----|");
    	// As the train has cleared the segment
    	// depending on condition of time
    	// unlock the track segment
    	lock.unlock();
    }
}
