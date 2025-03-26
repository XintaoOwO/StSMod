package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditKeywordsSubscriber;
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
        BaseMod.addKeyword(CodeUtil.Mod_ID, "幻象", 
                new String [] {"幻象"}, "拥有 #y幻象 的实体在攻击时会受到本次攻击的50%的伤害。回合结束后减少一层 #y幻象 。");
    }
}
