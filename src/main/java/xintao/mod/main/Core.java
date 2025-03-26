package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpireInitializer
public class Core
{
    public static final String Mod_ID = "xintaomod";
    public static final String Mod_Package = "xintao.mod";
    public static final String Mod_Path = "xintao/mod";
    public static final String Mod_Img_Path = Mod_Path + "/img/";
    public static final String Mod_Card_Package = Mod_Package + ".card";
    public static final String Mod_Relic_Package = Mod_Package + ".relic";
    public static final String Mod_Char_Package = Mod_Package + ".character";
    
    public static final Logger logger = LogManager.getLogger(Core.class);
    
    public static void initialize()
    {
        new Card();
        new Relic();
        new Character();
        
        logger.info("Mod Initializing...");
    }
}
