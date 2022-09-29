package com.rxjava2.android.medicinealert;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onReceive(Context context, Intent intent) {
        int value = intent.getIntExtra("KEY", 0);

        Notification.Builder n = new Notification.Builder(context);
        // 通知されたときに通知バーに表示される文章
        String set_text = "メッセージ　受け取った変数：" + value;	//受け取ったvalueに応じて文章を変更したりなど、ご自由に
        n.setTicker(set_text); // メッセージの設定
        n.setFlag(Notification.FLAG_AUTO_CANCEL, true); // 通知を選択した時に自動的に通知が消えるための設定

        // 通常の着信音を選択する
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM); // アラーム音
        n.setSound(uri); // サウンド

        //通知をタッチしたときに起動するActivity
        Intent i = new Intent(context, MainActivity.class);

        // 上から通知バーを下してきたときに表示される文章をセット

        long[] vibrate_ptn; // 独自バイブレーションパターン
        vibrate_ptn = new long[]{ 0, 100, 300, 1000 };
        n.setVibrate(vibrate_ptn); // 独自バイブレーションパターンを設定

        n.setDefaults(Notification.DEFAULT_LIGHTS); // デフォルトLED点滅パターンを設定

        Notification notification = n.build();
        // NotificationManagerのインスタンス取得
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1, notification); // 設定したNotificationを通知する
        context.startActivity(i);
    }
}
