package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import xintao.mod.character.Magician;
import xintao.mod.character.MagicianStyle;

public class Character implements EditCharactersSubscriber
{
    public Character()
    {
        BaseMod.subscribe(this);

        BaseMod.addColor
                (
                        Magician.PlayerColorEnum.Magician_Colour, // 卡牌颜色
                        MagicianStyle.colour,
                        MagicianStyle.colour,
                        MagicianStyle.colour,
                        MagicianStyle.colour,
                        MagicianStyle.colour,
                        MagicianStyle.colour,
                        MagicianStyle.colour, 
                        MagicianStyle.BG_ATTACK_512,
                        MagicianStyle.BG_SKILL_512,
                        MagicianStyle.BG_POWER_512,
                        MagicianStyle.ENEYGY_ORB, 
                        MagicianStyle.BG_ATTACK_1024, 
                        MagicianStyle.BG_SKILL_1024, 
                        MagicianStyle.BG_POWER_1024, 
                        MagicianStyle.BIG_ORB, 
                        MagicianStyle.SMALL_ORB
                );
    }
    
    @Override
    public void receiveEditCharacters()
    {
        BaseMod.addCharacter(new Magician(CardCrawlGame.playerName), MagicianStyle.MY_CHARACTER_BUTTON, MagicianStyle.MY_CHARACTER_PORTRAIT, Magician.PlayerColorEnum.Magician_Character);
    }
}
