package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.simprints.libsimprints.Registration;

import java.util.Random;

import static com.simprints.libsimprints.Constants.SIMPRINTS_API_KEY;
import static com.simprints.libsimprints.Constants.SIMPRINTS_MODULE_ID;
import static com.simprints.libsimprints.Constants.SIMPRINTS_REGISTRATION;
import static com.simprints.libsimprints.Constants.SIMPRINTS_USER_ID;
import static medic.mocksimprints.MedicLog.trace;

public class ScanActivity extends Activity {
	private String id;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		trace(this, "Started.");

		setContentView(R.layout.scan);

		setText(R.id.txtApiKey, "API Key: " + getIntent().getStringExtra(SIMPRINTS_API_KEY));
		setText(R.id.txtUserId, "User ID: " + getIntent().getStringExtra(SIMPRINTS_USER_ID));
		setText(R.id.txtModuleId, "Module ID: " + getIntent().getStringExtra(SIMPRINTS_MODULE_ID));
	}

//> CUSTOM EVENT LISTENERS
	public void btnOk_onClick(View v) {
		Intent i = new Intent();
		i.putExtra(SIMPRINTS_REGISTRATION, registration());

		setResult(Activity.RESULT_OK, i);

		finish();
	}

	public void btnGenerateId_onClick(View v) {
		id = "asdf-" + Math.abs(new Random().nextInt());

		setText(R.id.txtGeneratedId, id);
	}

//> PRIVATE HELPERS
	private Registration registration() {
		return new Registration(id);
	}

	private void setText(int fieldId, CharSequence text) {
		TextView tv = (TextView) findViewById(fieldId);
		tv.setText(text);
	}
}
