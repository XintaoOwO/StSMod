package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import xintao.mod.card.Strike;

@SpireInitializer
public class Initializer implements EditCardsSubscriber
{
    public Initializer()
    {
        BaseMod.subscribe(this);
    }
    
    public static void initialize()
    {
        new Initializer();
        
        System.out.println("Mod Initializing!");
    }

    @Override
    public void receiveEditCards()
    {
        BaseMod.addCard(new Strike());
    }
}
