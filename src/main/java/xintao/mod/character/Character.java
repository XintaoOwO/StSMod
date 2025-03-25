package xintao.mod.character;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.megacrit.cardcrawl.core.CardCrawlGame;

import static xintao.mod.character.MyCharacter.PlayerColorEnum.MY_CHARACTER;
import static xintao.mod.character.MyCharacterStyle.MY_CHARACTER_BUTTON;
import static xintao.mod.character.MyCharacterStyle.MY_CHARACTER_PORTRAIT;

public class Character implements EditCharactersSubscriber
{
    public Character()
    {
        BaseMod.subscribe(this);
    }
    
    @Override
    public void receiveEditCharacters()
    {
        BaseMod.addCharacter(new MyCharacter(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, MY_CHARACTER);
    }
}
