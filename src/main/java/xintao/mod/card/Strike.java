package xintao.mod.card;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import xintao.mod.util.CodeUtil;

public class Strike extends CustomCard
{
    public static final String ID = CodeUtil.of("Strike");
    private static final String name = "打击";
    private static final int cost = 1;
    private static final String description = "造成 !D! 点伤害。";
    private static final String img_path = CodeUtil.path("Strike");
    private static final CardType type = CardType.ATTACK;
    private static final CardColor color = CardColor.COLORLESS;
    private static final CardRarity rarity = CardRarity.BASIC;
    private static final CardTarget target = CardTarget.ENEMY;
    
    public Strike()
    {
        super(ID, name, img_path, cost, description, type, color, rarity, target);
        
        this.damage = this.baseDamage = 6;
        this.tags.add(CardTags.STRIKE);
        this.tags.add(CardTags.STARTER_STRIKE);
    }

    @Override
    public void upgrade()
    {
        if (!this.upgraded)
        {
            this.upgradeName();
            this.upgradeDamage(3);
        }
    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster)
    {
        AbstractDungeon.actionManager
                .addToBottom(new DamageAction(monster, new DamageInfo(player, damage, DamageInfo.DamageType.NORMAL)));
    }
}
