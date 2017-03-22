package com.example.windows10.rx_retrofit_library.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.windows10.rx_retrofit_library.R;


public class CYPLoadingDialog extends Dialog {
	public LinearLayout ll;
	private Callback callback;
	private boolean isForceClosed;

	public CYPLoadingDialog(Context context, String message) {
		//TODO
		super(context, R.style.ProgressHUD);

		this.setTitle("");
		this.setContentView(R.layout.dialog_loadingprogress);
		this.setCancelable(false);
		this.setCanceledOnTouchOutside(false);

		ll = (LinearLayout) this.findViewById(R.id.common_ll_close);
		ll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CYPLoadingDialog.this.dismiss();
				isForceClosed = true;
				if (callback != null) {
					callback.close(CYPLoadingDialog.this);
				}
			}
		});
		if (message == null || message.length() == 0) {
			this.findViewById(R.id.message).setVisibility(View.GONE);
		} else {
			TextView txt = (TextView) this.findViewById(R.id.message);
			txt.setText(message);
		}	
		this.getWindow().getAttributes().gravity = Gravity.CENTER;
		WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		lp.dimAmount = 0.2f;
		this.getWindow().setAttributes(lp);
	}

	public void onWindowFocusChanged(boolean hasFocus) {
		// if(hasFocus){
		// ImageView imageView = (ImageView)
		// findViewById(R.id.spinnerImageView);
		// imageView.setBackgroundResource(R.anim.common_loadingprogress_spinner);
		// AnimationDrawable spinner = (AnimationDrawable)
		// imageView.getBackground();
		// spinner.start();
		// }
	}

	public void setMessage(CharSequence message) {
		if (message != null && message.length() > 0) {
			findViewById(R.id.message).setVisibility(View.VISIBLE);
			TextView txt = (TextView) findViewById(R.id.message);
			txt.setText(message);
			txt.invalidate();
		}
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	public interface Callback {
		void close(CYPLoadingDialog dialog);
	}

	public void open() {
		isForceClosed = false;
	}

	public boolean isForceClosed() {
		return isForceClosed;
	}
}
