package me.doapps.igvperu.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Bryam on 20/01/2015.
 */
public class UtilFonts {
    public static Typeface setLatoBolt(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Bol.ttf");
    }
    public static Typeface setLatoLig(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Lig.ttf");
    }
    public static Typeface setLatoReg(Context context){
        return Typeface.createFromAsset(context.getAssets(), "fonts/Lato-Reg.ttf");
    }
}