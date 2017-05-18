package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.simprints.libsimprints.Registration;

import java.util.Random;

import static com.simprints.libsimprints.Constants.SIMPRINTS_REGISTRATION;
import static medic.mocksimprints.MedicLog.trace;

public class ScanActivity extends Activity {
	private String id;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		trace(this, "Started.");

		setContentView(R.layout.scan);
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

		TextView tv = (TextView) findViewById(R.id.txtGeneratedId);
		tv.setText(id);
	}

//> PRIVATE HELPERS
	private Registration registration() {
		return new Registration(id);
	}
}
