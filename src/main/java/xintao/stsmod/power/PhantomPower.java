package xintao.stsmod.power;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import xintao.stsmod.util.CodeUtil;

public class PhantomPower extends AbstractPower
{
    public static final String power_id = CodeUtil.of("Phantom");
    public static final String power_name = "幻象";
    public static final String power_description = "拥有 #y幻象 的实体不能打出有效伤害。回合结束后减少一层 #y幻象 。";
    private static final String path128 = CodeUtil.imgPath("power/Phantom128.png");
    private static final String path48 = CodeUtil.imgPath("power/Phantom48.png");
    private boolean justApplied = false;
    
    public PhantomPower(AbstractCreature owner, int amountNumber)
    {
        super.name = power_name;
        super.ID = power_id;
        super.owner = owner;
        super.amount = amountNumber;
        super.type = PowerType.DEBUFF;
        super.isTurnBased = true;

        super.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        super.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);

        super.updateDescription();
    }

    @Override
    public void updateDescription()
    {
        super.description = power_description;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type)
    {
        return 0;
    }

    @Override
    public void atEndOfRound()
    {
        if (this.justApplied)
        {
            this.justApplied = false;
        }
        else
        {
            if (super.amount == 0)
            {
                super.addToBot(new RemoveSpecificPowerAction(super.owner, super.owner, power_id));
            }
            else
            {
                super.addToBot(new ReducePowerAction(super.owner, super.owner, power_id, 1));
            }

        }
    }
}
