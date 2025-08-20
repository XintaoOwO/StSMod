package xintao.stsmod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.stsmod.character.Magician;
import xintao.stsmod.util.CodeUtil;

public class MiracleTime extends CustomCard // 奇迹时刻
{
    public static final String ID = CodeUtil.of("Miracle_Time");
    private static final String name = "奇迹时刻";
    private static final int cost = 1;
    private static final String description1 = "对全体敌人造成50点伤害。在抽牌堆为空的情况下才能打出。";
    private static final String description2 = "";
    private static final String img_path = CodeUtil.imgPath("card/magician/Cheat.png");
    private static final CardType type = CardType.SKILL;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.UNCOMMON;
    private static final CardTarget target = CardTarget.ALL_ENEMY;

    public MiracleTime()
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
        return new MiracleTime();
    }
}
