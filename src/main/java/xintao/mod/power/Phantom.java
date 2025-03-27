package xintao.mod.power;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import xintao.mod.util.CodeUtil;

public class Phantom extends AbstractPower
{
    public static final String power_id = CodeUtil.of("Phantom");
    public static final String power_name = "幻象";
    public static final String power_description = "拥有 #y幻象 的实体在攻击时会受到本次攻击的50%的伤害。回合结束后减少一层 #y幻象 。";
    private static final String path128 = CodeUtil.imgPath("power/Phantom128.png");
    private static final String path48 = CodeUtil.imgPath("power/Phantom48.png");
    private boolean justApplied = false;
    
    public Phantom(AbstractCreature owner, int amountNumber)
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
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount)
    {
        if (damageAmount > 0)
        {
            this.addToTop(new ReducePowerAction(this.owner, this.owner, this.ID, 1));
        }
        
        return 0;
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount)
    {
        if (info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != null && info.owner != this.owner)
        {
            this.flash();
            
            this.addToTop(new DamageAction(
                    info.owner, 
                    new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), 
                    AbstractGameAction.AttackEffect.SLASH_HORIZONTAL, 
                    true));
        }

        return damageAmount;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type)
    {
        if (type == DamageInfo.DamageType.NORMAL)
        {
            return damage * 0.5f;
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
