package logging;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("all")
public class SimpleLoggingExamples {
	private static Logger logger = Logger.getLogger("logging.simpleLogging");

	public static void main(String[] args) {
		try{
			FileHandler fh = new FileHandler("myLog.xml");
			logger.addHandler(new FileHandler("src.logging.myLog.xml"));
		}catch (Exception ex){
			
		}
		
		
		//Set the logging level...
		logger.setLevel(Level.INFO);
		
		//Log an info tracing message
		logger.info("doing stuff");
		try{
			System.out.println(3/0);
		}catch (Exception ex){
			//logger.log(Level.SEVERE, "dividing by zero", ex);
			logger.log(Level.SEVERE, "dividing by zero");
		}
		logger.info("done");
	}

}
