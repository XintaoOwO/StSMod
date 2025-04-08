package xintao.mod.relic.shared;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.rooms.EventRoom;
import xintao.mod.util.CodeUtil;

public class QuestionMark extends CustomRelic
{
    public static final String ID = CodeUtil.of("Question_Mark");
    private static final String img_path = CodeUtil.imgPath("relic/question_card.png");
    private static final String outline_img_path = CodeUtil.imgPath("relic/question_card_out.png");
    private static final RelicTier tier = RelicTier.UNCOMMON;
    private static final LandingSound landing_sound = LandingSound.FLAT;
    private static final Texture texture = new Texture(img_path);
    private static final Texture texture_outline = new Texture(outline_img_path);

    public QuestionMark()
    {
        super(ID, texture, texture_outline, tier, landing_sound);
    }

    @Override
    public void onEnterRoom(AbstractRoom room)
    {
        if (room instanceof EventRoom)
        {
            this.flash();
            
            AbstractDungeon.player.heal(5);
        }
    }

    @Override
    public String getUpdatedDescription()
    {
        return super.DESCRIPTIONS[0];
    }

    @Override
    public AbstractRelic makeCopy()
    {
        return new QuestionMark();
    }
}
