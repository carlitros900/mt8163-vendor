LOCAL_PATH:= $(call my-dir)
ifeq ($(MTK_PROJECT), yyd8163_tb_m)
include $(call all-makefiles-under,$(LOCAL_PATH))
endif