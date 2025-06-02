package xintao.mod.util;

public final class CodeUtil
{
    public static final String Mod_ID = "xintaomod";
    public static final String Mod_Package = "xintao.mod";
    public static final String Mod_Resource_Path = "xintao/xintao_sts_mod_resource";
    public static final String Mod_Card_Package = Mod_Package + ".card";
    public static final String Mod_Relic_Package = Mod_Package + ".relic";
    public static final String Mod_Char_Package = Mod_Package + ".character";
    private static final String Mod_Img_Path = Mod_Resource_Path + "/img/";
    private static final String Mod_Lang_Path = Mod_Resource_Path + "/lang/";
    
    public static String of(String id)
    {
        return Mod_ID + ":" + id;
    }

    public static String imgPath(String path)
    {
        return Mod_Img_Path + path;
    }
    
    public static String langPath(String path)
    {
        return Mod_Lang_Path + path;
    }
}
