package xintao.mod.main;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

/**
 * 作者：xintao
 * GitHub：XintaoOwO
 * Java 8
 * 这是整个模组的主类，注解 @SpireInitializer 在运行时起作用，MtS 会初始化带有该注解的类。
 */
@SpireInitializer
public final class Main
{
    public static void initialize()
    {
        System.out.println("**** Mod Initializing ****");
        System.out.println("**** 模组初始化中 ****");
        
        new Card();
        new Relic();
        new Character();
        new Keyword();
        new StringList();
        
        System.out.println("**** Mod Initialized ****");
        System.out.println("**** 模组已完成初始化任务 ****");
    }
}
