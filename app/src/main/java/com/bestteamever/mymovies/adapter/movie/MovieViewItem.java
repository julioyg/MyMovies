package com.bestteamever.mymovies.adapter.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.MovieModel;
import com.bumptech.glide.Glide;

public class MovieViewItem extends FrameLayout {
  @Bind(R.id.title) TextView mTitleView;
  @Bind(R.id.date) TextView mDateView;
  @Bind(R.id.overview) TextView mOverviewView;
  @Bind(R.id.image) ImageView mImageView;

  public MovieViewItem(Context context) {
    super(context);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.adapter_movie_item, this, true);
    ButterKnife.bind(this);
  }

  public void bind(MovieModel movie) {
    mTitleView.setText(movie.getTitle());
    mDateView.setText(movie.getDate());
    mOverviewView.setText(movie.getOverView());

    Glide.with(getContext()).load(movie.getPoster()).into(mImageView);
  }
}
