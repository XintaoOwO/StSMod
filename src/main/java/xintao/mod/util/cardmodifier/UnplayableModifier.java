package xintao.mod.util.cardmodifier;

import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;

@AbstractCardModifier.SaveIgnore
public class UnplayableModifier extends AbstractCardModifier
{
    public static final String ID = "xintaomod:UnplayableModifier";
    private static final UIStrings STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    
    public UnplayableModifier()
    {
        
    }

    @Override
    public String modifyDescription(String rawDescription, AbstractCard card)
    {
        return String.format(STRINGS.TEXT[0], rawDescription);
    }

    @Override
    public String identifier(AbstractCard card)
    {
        return ID;
    }

    @Override
    public AbstractCardModifier makeCopy()
    {
        return new UnplayableModifier();
    }
}
