package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Cheat extends CustomCard
{
    public static final String ID = CodeUtil.of("Cheat");
    private static final String name = "出千";
    private static final int cost = 1;
    private static final String description1 = "* 预见 !M! 。 NL 抽2张牌。 NL 丢弃1张牌。";
    private static final String description2 = "* 预见 !M! 。 NL 丢弃任意张牌，并抽等量的牌。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Phantom_Attack.png");
    private static final CardType type = CardType.SKILL;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.RARE;
    private static final CardTarget target = CardTarget.SELF;
    
    public Cheat()
    {
        super(ID, name, img_path, cost, description1, type, color, rarity, target);
        
        this.magicNumber = this.baseMagicNumber = 4;
    }

    @Override
    public void upgrade()
    {
        if (!this.upgraded)
        {
            this.upgradeName();
            this.upgradeMagicNumber(1);
            this.rawDescription = description2;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        this.addToBot(new ScryAction(this.magicNumber));
        
        if (!this.upgraded)
        {
            this.addToBot(new DrawCardAction(player, 2));
            this.addToBot(new DiscardAction(player, player, 1, false));
        }
        else
        {
            if (!AbstractDungeon.player.hand.isEmpty())
            {
                this.addToBot(new GamblingChipAction(AbstractDungeon.player, true));
            }
        }
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Cheat();
    }
}
