package xintao.mod.character;

import com.badlogic.gdx.graphics.Color;
import xintao.mod.util.CodeUtil;

public class MagicianStyle
{
    public static final Color colour = new Color(95.0f / 255.0f, 194.0f / 255.0f, 1.0f, 1.0f);
    // 人物选择界面按钮的图片
    public static final String MY_CHARACTER_BUTTON = CodeUtil.imgPath("char/Character_Button.png");
    // 人物选择界面的立绘
    public static final String MY_CHARACTER_PORTRAIT = CodeUtil.imgPath("char/Character_Portrait.jpg");
    // 攻击牌的背景（小尺寸）
    public static final String BG_ATTACK_512 = CodeUtil.imgPath("bg512/bg_attack_512.png");
    // 能力牌的背景（小尺寸）
    public static final String BG_POWER_512 = CodeUtil.imgPath("bg512/bg_power_512.png");
    // 技能牌的背景（小尺寸）
    public static final String BG_SKILL_512 = CodeUtil.imgPath("bg512/bg_skill_512.png");
    // 在卡牌和遗物描述中的能量图标
    public static final String SMALL_ORB = CodeUtil.imgPath("char/small_orb.png");
    // 攻击牌的背景（大尺寸）
    public static final String BG_ATTACK_1024 = CodeUtil.imgPath("bg1024/bg_attack.png");
    // 能力牌的背景（大尺寸）
    public static final String BG_POWER_1024 = CodeUtil.imgPath("bg1024/bg_power.png");
    // 技能牌的背景（大尺寸）
    public static final String BG_SKILL_1024 = CodeUtil.imgPath("bg1024/bg_skill.png");
    // 在卡牌预览界面的能量图标
    public static final String BIG_ORB = CodeUtil.imgPath("char/card_orb.png");
    // 小尺寸的能量图标（战斗中，牌堆预览）
    public static final String ENEYGY_ORB = CodeUtil.imgPath("char/cost_orb.png");
}
