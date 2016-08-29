package com.example.jimmi.mediaplayer3;

        import android.app.Service;
        import android.content.Intent;
        import android.media.MediaPlayer;
        import android.media.MediaPlayer.OnCompletionListener;
        import android.net.Uri;
        import android.os.Environment;
        import android.os.IBinder;
        import java.io.File;
        import java.util.ArrayList;

class BackgroundAudioService extends Service implements OnCompletionListener
{
    private MediaPlayer mediaPlayer;
    private File root;
    private ArrayList<File> list;
    private MusicHandler handler = new MusicHandler();
    private String song;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate()
    {
        root = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        list = handler.getfile(root);
        mediaPlayer = MediaPlayer.create(this, Uri.parse(list.get(0).getPath().toString()));// raw/s.mp3
        mediaPlayer.setOnCompletionListener(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    public void onDestroy() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
    }

    public void onCompletion(MediaPlayer _mediaPlayer) {
        stopSelf();
    }

}