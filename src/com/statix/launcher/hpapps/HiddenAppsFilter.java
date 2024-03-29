/*
 * Copyright (C) 2019 The LineageOS Project
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
package com.statix.launcher.hpapps;

import android.content.ComponentName;
import android.content.Context;

import com.android.launcher3.AppFilter;

import com.statix.launcher.hpapps.db.HpDatabaseHelper;

@SuppressWarnings("unused")
public class HiddenAppsFilter extends AppFilter {
    private HpDatabaseHelper mDbHelper;

    public HiddenAppsFilter(Context context) {
        super(context);

        mDbHelper = HpDatabaseHelper.getInstance(context);
    }

    @Override
    public boolean shouldShowApp(ComponentName app) {
        return !mDbHelper.isPackageHidden(app.getPackageName()) && super.shouldShowApp(app);
    }
}
