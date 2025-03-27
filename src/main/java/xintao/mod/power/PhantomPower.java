package xintao.mod.power;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import xintao.mod.util.CodeUtil;

public class PhantomPower extends AbstractPower
{
    public static final String power_id = CodeUtil.of("Phantom");
    public static final String power_name = "幻象";
    public static final String power_description = "拥有 #yxintaomod:幻象 的实体不能打出有效伤害。回合结束后减少一层 #yxintaomod:幻象 。";
    private static final String path128 = CodeUtil.imgPath("power/Phantom128.png");
    private static final String path48 = CodeUtil.imgPath("power/Phantom48.png");
    private boolean justApplied = false;
    
    public PhantomPower(AbstractCreature owner, int amountNumber)
    {
        this.name = power_name;
        this.ID = power_id;
        this.owner = owner;
        this.amount = amountNumber;
        this.type = PowerType.DEBUFF;
        this.isTurnBased = true;
        
        this.region128 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path128), 0, 0, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(ImageMaster.loadImage(path48), 0, 0, 32, 32);
        
        this.updateDescription();
    }

    @Override
    public void updateDescription()
    {
        this.description = power_description;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type)
    {
        if (type == DamageInfo.DamageType.NORMAL)
        {
            return 0;
        }
        else 
            return damage;
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
            if (this.amount == 0)
            {
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, power_id));
            }
            else
            {
                this.addToBot(new ReducePowerAction(this.owner, this.owner, power_id, 1));
            }

        }
    }
}
