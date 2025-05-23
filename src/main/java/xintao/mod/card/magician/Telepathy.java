package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Telepathy extends CustomCard
{
    public static final String ID = CodeUtil.of("Telepathy");
    private static final String name = "通灵术";
    private static final int cost = 1;
    private static final String description1 = "";
    private static final String description2 = "";
    private static final String img_path = CodeUtil.imgPath("card/magician/Cheat.png");
    private static final CardType type = CardType.POWER;
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
        
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster)
    {

    }
}
