package com.alaminkarno.androidwidgets;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

public class ButtonWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appID : appWidgetIds){
            Intent intent = new Intent(context,MainActivity.class);

            PendingIntent pendingIntent = null;

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
                pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_MUTABLE);
            }else{
                pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_ONE_SHOT);
            }


            RemoteViews view = new RemoteViews(context.getPackageName(),R.layout.button_widget);

            view.setOnClickPendingIntent(R.id.button_widgetBTN,pendingIntent);

           appWidgetManager.updateAppWidget(appID,view);
        }
    }
}
