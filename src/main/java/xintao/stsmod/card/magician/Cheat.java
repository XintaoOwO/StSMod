package xintao.stsmod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.actions.utility.ScryAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.stsmod.character.Magician;
import xintao.stsmod.util.CodeUtil;

public class Cheat extends CustomCard // 出千
{
    public static final String ID = CodeUtil.of("Cheat");
    private static final String name = "出千";
    private static final int cost = 1;
    private static final String description1 = "* 预见 !M! 。 NL 抽2张牌。 NL 丢弃1张牌。";
    private static final String description2 = "* 预见 !M! 。 NL 抽2张牌。 NL 丢弃任意张牌，并抽等量的牌。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Cheat.png");
    private static final CardType type = CardType.SKILL;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.UNCOMMON;
    private static final CardTarget target = CardTarget.SELF;
    
    public Cheat()
    {
        super(ID, name, img_path, cost, description1, type, color, rarity, target);
        
        super.magicNumber = super.baseMagicNumber = 3;
    }

    @Override
    public void upgrade()
    {
        if (!super.upgraded)
        {
            super.upgradeName();
            super.upgradeMagicNumber(2);
            super.rawDescription = description2;
            super.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        super.addToBot(new ScryAction(super.magicNumber));
        
        if (!super.upgraded)
        {
            super.addToBot(new DrawCardAction(player, 2));
            super.addToBot(new DiscardAction(player, player, 1, false));
        }
        else
        {
            super.addToBot(new DrawCardAction(player, 2));
            
            if (!AbstractDungeon.player.hand.isEmpty())
            {
                super.addToBot(new GamblingChipAction(AbstractDungeon.player, true));
            }
        }
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Cheat();
    }
}
