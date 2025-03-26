package xintao.mod.main;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import xintao.mod.character.Magician;

import static xintao.mod.character.Magician.PlayerColorEnum.MY_CHARACTER;
import static xintao.mod.character.MagicianStyle.MY_CHARACTER_BUTTON;
import static xintao.mod.character.MagicianStyle.MY_CHARACTER_PORTRAIT;

public class Character implements EditCharactersSubscriber
{
    public Character()
    {
        BaseMod.subscribe(this);
    }
    
    @Override
    public void receiveEditCharacters()
    {
        BaseMod.addCharacter(new Magician(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, MY_CHARACTER);
    }
}
