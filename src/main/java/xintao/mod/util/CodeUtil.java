package xintao.mod.util;

import xintao.mod.main.Core;

public final class CodeUtil
{
    public static String of(String id)
    {
        return Core.Mod_ID + ":" + id;
    }

    public static String imgPath(String path)
    {
        return Core.Mod_Img_Path + path;
    }
}
