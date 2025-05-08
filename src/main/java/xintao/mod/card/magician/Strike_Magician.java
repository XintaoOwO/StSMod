package xintao.mod.card.magician;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Strike_Magician extends CustomCard
{
    public static final String ID = CodeUtil.of("Strike_Magician");
    private static final String name = "打击";
    private static final int cost = 1;
    private static final String description = "造成 !D! 点伤害。";
    private static final String img_path = CodeUtil.imgPath("card/magician/Strike_Magician.png");
    private static final CardType type = CardType.ATTACK;
    private static final CardColor color = Magician.PlayerColorEnum.Magician_Colour;
    private static final CardRarity rarity = CardRarity.BASIC;
    private static final CardTarget target = CardTarget.ENEMY;
    
    public Strike_Magician()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
        
        super.damage = super.baseDamage = 6;
        super.tags.add(CardTags.STRIKE);
        super.tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    public void upgrade()
    {
        if (!super.upgraded)
        {
            super.upgradeName();
            super.upgradeDamage(3);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager
                .addToBottom(new DamageAction(monster, new DamageInfo(player, super.damage, DamageInfo.DamageType.NORMAL)));
    }

    @Override
    public AbstractCard makeCopy()
    {
        return new Strike_Magician();
    }
}
