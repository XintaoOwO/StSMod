package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.util.CodeUtil;

public class Defend_Magician extends CustomCard
{
    public static final String ID = CodeUtil.of("Defend_Magician");
    private static final String name = "防御";
    private static final int cost = 1;
    private static final String description = "获得 !B! 点格挡。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Strike.png");
    private static final CardType type = CardType.SKILL;
    private static final CardColor color = CardColor.COLORLESS;
    private static final CardRarity rarity = CardRarity.BASIC;
    private static final CardTarget target = CardTarget.ENEMY;

    public Defend_Magician()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
    }

    @Override
    public void upgrade()
    {
        
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster)
    {

    }
}
