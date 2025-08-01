package xintao.stsmod.relic.magician;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import xintao.stsmod.util.CodeUtil;

public class MagicStick extends CustomRelic
{
    public static final String ID = CodeUtil.of("Magic_Stick");
    private static final String img_path = CodeUtil.imgPath("relic/Magic_Stick.png");
    private static final String outline_img_path = CodeUtil.imgPath("relic/Magic_Stick_Outline.png");
    private static final RelicTier tier = RelicTier.STARTER;
    private static final LandingSound landing_sound = LandingSound.FLAT;
    private static final Texture texture = new Texture(img_path);
    private static final Texture texture_outline = new Texture(outline_img_path);
    
    public MagicStick()
    {
        super(ID, texture, texture_outline, tier, landing_sound);
    }

    @Override
    public String getUpdatedDescription()
    {
        return this.DESCRIPTIONS[0];
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
