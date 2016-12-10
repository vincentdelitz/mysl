package se.kth.ict.mysl;

import android.graphics.Bitmap;

/**
 * Created by Vincent on 09.12.2016.
 */

public class DataHolder {

    private static String mail = "delitz@kth.se";
    private static String name = "Vincent Delitz";
    private static Bitmap profilepic;

    public static Bitmap getProfilepic() {
        return profilepic;
    }

    public static void setProfilepic(Bitmap profilepic) {
        DataHolder.profilepic = profilepic;
    }



    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        DataHolder.name = name;
    }

    public static void setMail(String mail) {
        DataHolder.mail = mail;
    }



    public static String getMail() {
        return mail;
    }





}
