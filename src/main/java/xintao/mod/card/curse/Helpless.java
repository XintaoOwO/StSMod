package xintao.mod.card.curse;

import basemod.abstracts.CustomCard;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.util.CodeUtil;
import xintao.mod.util.cardmodifier.UnplayableModifier;

public class Helpless extends CustomCard
{
    public static final String ID = CodeUtil.of("Helpless");
    private static final String name = "束手无策";
    private static final int cost = -2;
    private static final String description = "";
    private static final String img_path = CodeUtil.imgPath("card/magician/Phantom_Attack.png");
    private static final CardType type = CardType.CURSE;
    private static final CardColor color = CardColor.COLORLESS;
    private static final CardRarity rarity = CardRarity.CURSE;
    private static final CardTarget target = CardTarget.NONE;

    public Helpless()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
        
        this.isEthereal = true;
    }

    @Override
    public void triggerWhenDrawn()
    {
        super.triggerWhenDrawn();
        
        this.addToTop(new AbstractGameAction()
        {
            @Override
            public void update()
            {
                this.isDone = true;
                
                for (AbstractCard card : AbstractDungeon.player.hand.group)
                {
                    CardModifierManager.addModifier(card, new UnplayableModifier());
                }
            }
        });
    }

    @Override
    public void upgrade()
    {
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Helpless();
    }
}
