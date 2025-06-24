package xintao.stsmod.main;

import basemod.BaseMod;
import basemod.interfaces.EditKeywordsSubscriber;
import xintao.stsmod.power.PhantomPower;
import xintao.stsmod.util.CodeUtil;

public class Keyword implements EditKeywordsSubscriber
{
    // 关键字类
    Keyword()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditKeywords()
    {
        // 幻象
        BaseMod.addKeyword(CodeUtil.Mod_ID, PhantomPower.power_name, 
                new String [] {PhantomPower.power_name}, PhantomPower.power_description);
    }
}
