package com.i108.miedicinealert;

import com.i108.miedicinealert.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;

public class TemplateActivity extends ActionBarActivity {

	private AdView adView;
	//use your own AdMob ID
	private static final String AD_UNIT_ID = "ca-app-pub-1701219126323577/9129048448";

	@Override
	public void onResume() {
		super.onResume();
		if (adView != null) {
			adView.resume();
		}
	}

	@Override
	public void onPause() {
		if (adView != null) {
			adView.pause();
		}
		super.onPause();
	}

	/** Called before the activity is destroyed. */
	@Override
	public void onDestroy() {
		// Destroy the AdView.
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}

	public void loadAd() {
		adView = new AdView(this);
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId(AD_UNIT_ID);
		FrameLayout layout = (FrameLayout) findViewById(R.id.ad_layout);
		layout.addView(adView);
		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("E431E55912AE13853E44E14F557E8151").build();
		adView.loadAd(adRequest);
	}

}
