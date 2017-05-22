package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import static medic.mocksimprints.MedicLog.trace;

public class StartupActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		trace(this, "Started.");

		// Start an activity here if you want to test its layout
		startActivity(new Intent(this, RegisterActivity.class));

		finish();
	}
}
