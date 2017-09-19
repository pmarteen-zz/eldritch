package com.primum.cept.eldritchhorrorcompanion.loader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.primum.cept.eldritchhorrorcompanion.loader.impl.BaseSetLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.impl.DreamlandsLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.impl.ForsakenLoreLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.impl.MountainsOfMadnessLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.impl.StrangeRemnantsLoader;
import com.primum.cept.eldritchhorrorcompanion.loader.impl.UnderThePyramidsLoader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Peter on 4/28/2017.
 */

public class LoadManager {
    // Sets the amount of time an idle thread will wait for a task before terminating
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static final int CORE_POOL_SIZE = 8;
    private static final int MAXIMUM_POOL_SIZE = 8;

    private final ThreadPoolExecutor mThreadPool;
    private static LoadManager sInstance = null;

    static {
        sInstance = new LoadManager();
    }

    private LoadManager(){
        final BlockingQueue<Runnable> mQueue = new LinkedBlockingQueue<Runnable>();
        mThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mQueue);
    }

    public static LoadManager getInstance(){
        return sInstance;
    }

    public void load(Context context, SQLiteDatabase db){
        //Load Base set
        BaseSetLoader baseSetLoader = new BaseSetLoader(context, db);
        mThreadPool.execute(baseSetLoader);

        //Load Forsaken Lore expansion set
        ForsakenLoreLoader forsakenLoreLoader = new ForsakenLoreLoader(context,db);
        mThreadPool.execute(forsakenLoreLoader);

        //Load Strange Remnants expansion set
        StrangeRemnantsLoader strangeRemnantsLoader = new StrangeRemnantsLoader(context, db);
        mThreadPool.execute(strangeRemnantsLoader);

        //Load Under The Pyramids expansion set
        UnderThePyramidsLoader underThePyramidsLoader = new UnderThePyramidsLoader(context, db);
        mThreadPool.execute(underThePyramidsLoader);

        //Load Mountains of Madness expansion set
        MountainsOfMadnessLoader mountainsOfMadnessLoader = new MountainsOfMadnessLoader(context, db);
        mThreadPool.execute(mountainsOfMadnessLoader);

        //Load Dreamlands expansion set
        DreamlandsLoader dreamlandsLoader = new DreamlandsLoader(context, db);
        mThreadPool.execute(dreamlandsLoader);
    }
}
