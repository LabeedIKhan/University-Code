
public class Runme {
	  /*
	   * The program starts by creating an
	   * object that start the process of
	   * creating train in CreateTrain class
	   * and starts a thread so it runs on it's
	   * own thread. 
	   */
   public static void main(String[] args) {
	   // Note createTrain has been given some
	   // values here, they are just to make it
	   // run they play no part is creating train.
	  CreateTrain c = new CreateTrain(0, 0, "", 0);
	  Thread t = new Thread(c);
	  t.start();
	  /* Deficiencies:
	   * Note the main deficiency in the program 
	   * is that in train class every train creates
	   * a new station object which causes some condition
	   * to not work properly, it can be solved by creating 
	   * a rail network class which define network of railway
	   * and stations and their properties. 
	   * The second deficiency is linked to first one as condition
	   * are not working as expected is hard to control printing 
	   * though solving first problem should solve this but 
	   * this can be solved independently by running printing
	   * on it own thread. 
	   * Doing that will cause train not to be shown 
	   * exactly after station but on next line 
	   * for example
	   * |-------Glasgow-15-----||----15---|...
	   * to this 
	   * |-------Glasgow--15----||--------|...
	   * |-------Glasgow--------||---15---|...
	   */
   }
}
       
