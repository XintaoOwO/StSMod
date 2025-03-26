package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class Core
{
    public static final Logger logger = LogManager.getLogger(Core.class);
    
    public static void initialize()
    {
        new Card();
        new Relic();
        new Character();
        
        logger.info("Mod Initializing...");
    }
}
