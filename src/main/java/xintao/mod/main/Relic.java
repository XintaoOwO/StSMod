package xintao.mod.main;

import basemod.BaseMod;
import basemod.helpers.RelicType;
import basemod.interfaces.EditRelicsSubscriber;
import xintao.mod.relic.magician.MagicStick;

public class Relic implements EditRelicsSubscriber
{
    public Relic()
    {
        BaseMod.subscribe(this);
    }
    
    @Override
    public void receiveEditRelics()
    {
        BaseMod.addRelic(new MagicStick(), RelicType.SHARED);
        
        /*
        // This finds and adds all relics inheriting from CustomRelic that are in the same package
        // as MyRelic, keeping all as unseen except those annotated with @AutoAdd.Seen
        new AutoAdd(Core.Mod_ID)
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
                
         */
    }
}
