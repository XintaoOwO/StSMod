package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditStringsSubscriber;
import com.megacrit.cardcrawl.localization.RelicStrings;
import xintao.mod.util.CodeUtil;

public class StringList implements EditStringsSubscriber
{
    StringList()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditStrings()
    {
        String lang = "ZHS";
        
        BaseMod.loadCustomStringsFile(RelicStrings.class, CodeUtil.langPath(lang + "relic.json"));
    }
}
