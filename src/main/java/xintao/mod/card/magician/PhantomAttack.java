package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.power.Phantom;
import xintao.mod.util.CodeUtil;

public class PhantomAttack extends CustomCard
{
    public static final String ID = CodeUtil.of("Phantom_Attack");
    private static final String name = "幻象攻击";
    private static final int cost = 2;
    private static final String description = "造成 !D! 点伤害，给予目标 !M! 层 *幻象 。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Phantom_Attack.png");
    private static final CardType type = CardType.ATTACK;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.UNCOMMON;
    private static final CardTarget target = CardTarget.ENEMY;
    
    public PhantomAttack()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);

        this.damage = this.baseDamage = 8;
        this.magicNumber = this.baseMagicNumber = 2;
    }

    @Override
    public void upgrade()
    {
        if (!this.upgraded)
        {
            this.upgradeName();
            this.upgradeDamage(4);
            this.upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        this.addToBot(new DamageAction(monster, new DamageInfo(player, this.damage, DamageInfo.DamageType.NORMAL)));
        this.addToBot(new ApplyPowerAction(monster, player, new Phantom(monster, this.magicNumber), this.magicNumber));
    }
}
