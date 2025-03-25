package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xintao.mod.character.Character;

@SpireInitializer
public class Core
{
    public static final Logger logger = LogManager.getLogger(Core.class);
    
    public static void initialize()
    {
        new Card();
        new Character();
        
        logger.info("Mod Initializing...");
    }
}
