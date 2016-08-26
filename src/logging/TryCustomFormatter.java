package logging;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class TryCustomFormatter {
	private static Logger logger = Logger.getLogger("logging.tryCustomFormatter");

	public static void main(String[] args) {
		logger.setUseParentHandlers(false);
		Handler conHandlr = new ConsoleHandler();
		
		conHandlr.setFormatter(new Formatter() {
			
			@Override
			public String format(LogRecord record) {
				return record.getLevel() + "-:-" +
						record.getSourceClassName() + "--:--" +
						record.getSourceMethodName() + "--:--" +
						record.getMessage() + "\n";
			}
		});
		
		logger.setFilter(new Filter() {
			
			@Override
			public boolean isLoggable(LogRecord record) {
				if(record.getLevel()== Level.SEVERE){
					return true;
				}
				return false;
			}
		});
		
		logger.addHandler(conHandlr);
		logger.setLevel(Level.INFO);
		
		
		//Log an info tracing message
		logger.info("doing stuff");
		
		logMessages();
	
		logger.info("done");
		
		LogManager logManager = LogManager.getLogManager();
		try{
			logManager.readConfiguration(null);
		}catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public static void logMessages(){
		try{
			System.out.println(3/0);
		}catch (Exception ex){
			//logger.log(Level.SEVERE, "dividing by zero", ex);
			logger.log(Level.SEVERE, "dividing by zero");
		}
		
	}

}
