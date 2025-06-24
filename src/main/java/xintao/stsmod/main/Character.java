package xintao.stsmod.main;

import basemod.BaseMod;
import basemod.interfaces.EditCharactersSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import xintao.stsmod.character.Magician;
import xintao.stsmod.util.CodeUtil;

public class Character implements EditCharactersSubscriber
{
    // 角色类
    // 角色颜色
    public static final Color Magician_colour = new Color(240.0f / 255.0f, 155.0f / 255.0f, 89.0f / 255.0f, 1.0f);
    // 人物选择界面按钮的图片
    private static final String Magician_CHARACTER_BUTTON = CodeUtil.imgPath("char/Character_Button.png");
    // 人物选择界面的立绘
    private static final String Magician_CHARACTER_PORTRAIT = CodeUtil.imgPath("char/Character_Portrait.jpg");
    // 攻击牌的背景（小尺寸）
    private static final String Magician_BG_ATTACK_512 = CodeUtil.imgPath("bg512/bg_attack_512.png");
    // 能力牌的背景（小尺寸）
    private static final String Magician_BG_POWER_512 = CodeUtil.imgPath("bg512/bg_power_512.png");
    // 技能牌的背景（小尺寸）
    private static final String Magician_BG_SKILL_512 = CodeUtil.imgPath("bg512/bg_skill_512.png");
    // 在卡牌和遗物描述中的能量图标
    private static final String Magician_SMALL_ORB = CodeUtil.imgPath("char/small_orb.png");
    // 攻击牌的背景（大尺寸）
    private static final String Magician_BG_ATTACK_1024 = CodeUtil.imgPath("bg1024/bg_attack.png");
    // 能力牌的背景（大尺寸）
    private static final String Magician_BG_POWER_1024 = CodeUtil.imgPath("bg1024/bg_power.png");
    // 技能牌的背景（大尺寸）
    private static final String Magician_BG_SKILL_1024 = CodeUtil.imgPath("bg1024/bg_skill.png");
    // 在卡牌预览界面的能量图标
    private static final String Magician_BIG_ORB = CodeUtil.imgPath("char/card_orb.png");
    // 小尺寸的能量图标（战斗中，牌堆预览）
    private static final String Magician_ENEYGY_ORB = CodeUtil.imgPath("char/cost_orb.png");
    
    Character()
    {
        BaseMod.subscribe(this);

        BaseMod.addColor
                (
                        Magician.PlayerColorEnum.Magician_Colour, // 卡牌颜色
                        Magician_colour,
                        Magician_colour,
                        Magician_colour,
                        Magician_colour,
                        Magician_colour,
                        Magician_colour,
                        Magician_colour,
                        Magician_BG_ATTACK_512,
                        Magician_BG_SKILL_512,
                        Magician_BG_POWER_512,
                        Magician_ENEYGY_ORB,
                        Magician_BG_ATTACK_1024,
                        Magician_BG_SKILL_1024, 
                        Magician_BG_POWER_1024,
                        Magician_BIG_ORB,
                        Magician_SMALL_ORB
                );
    }
    
    @Override
    public void receiveEditCharacters()
    {
        BaseMod.addCharacter(new Magician(CardCrawlGame.playerName), Magician_CHARACTER_BUTTON, Magician_CHARACTER_PORTRAIT, Magician.PlayerColorEnum.Magician_Character);
    }
}
