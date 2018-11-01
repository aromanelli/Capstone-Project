package info.romanelli.udacity.capstone.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    final static private String TAG = AppExecutors.class.getSimpleName();

    static private volatile AppExecutors INSTANCE;

    static public AppExecutors $() {
        if (INSTANCE == null) {
            synchronized (AppExecutors.class) {
                if (INSTANCE == null) {
                    Log.d(TAG, "$: Creating Executors!");
                    INSTANCE = new AppExecutors(
                            Executors.newSingleThreadExecutor(),
                            Executors.newFixedThreadPool(3),
                            new MainThreadExecutor()
                    );
                }
            }
        }
        return INSTANCE;
    }

    final private Executor diskIO;
    private final Executor mainThread;
    private final Executor networkIO;

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor mainUI() {
        return mainThread;
    }

    public Executor netIO() {
        return networkIO;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

}