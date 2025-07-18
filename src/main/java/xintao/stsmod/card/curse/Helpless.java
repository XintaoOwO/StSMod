package xintao.stsmod.card.curse;

import basemod.abstracts.CustomCard;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.stsmod.util.CodeUtil;
import xintao.stsmod.util.cardmodifier.UnplayableModifier;

public class Helpless extends CustomCard
{
    // 本卡牌尚未实装，因为卡牌修饰器不能正常工作
    public static final String ID = CodeUtil.of("Helpless");
    private static final String name = "束手无策";
    private static final int cost = -2;
    private static final String description = " * 虚无 。 NL 抽到这张牌时，给所有手牌附加 * 不能被打出 。";
    private static final String img_path = CodeUtil.imgPath("card/curse/bewildered.png");
    private static final CardType type = CardType.CURSE;
    private static final CardColor color = CardColor.CURSE;
    private static final CardRarity rarity = CardRarity.CURSE;
    private static final CardTarget target = CardTarget.NONE;

    public Helpless()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
        
        super.isEthereal = true;
    }

    @Override
    public void triggerWhenDrawn()
    {
        super.triggerWhenDrawn();
        
        super.addToTop(new AbstractGameAction()
        {
            @Override
            public void update()
            {
                super.isDone = true;
                
                for (AbstractCard card : AbstractDungeon.player.hand.group)
                {
                    if (CardModifierManager.hasModifier(card, ID))
                    {
                        CardModifierManager.addModifier(card, new UnplayableModifier());
                    }
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
