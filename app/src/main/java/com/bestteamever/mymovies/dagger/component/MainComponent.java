package com.bestteamever.mymovies.dagger.component;

import com.bestteamever.mymovies.dagger.PerActivity;
import com.bestteamever.mymovies.dagger.module.MainModule;
import com.bestteamever.mymovies.ui.main.view.MainActivityFragment;

import dagger.Component;

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivityFragment fragment);
}
