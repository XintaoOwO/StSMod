package xintao.stsmod.main;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import xintao.stsmod.util.CodeUtil;

public class Card implements EditCardsSubscriber
{
    // 卡牌类
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
