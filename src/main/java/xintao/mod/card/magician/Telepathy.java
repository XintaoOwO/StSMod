package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Telepathy extends CustomCard
{
    public static final String ID = CodeUtil.of("Telepathy");
    private static final String name = "通灵术";
    private static final int cost = 1;
    private static final String description1 = "如果目标的意图是攻击，给予目标 !M! 层虚弱。"; // 还没想好具体内容
    private static final String description2 = "";
    private static final String img_path = CodeUtil.imgPath("card/magician/Cheat.png");
    private static final CardType type = CardType.SKILL;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.UNCOMMON;
    private static final CardTarget target = CardTarget.SELF;

    public Telepathy()
    {
        super(ID, name, img_path, cost, description1, type, color, rarity, target);

        super.magicNumber = super.baseMagicNumber = 0;
    }

    @Override
    public void upgrade()
    {
        if (!super.upgraded)
        {
            super.upgradeName();
        }
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster)
    {

    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Telepathy();
    }
}
