package com.bestteamever.mymovies.di.component;

import com.bestteamever.mymovies.di.PerActivity;
import com.bestteamever.mymovies.di.module.MainModule;
import com.bestteamever.mymovies.ui.main.view.MainActivityFragment;

import dagger.Component;

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivityFragment fragment);
}
