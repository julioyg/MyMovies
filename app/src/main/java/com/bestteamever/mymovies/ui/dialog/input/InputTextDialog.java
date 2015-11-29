package com.bestteamever.mymovies.ui.dialog.input;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bestteamever.mymovies.R;

public class InputTextDialog extends DialogFragment {
  private static final String ARG_TITLE = "com.bestteamever.mymovies.TITLE";

  @Bind(R.id.text) EditText mInputTextView;

  private OnInputTextListener mListener;
  private int mTitle;

  public static InputTextDialog newInstance(@StringRes int title) {
    Bundle args = new Bundle();
    args.putInt(ARG_TITLE, title);

    InputTextDialog result = new InputTextDialog();
    result.setArguments(args);

    return result;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mListener = (OnInputTextListener) getTargetFragment();
    this.mTitle = getArguments().getInt(ARG_TITLE);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
    View view = View.inflate(getContext(), R.layout.dialog_input_text, null);
    ButterKnife.bind(this, view);

    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
    builder.setTitle(this.mTitle)
        .setView(view)
        .setPositiveButton(R.string.ok, (dialogInterface, i) -> {
          mListener.onInputText(mInputTextView.getText().toString());
        });

    return builder.create();
  }

  public interface OnInputTextListener {
    void onInputText(String text);
  }
}
