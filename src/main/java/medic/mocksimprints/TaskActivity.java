package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.simprints.libsimprints.Constants.SIMPRINTS_API_KEY;
import static com.simprints.libsimprints.Constants.SIMPRINTS_MODULE_ID;
import static com.simprints.libsimprints.Constants.SIMPRINTS_USER_ID;
import static medic.mocksimprints.MedicLog.trace;

abstract class TaskActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		trace(this, "Started.");

		setTitle(getTaskName() + " - " + getTitle());

		setContentView(getContentView());

		setText(R.id.txtApiKey, "API Key: " + getIntent().getStringExtra(SIMPRINTS_API_KEY));
		setText(R.id.txtUserId, "User ID: " + getIntent().getStringExtra(SIMPRINTS_USER_ID));
		setText(R.id.txtModuleId, "Module ID: " + getIntent().getStringExtra(SIMPRINTS_MODULE_ID));
	}

//> ABSTRACT METHODS
	abstract String getTaskName();
	abstract int getContentView();
	abstract void populateIntent(Intent i);

//> CUSTOM EVENT LISTENERS
	public void btnOk_onClick(View v) {
		Intent i = new Intent();

		populateIntent(i);

		setResult(Activity.RESULT_OK, i);
		finish();
	}

//> PRIVATE HELPERS
	protected String getTextFrom(int fieldId) {
		return ((TextView) findViewById(fieldId)).getText().toString();
	}

	protected void setText(int fieldId, CharSequence text) {
		TextView tv = (TextView) findViewById(fieldId);
		tv.setText(text);
	}
}

