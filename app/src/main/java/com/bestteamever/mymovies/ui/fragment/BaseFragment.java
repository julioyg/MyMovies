package com.bestteamever.mymovies.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.bestteamever.mymovies.di.HasComponent;

public abstract class BaseFragment extends Fragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);
  }

  /**
   * Gets a component for dependency injection by its type.
   */
  @SuppressWarnings("unchecked") protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }
}
