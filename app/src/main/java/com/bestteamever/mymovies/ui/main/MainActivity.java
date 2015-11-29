package com.bestteamever.mymovies.ui.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.di.HasComponent;
import com.bestteamever.mymovies.di.component.DaggerMainComponent;
import com.bestteamever.mymovies.di.component.MainComponent;
import com.bestteamever.mymovies.di.module.MainModule;
import com.bestteamever.mymovies.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {

    private MainComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.mActivityComponent = DaggerMainComponent.builder()
                                                     .applicationComponent(super.getApplicationComponent())
                                                     .mainModule(new MainModule())
                                                     .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public MainComponent getComponent() {
        return this.mActivityComponent;
    }
}
