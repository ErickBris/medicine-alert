package com.i108.miedicinealert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.i108.miedicinealert.R;
import com.google.android.gms.analytics.GoogleAnalytics;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AboutActivity extends Activity {

	Logger LOG = LoggerFactory.getLogger(AboutActivity.class);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LOG.trace("[Create] AboutActivity");
		setContentView(R.layout.activity_about);

		TextView tv_version = (TextView) findViewById(R.id.tv_version);
	
		TextView tv_see_apps = (TextView) findViewById(R.id.tv_see_apps);
		

		try {
			PackageInfo pInfo = getPackageManager().getPackageInfo(
					getPackageName(), 0);
			tv_version.setText(getResources().getString(R.string.version) + " "
					+ pInfo.versionName);
		} catch (NameNotFoundException e) {
			LOG.warn("NameNotFoundException: get package name", e);
		}
		
		tv_see_apps.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("http://codecanyon.net/user/Appliccon/portfolio"));
				LOG.debug("[See our Apps] Open Envato");
				startActivity(intent);
			}
		});
	

	}

	@Override
	protected void onStart() {
		LOG.trace("[Start] AboutActivity");
		GoogleAnalytics.getInstance(getBaseContext()).reportActivityStart(this);
		super.onStart();
	}

	@Override
	protected void onStop() {
		LOG.trace("[Stop] AboutActivity");
		GoogleAnalytics.getInstance(getBaseContext()).reportActivityStop(this);
		super.onStop();
	}

}
