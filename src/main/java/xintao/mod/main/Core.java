package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

@SpireInitializer
public class Core
{
    public static void initialize()
    {
        new Card();
        new Relic();
        new Character();
        new Keyword();
    }
}
