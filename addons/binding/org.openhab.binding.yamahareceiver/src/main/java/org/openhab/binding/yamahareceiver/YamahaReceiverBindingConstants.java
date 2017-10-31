/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.yamahareceiver;

import java.util.Collections;
import java.util.Set;

import org.eclipse.smarthome.core.thing.ThingTypeUID;

import com.google.common.collect.Sets;

/**
 * The {@link YamahaReceiverBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author David Graeff <david.graeff@web.de>
 * @author Tomasz Maruszak - DAB support, Spotify support, refactoring
 */
public class YamahaReceiverBindingConstants {
    public static final String BINDING_ID = "yamahareceiver";

    // List of all Thing Type UIDs
    public static final ThingTypeUID BRIDGE_THING_TYPE = new ThingTypeUID(BINDING_ID, "yamahaAV");
    public static final ThingTypeUID ZONE_THING_TYPE = new ThingTypeUID(BINDING_ID, "zone");

    public static final Set<ThingTypeUID> BRIDGE_THING_TYPES_UIDS = Collections.singleton(BRIDGE_THING_TYPE);
    public static final Set<ThingTypeUID> ZONE_THING_TYPES_UIDS = Collections.singleton(ZONE_THING_TYPE);

    // List of channel IDs for zone control (except power which is also a non-zone/bridge channel)
    public static final String CHANNEL_POWER = "power";
    public static final String CHANNEL_INPUT = "input";
    public static final String CHANNEL_INPUT_TYPE_AVAILABLE = "availableinput";
    public static final String CHANNEL_INPUT_TYPE_DEFAULT = "defaultinput";
    public static final String CHANNEL_SURROUND = "surroundProgram";
    public static final String CHANNEL_VOLUME = "volume";
    public static final String CHANNEL_VOLUME_DB = "volumeDB";
    public static final String CHANNEL_MUTE = "mute";

    // List of channel IDs for navigation control: Read/Write
    public static final String CHANNEL_NAVIGATION_MENU = "navigation_menu"; // Navigate either in the current menu
                                                                            // or to the full menu path if "/" is used.
    // List of channel IDs for navigation control: Write only
    public static final String CHANNEL_NAVIGATION_UPDOWN = "navigation_updown"; // UpDown; Change current line
    public static final String CHANNEL_NAVIGATION_LEFTRIGHT = "navigation_leftright"; // UpDown Type
    public static final String CHANNEL_NAVIGATION_SELECT = "navigation_select"; // Switch Type
    public static final String CHANNEL_NAVIGATION_BACK = "navigation_back"; // Switch Type
    public static final String CHANNEL_NAVIGATION_BACKTOROOT = "navigation_backtoroot"; // Switch Type

    // List of channel IDs for navigation control: Read only
    public static final String CHANNEL_NAVIGATION_LEVEL = "navigation_level"; // DecType
    public static final String CHANNEL_NAVIGATION_CURRENT_ITEM = "navigation_current_item"; // DecType
    public static final String CHANNEL_NAVIGATION_TOTAL_ITEMS = "navigation_total_items"; // DecType

    public static final Set<String> CHANNELS_NAVIGATION = Sets.newHashSet(CHANNEL_NAVIGATION_MENU,
            CHANNEL_NAVIGATION_CURRENT_ITEM, CHANNEL_NAVIGATION_UPDOWN, CHANNEL_NAVIGATION_LEFTRIGHT,
            CHANNEL_NAVIGATION_SELECT, CHANNEL_NAVIGATION_BACK, CHANNEL_NAVIGATION_BACKTOROOT, CHANNEL_NAVIGATION_LEVEL,
            CHANNEL_NAVIGATION_TOTAL_ITEMS);

    // List of channel IDs for Tuner DAB control
    public static final String CHANNEL_TUNER_BAND = "tuner_band"; // band name for DAB tuner; RW

    // List of channel IDs for playback control
    public static final String CHANNEL_PLAYBACK_PRESET = "preset"; // Preset number; RW
    public static final String CHANNEL_PLAYBACK_PRESET_TYPE_DEFAULT = "defaultpreset"; // Preset number; RW
    public static final String CHANNEL_PLAYBACK_PRESET_TYPE_NAMED = "namedpreset"; // Preset number; RW
    public static final String CHANNEL_PLAYBACK = "playback"; // Play,Pause,Stop,FastFW,Rewind,Next,Previous.
                                                              // Will show the current state as String.
    // List of channel IDs for playback control: Read only
    public static final String CHANNEL_PLAYBACK_STATION = "playback_station";
    public static final String CHANNEL_PLAYBACK_ARTIST = "playback_artist";
    public static final String CHANNEL_PLAYBACK_ALBUM = "playback_album";
    public static final String CHANNEL_PLAYBACK_SONG = "playback_song";
    public static final String CHANNEL_PLAYBACK_SONG_IMAGE_URL = "playback_song_image_url";

    public static final Set<String> CHANNELS_PLAYBACK = Sets.newHashSet(CHANNEL_PLAYBACK,
            CHANNEL_PLAYBACK_STATION, CHANNEL_PLAYBACK_ARTIST, CHANNEL_PLAYBACK_ALBUM, CHANNEL_PLAYBACK_SONG,
            CHANNEL_PLAYBACK_SONG_IMAGE_URL);

    public static final String UPNP_TYPE = "MediaRenderer";
    public static final String UPNP_MANUFACTURER = "YAMAHA";

    public static final String CONFIG_REFRESH = "REFRESH_IN_SEC";
    public static final String CONFIG_HOST_NAME = "HOST";
    public static final String CONFIG_HOST_PORT = "PORT";
    public static final String CONFIG_ZONE = "ZONE";
    public static final String CONFIG_RELVOLUMECHANGE = "RELVOLUMECHANGE";

    public static final String PROPERTY_VERSION = "version";
    public static final String PROPERTY_ASSIGNED_NAME = "assigned_name";
    public static final String PROPERTY_MENU_ERROR = "menu_error";
    public static final String PROPERTY_LAST_PARSE_ERROR = "last_parse_error";

    public static final String CHANNEL_GROUP_PLAYBACK = "playback_channels";
    public static final String CHANNEL_GROUP_NAVIGATION = "navigation_channels";
    public static final String CHANNEL_GROUP_ZONE = "zone_channels";

    /**
     * The names of this enum are part of the protocols!
     * Receivers have different capabilities, some have 2 zones, some up to 4.
     * Every receiver has a "Main_Zone".
     */
    public enum Zone {
        Main_Zone,
        Zone_2,
        Zone_3,
        Zone_4
    }

    /**
     * The volume min and max is the same for all supported devices.
     */
    public static final int VOLUME_MIN = -80;

    public static final int VOLUME_MAX = 12;

    public static final int VOLUME_RANGE = -VOLUME_MIN + VOLUME_MAX;

    /** Retry time in ms if no response for menu navigation */
    public static final int MENU_RETRY_DELAY = 500;

    /** Max menu waiting in ms */
    public static final int MENU_MAX_WAITING_TIME = 5000;

    // List of known inputs
    public static final String INPUT_TUNER = "TUNER";
    public static final String INPUT_SPOTIFY = "Spotify";
    public static final String INPUT_BLUETOOTH = "Bluetooth";

    /** Placeholder value that is used when the string channel value is not available */
    public static final String VALUE_NA = "N/A";
    /** Empty value that is used when the string channel value is not available */
    public static final String VALUE_EMPTY = "";
}
