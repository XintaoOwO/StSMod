package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditKeywordsSubscriber;
import xintao.mod.power.Phantom;
import xintao.mod.util.CodeUtil;

public class Keyword implements EditKeywordsSubscriber
{
    public Keyword()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditKeywords()
    {
        // 幻象
        BaseMod.addKeyword(CodeUtil.Mod_ID, Phantom.power_name, 
                new String [] {Phantom.power_name}, Phantom.power_description);
    }
}
