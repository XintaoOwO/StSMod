package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Defend_Magician extends CustomCard
{
    public static final String ID = CodeUtil.of("Defend_Magician");
    private static final String name = "防御";
    private static final int cost = 1;
    private static final String description = "获得 !B! 点格挡。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Defend_Magician.png");
    private static final CardType type = CardType.SKILL;
    //private static final CardColor color = CardColor.COLORLESS;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.BASIC;
    private static final CardTarget target = CardTarget.SELF;

    public Defend_Magician()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
        
        this.block = this.baseBlock = 5;
        this.tags.add(CardTags.STARTER_DEFEND);
    }

    @Override
    public void upgrade()
    {
        if (!this.upgraded)
        {
            this.upgradeName();
            this.upgradeBlock(3);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        if (Settings.isDebug)
        {
            this.addToBot(new GainBlockAction(player, player, 50));
        }
        else
        {
            this.addToBot(new GainBlockAction(player, player, this.block));
        }
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Defend_Magician();
    }
}
