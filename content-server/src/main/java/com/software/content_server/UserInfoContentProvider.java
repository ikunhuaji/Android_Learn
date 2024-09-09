package com.software.content_server;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class UserInfoContentProvider extends ContentProvider {
    //初始化UserDBHelper
    private UserDBHelper helper;

    private static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static{
//        content://com.software.content_server.UserInfoContentProvider/user_info
        uriMatcher.addURI("com.software.content_server.UserInfoContentProvider","/user_info",1);

//        如何获取 content://com.software.content_server.UserInfoContentProvider/user_info/2
        uriMatcher.addURI("com.software.content_server.UserInfoContentProvider","/user_info/#",2);// # 表示数字
    }

    public UserInfoContentProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //传入Uri
        //取传入Uri的code
        int code = uriMatcher.match(uri);

        if(code==1){
            //执行新增
            SQLiteDatabase db = helper.getWritableDatabase();
            long row = db.insert(UserDBHelper.TABLE_NAME, null, values);

            //用 row 更改 Uri 后返回
            Uri result = ContentUris.withAppendedId(uri, row);

//            db.close();

            getContext().getContentResolver().notifyChange(uri,null);//通知所有

            return result;
        }else {
            throw new RuntimeException("传入的Uri不合法");
        }
    }

    @Override
    public boolean onCreate() {
        helper = UserDBHelper.getInstance(this.getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int code = uriMatcher.match(uri);
        SQLiteDatabase db = helper.getReadableDatabase();
        if(code==1){
            //查询所有
            Cursor cursor = db.query(UserDBHelper.TABLE_NAME,null,null,null,null,null,null);
//            db.close();
            return cursor;

        }else if (code==2) {
            //通过id查询
            long id = ContentUris.parseId(uri);
            Cursor cursor = db.query(UserDBHelper.TABLE_NAME,null,"id = ? ",new String[]{String.valueOf(id)},null,null,null);
//            db.close();
            return cursor;

        }else {
            throw new RuntimeException("传入的Uri不合法");
        }
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}