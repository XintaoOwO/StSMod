package xintao.mod.main;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;

public class Card implements EditCardsSubscriber
{
    public Card()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditCards()
    {
        new AutoAdd(Core.Mod_ID)
                .packageFilter(Core.Mod_Card_Package)
                .setDefaultSeen(true)
                .cards();
    }
}
