package com.bestteamever.mymovies.di.component;

import android.content.Context;

import com.bestteamever.mymovies.di.module.ApplicationModule;
import com.bestteamever.mymovies.di.module.DataModule;
import com.bestteamever.mymovies.domain.executor.PostExecutionThread;
import com.bestteamever.mymovies.domain.executor.ThreadExecutor;
import com.bestteamever.mymovies.domain.repository.MovieRepository;
import com.bestteamever.mymovies.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();
    MovieRepository movierepository();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

}