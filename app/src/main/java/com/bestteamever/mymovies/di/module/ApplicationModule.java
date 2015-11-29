package com.bestteamever.mymovies.di.module;

import android.content.Context;

import com.bestteamever.mymovies.App;
import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;
import com.bestteamever.mymovies.executor.JobExecutor;
import com.bestteamever.mymovies.executor.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}