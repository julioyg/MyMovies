package com.bestteamever.mymovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import java.util.List;

public abstract class AbstractRecyclerAdapter<TItem, TViewHolder extends RecyclerView.ViewHolder>
    extends RecyclerView.Adapter<TViewHolder> {
  private final Context mContext;
  private List<TItem> mItems;

  public AbstractRecyclerAdapter(Context context, List<TItem> items) {
    mContext = context;
    mItems = items;
  }

  @Override public TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(TViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return mItems == null ? 0 : mItems.size();
  }

  public Context getContext() {
    return mContext;
  }

  public TItem getItem(int position) {
    return mItems.get(position);
  }
}
