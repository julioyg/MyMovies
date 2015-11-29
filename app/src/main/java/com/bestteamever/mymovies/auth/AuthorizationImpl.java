package com.bestteamever.mymovies.auth;

import com.bestteamever.mymovies.data.movie.repository.Authorization;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton public class AuthorizationImpl implements Authorization {

  @Inject public AuthorizationImpl() {
  }

  @Override public String getToken() {
    return "b651984d-945f-4df0-b686-bf2206df3142";
  }
}
