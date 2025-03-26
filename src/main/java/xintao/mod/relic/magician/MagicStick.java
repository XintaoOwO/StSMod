package xintao.mod.relic.magician;

import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import xintao.mod.util.CodeUtil;

public class MagicStick extends CustomRelic
{
    public static final String ID = CodeUtil.of("Magic_Stick");
    private static final String img_path = CodeUtil.imgPath("relic/Magic_Stick.png");
    private static final RelicTier tier = RelicTier.STARTER;
    private static final String description = "每次战斗开始时，";
    private static final LandingSound landing_sound = LandingSound.FLAT;
    
    public MagicStick()
    {
        super(ID, ImageMaster.loadImage(img_path), tier, landing_sound);
    }
    
    public String getDescription()
    {
        return description;
    }
    
    @Override
    public AbstractRelic makeCopy()
    {
        return new MagicStick();
    }

    @Override
    public void atBattleStart()
    {
        super.atBattleStart();
        
        this.addToBot(new DrawCardAction(1));
    }
}
