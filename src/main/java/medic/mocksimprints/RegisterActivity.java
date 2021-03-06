package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.simprints.libsimprints.Registration;

import java.util.Random;

import static com.simprints.libsimprints.Constants.SIMPRINTS_REGISTRATION;

public class RegisterActivity extends TaskActivity {
	private final Random r = new Random();
	private String id;

	@Override String getTaskName() { return "Register"; }
	@Override int getContentView() { return R.layout.tsk_register; }
	@Override void populateIntent(Intent i) { i.putExtra(SIMPRINTS_REGISTRATION, registration()); }

//> CUSTOM EVENT LISTENERS
	public void btnGenerateId_onClick(View v) {
		id = "" + ((char) ('a' + r.nextInt(26))) + r.nextInt(100);

		setText(R.id.txtGeneratedId, id);
	}

//> PRIVATE HELPERS
	private Registration registration() {
		return new Registration(id);
	}
}
