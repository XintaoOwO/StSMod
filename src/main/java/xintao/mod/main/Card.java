package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import xintao.mod.card.Strike;

public class Card implements EditCardsSubscriber
{
    public Card()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditCards()
    {
        BaseMod.addCard(new Strike());
    }
}
