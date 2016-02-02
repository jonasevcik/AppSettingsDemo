package cz.droidboy.preferencesdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author Jonas Sevcik
 */
public class Settings {

    private static Settings sInstance;

    private Context mContext;
    private SharedPreferences mPrefs;

    private Settings(Context context) {
        mContext = context.getApplicationContext();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public static Settings getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Settings(context);
        }
        return sInstance;
    }

    public boolean isEnableSocialRecommendation() {
        return mPrefs.getBoolean(mContext.getString(R.string.pref_example_switch), Boolean.parseBoolean(mContext.getString(R.string.pref_example_switch_default)));
    }

    public String getDisplayName() {
        return mPrefs.getString(mContext.getString(R.string.pref_example_text), mContext.getString(R.string.pref_default_display_name));
    }

    public int getAddFriendsToMessages() {
        String stringValue = mPrefs.getString(mContext.getString(R.string.pref_example_list), mContext.getString(R.string.pref_example_list_defaut));
        return Integer.parseInt(stringValue);
    }
}
