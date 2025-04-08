package xintao.mod.main;

import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.abstracts.CustomRelic;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import xintao.mod.character.Magician;
import xintao.mod.util.CodeUtil;

public class Relic implements EditRelicsSubscriber
{
    Relic()
    {
        BaseMod.subscribe(this);
    }
    
    @Override
    public void receiveEditRelics()
    {
        // This finds and adds all relics inheriting from CustomRelic that are in the same package
        // as MyRelic, keeping all as unseen except those annotated with @AutoAdd.Seen
        new AutoAdd(CodeUtil.Mod_ID)
                .packageFilter(CodeUtil.Mod_Relic_Package + ".magician")
                .any(CustomRelic.class, (info, relic) ->
                        {
                            BaseMod.addRelicToCustomPool(relic, Magician.PlayerColorEnum.Magician_Colour);

                            if (info.seen)
                            {
                                UnlockTracker.markRelicAsSeen(relic.relicId);
                            }
                        }
                );
        
        new AutoAdd(CodeUtil.Mod_ID)
                .packageFilter(CodeUtil.Mod_Relic_Package + ".shared")
                .any(CustomRelic.class, (info, customRelic) ->
                        {
                            BaseMod.addRelic(customRelic, RelicType.SHARED);

                            if (info.seen)
                            {
                                UnlockTracker.markRelicAsSeen(customRelic.relicId);
                            }
                        }
                );
    }
}
