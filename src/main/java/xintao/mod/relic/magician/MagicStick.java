package xintao.mod.relic.magician;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import xintao.mod.util.CodeUtil;

public class MagicStick extends CustomRelic
{
    public static final String ID = CodeUtil.of("Magic_Stick");
    private static final String img_path = CodeUtil.imgPath("relic/magic_stick.png");
    private static final RelicTier tier = RelicTier.STARTER;
    private static final String description = "每次战斗开始时，";
    private static final LandingSound landing_sound = LandingSound.FLAT;
    private static final Texture texture = new Texture(img_path);
    
    public MagicStick()
    {
        super(ID, texture, tier, landing_sound);
    }

    @Override
    public String getUpdatedDescription()
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
