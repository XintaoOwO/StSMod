package xintao.mod.main;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import xintao.mod.util.CodeUtil;

public class Card implements EditCardsSubscriber
{
    Card()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditCards()
    {
        new AutoAdd(CodeUtil.Mod_ID)
                .packageFilter(CodeUtil.Mod_Card_Package)
                .setDefaultSeen(true)
                .cards();
    }
}
