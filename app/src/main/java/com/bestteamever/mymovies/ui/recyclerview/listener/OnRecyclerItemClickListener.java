package com.bestteamever.mymovies.ui.recyclerview.listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
  private final OnItemClickListener mListener;
  private final GestureDetector mGestureDetector;

  public OnRecyclerItemClickListener(Context context, OnItemClickListener listener) {
    mListener = listener;
    mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
      @Override public boolean onSingleTapUp(MotionEvent e) {
        return true;
      }
    });
  }

  @Override public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
    if (mGestureDetector.onTouchEvent(e)) {
      View child = rv.findChildViewUnder(e.getX(), e.getY());

      if (child != null) {
        this.mListener.onItemClick(rv, child, rv.getChildAdapterPosition(child));
        return true;
      }
    }

    return false;
  }

  @Override public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    //empty
  }

  @Override public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    //empty
  }

  public interface OnItemClickListener {
    void onItemClick(RecyclerView rv, View child, int position);
  }
}
