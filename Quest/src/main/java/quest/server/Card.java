package quest.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import quest.client.App;

public class Card {
    private static final Logger logger = LogManager.getLogger(App.class);

    public String name;
    protected String imageFilename;

    Card(String paramName, String paramImageFilename)
    {

        name = paramName;
        imageFilename = paramImageFilename;
        logger.info("Successfully called Card: "+ name+" constructor");

    }

    public String getName(){
        logger.info("Returning Card: "+name);
        return name;

    }

    public String getImageFilename(){

        logger.info("Returning Card: "+name+ " image");
        return imageFilename;

    }
}
