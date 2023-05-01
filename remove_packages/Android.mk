LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := RemovePackages
LOCAL_MODULE_CLASS := APPS
LOCAL_MODULE_TAGS := optional
LOCAL_OVERRIDES_PACKAGES := \
	arcore \
	Bromite \
	CalculatorGooglePrebuilt \
	CalendarGooglePrebuilt \
	Drive \
	Etar \
	Maps \
	Phonograph \
	PixelLiveWallpaperPrebuilt \
	PixelWallpapers2022 \
	PrebuiltGmail \
	RecorderPrebuilt \
	SafetyHubPrebuilt \
	talkback \
	yetCalc
LOCAL_UNINSTALLABLE_MODULE := true
LOCAL_CERTIFICATE := PRESIGNED
LOCAL_SRC_FILES := /dev/null
include $(BUILD_PREBUILT)
