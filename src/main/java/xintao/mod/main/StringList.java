package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditStringsSubscriber;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.localization.UIStrings;
import xintao.mod.util.CodeUtil;

public class StringList implements EditStringsSubscriber
{
    // 字符串类，包括游戏的本地化（目前不打算支持除了简体中文外的本地化）
    StringList()
    {
        BaseMod.subscribe(this);
    }

    @Override
    public void receiveEditStrings()
    {
        String lang = "ZHS";
        
        BaseMod.loadCustomStringsFile(RelicStrings.class, CodeUtil.langPath(lang + "/relic.json"));
        BaseMod.loadCustomStringsFile(UIStrings.class, CodeUtil.langPath(lang + "/ui.json"));
    }
}
