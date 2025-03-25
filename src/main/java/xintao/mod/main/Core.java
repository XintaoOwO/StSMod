package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import xintao.mod.character.Character;

@SpireInitializer
public class Core
{
    public static void initialize()
    {
        new Card();
        new Character();
        
        System.out.println("Mod Initializing!");
    }
}
