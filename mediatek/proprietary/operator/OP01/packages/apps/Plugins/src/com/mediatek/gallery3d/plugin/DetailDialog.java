/* Copyright Statement:
 *
 * This software/firmware and related documentation ("MediaTek Software") are
 * protected under relevant copyright laws. The information contained herein
 * is confidential and proprietary to MediaTek Inc. and/or its licensors.
 * Without the prior written permission of MediaTek inc. and/or its licensors,
 * any reproduction, modification, use or disclosure of MediaTek Software,
 * and information contained herein, in whole or in part, shall be strictly prohibited.
 *
 * MediaTek Inc. (C) 2010. All rights reserved.
 *
 * BY OPENING THIS FILE, RECEIVER HEREBY UNEQUIVOCALLY ACKNOWLEDGES AND AGREES
 * THAT THE SOFTWARE/FIRMWARE AND ITS DOCUMENTATIONS ("MEDIATEK SOFTWARE")
 * RECEIVED FROM MEDIATEK AND/OR ITS REPRESENTATIVES ARE PROVIDED TO RECEIVER ON
 * AN "AS-IS" BASIS ONLY. MEDIATEK EXPRESSLY DISCLAIMS ANY AND ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE OR NONINFRINGEMENT.
 * NEITHER DOES MEDIATEK PROVIDE ANY WARRANTY WHATSOEVER WITH RESPECT TO THE
 * SOFTWARE OF ANY THIRD PARTY WHICH MAY BE USED BY, INCORPORATED IN, OR
 * SUPPLIED WITH THE MEDIATEK SOFTWARE, AND RECEIVER AGREES TO LOOK ONLY TO SUCH
 * THIRD PARTY FOR ANY WARRANTY CLAIM RELATING THERETO. RECEIVER EXPRESSLY ACKNOWLEDGES
 * THAT IT IS RECEIVER'S SOLE RESPONSIBILITY TO OBTAIN FROM ANY THIRD PARTY ALL PROPER LICENSES
 * CONTAINED IN MEDIATEK SOFTWARE. MEDIATEK SHALL ALSO NOT BE RESPONSIBLE FOR ANY MEDIATEK
 * SOFTWARE RELEASES MADE TO RECEIVER'S SPECIFICATION OR TO CONFORM TO A PARTICULAR
 * STANDARD OR OPEN FORUM. RECEIVER'S SOLE AND EXCLUSIVE REMEDY AND MEDIATEK'S ENTIRE AND
 * CUMULATIVE LIABILITY WITH RESPECT TO THE MEDIATEK SOFTWARE RELEASED HEREUNDER WILL BE,
 * AT MEDIATEK'S OPTION, TO REVISE OR REPLACE THE MEDIATEK SOFTWARE AT ISSUE,
 * OR REFUND ANY SOFTWARE LICENSE FEES OR SERVICE CHARGE PAID BY RECEIVER TO
 * MEDIATEK FOR SUCH MEDIATEK SOFTWARE AT ISSUE.
 *
 * The following software/firmware and/or related documentation ("MediaTek Software")
 * have been modified by MediaTek Inc. All revisions are subject to any receiver's
 * applicable license agreements with MediaTek Inc.
 */

/*
 * Copyright (C) 2010 The Android Open Source Project
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
package com.mediatek.gallery3d.video;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.gallery3d.R;

import com.mediatek.galleryframework.util.MtkLog;

/**
 * OP01 plugin implementation of DetailDialog.
 */
public class DetailDialog extends AlertDialog implements DialogInterface.OnClickListener {
    private static final String TAG = "Gallery2/VideoPlayer/DetailDialog";
    private static final boolean LOG = true;

    private static final int BTN_OK = DialogInterface.BUTTON_POSITIVE;
    private final Context mContext;

    private View mView;
    private TextView mAuthorView;
    private TextView mTitleView;
    private TextView mCopyrightView;

    private final String mTitle;
    private final String mAuthor;
    private final String mCopyright;

    /**
     * @hide
     *
     * @param context context instance
     * @param title title string
     * @param author author string
     * @param copyright copyright string
     */
    public DetailDialog(final Context context, final String title,
                        final String author, final String copyright) {
        super(context);
        mContext = context;
        mTitle = (title == null ? "" : title);
        mAuthor = (author == null ? "" : author);
        mCopyright = (copyright == null ? "" : copyright);
        if (LOG) {
            MtkLog.v(TAG, "LimitDialog() mTitle=" + mTitle + ", mAuthor="
                    + mAuthor + ", mCopyRight=" + mCopyright);
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        setTitle(R.string.media_detail);
        mView = getLayoutInflater().inflate(R.layout.m_detail_dialog, null);
        if (mView != null) {
            setView(mView);
        }
        mTitleView = (TextView) mView.findViewById(R.id.title);
        mAuthorView = (TextView) mView.findViewById(R.id.author);
        mCopyrightView = (TextView) mView.findViewById(R.id.copyright);

        mTitleView.setText(mContext.getString(R.string.detail_title, mTitle));
        mAuthorView.setText(mContext.getString(R.string.detail_session, mAuthor));
        mCopyrightView.setText(mContext.getString(R.string.detail_copyright, mCopyright));
        setButton(BTN_OK, mContext.getString(android.R.string.ok), this);
        super.onCreate(savedInstanceState);

    }

    /**
     * @hide
     *
     * @param dialogInterface dialogInterface instance
     * @param button button type
     */
    public void onClick(final DialogInterface dialogInterface, final int button) {

    }
}
