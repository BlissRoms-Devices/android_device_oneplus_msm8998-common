/*
 * Copyright (C) 2015 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnirom.device.utils;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.PreferenceManager;

public class Constants {

    // Alert slider
    public static final String NOTIF_SLIDER_PANEL_KEY = "notification_slider";
    public static final String NOTIF_SLIDER_USAGE_KEY = "slider_usage";
    public static final String NOTIF_SLIDER_ACTION_TOP_KEY = "action_top_position";
    public static final String NOTIF_SLIDER_ACTION_MIDDLE_KEY = "action_middle_position";
    public static final String NOTIF_SLIDER_ACTION_BOTTOM_KEY = "action_bottom_position";

    // Alert slider nodes
    public static final String NOTIF_SLIDER_NODE = "/sys/class/switch/tri-state-key/state";

    public static final String NOTIF_SLIDER_FOR_NOTIFICATION = "1";
    public static final String NOTIF_SLIDER_FOR_FLASHLIGHT = "2";
    public static final String NOTIF_SLIDER_FOR_BRIGHTNESS = "3";
    public static final String NOTIF_SLIDER_FOR_ROTATION = "4";
    public static final String NOTIF_SLIDER_FOR_RINGER = "5";

    public static final String ACTION_UPDATE_SLIDER_SETTINGS
            = "org.omnirom.device.UPDATE_SLIDER_SETTINGS";

    public static final String EXTRA_SLIDER_USAGE = "usage";
    public static final String EXTRA_SLIDER_ACTIONS = "actions";

    // Holds <preference_key> -> <proc_node> mapping
    public static final Map<String, String> sBooleanNodePreferenceMap = new HashMap<>();
    public static final Map<String, String> sStringNodePreferenceMap = new HashMap<>();

    // Holds <preference_key> -> <default_values> mapping
    public static final Map<String, Object> sNodeDefaultMap = new HashMap<>();

    public static boolean isPreferenceEnabled(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, (Boolean) sNodeDefaultMap.get(key));
    }

    public static String getPreferenceString(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, (String) sNodeDefaultMap.get(key));
    }

    public static boolean isNotificationSliderSupported() {
        return FileUtils.fileExists(NOTIF_SLIDER_NODE);
    }
}
