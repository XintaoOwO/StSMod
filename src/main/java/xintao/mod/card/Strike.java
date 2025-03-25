package xintao.mod.card;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Strike extends CustomCard
{
    public static final String ID = "xintaomod:Strike";
    private static final String name = "打击";
    private static final int cost = 1;
    private static final String description = "造成 !D! 点伤害。";
    private static final String img_path = "";
    private static final CardType type = CardType.ATTACK;
    private static final CardColor color = CardColor.COLORLESS;
    private static final CardRarity rarity = CardRarity.BASIC;
    private static final CardTarget target = CardTarget.ENEMY;
    
    public Strike()
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
