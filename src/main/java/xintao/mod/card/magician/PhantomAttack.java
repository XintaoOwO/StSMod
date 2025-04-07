package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.power.PhantomPower;
import xintao.mod.util.CodeUtil;

public class PhantomAttack extends CustomCard
{
    public static final String ID = CodeUtil.of("Phantom_Attack");
    private static final String name = "幻象攻击";
    private static final int cost = 2;
    private static final String description = "造成 !D! 点伤害。 NL 给予目标 !M! 层 * xintaomod:幻象 ，将一张 * 晕眩 放入你的抽牌堆。 NL * 消耗 。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Phantom_Attack.png");
    private static final CardType type = CardType.ATTACK;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.RARE;
    private static final CardTarget target = CardTarget.ENEMY;
    
    public PhantomAttack()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);

        this.damage = this.baseDamage = 8; // 伤害
        this.magicNumber = this.baseMagicNumber = 2; // 特殊值
        this.exhaust = true; // 消耗
        this.cardsToPreview = new Dazed();
    }

    @Override
    public void upgrade()
    {
        if (!this.upgraded)
        {
            this.upgradeName(); // 升级名字绿色带加号
            this.upgradeDamage(4); // 提高伤害
            this.upgradeMagicNumber(1); // 提高特殊值
            this.upgradeBaseCost(1); // 升级后的卡牌费用
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        this.addToBot(new DamageAction(monster, new DamageInfo(player, this.damage, DamageInfo.DamageType.NORMAL)));
        this.addToBot(new ApplyPowerAction(monster, player, new PhantomPower(monster, this.magicNumber), this.magicNumber));
        // 在抽牌堆中加入一张晕眩
        this.addToBot(new MakeTempCardInDrawPileAction(new Dazed(), 1, true, true));
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new PhantomAttack();
    }
}
