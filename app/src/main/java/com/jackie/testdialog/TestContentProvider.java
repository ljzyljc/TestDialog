package com.jackie.testdialog;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Description:
 *
 * @author feifei5292190@gmail.com
 * @date 2020/11/2
 */
public class TestContentProvider extends ContentProvider {
    private static final String TAG = "TestContentProvider";
    @Override
    public boolean onCreate() {
//        Log.i(TAG, "onCreate: ===1====");
//        try {
//            Thread.sleep(15_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Log.i(TAG, "onCreate: =====2=======");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
