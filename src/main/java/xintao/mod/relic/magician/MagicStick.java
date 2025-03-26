package xintao.mod.relic.magician;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import xintao.mod.util.CodeUtil;

public class MagicStick extends CustomRelic
{
    public static final String ID = CodeUtil.of("Magic_Stick");
    private static final String img_path = CodeUtil.imgPath("relic/Magic_Stick.png");
    private static final RelicTier tier = RelicTier.STARTER;
    private static final String description = "每次战斗开始时，";
    
    public MagicStick(String id, String imgName, RelicTier tier, LandingSound sfx)
    {
        super(id, imgName, tier, sfx);
    }
    
    public String getDescription()
    {
        return description;
    }

    @Override
    public void atBattleStart()
    {
        super.atBattleStart();
        
        this.addToBot(new DrawCardAction(1));
    }
}
