package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.simprints.libsimprints.Identification;

import java.util.ArrayList;

import static com.simprints.libsimprints.Constants.SIMPRINTS_IDENTIFICATIONS;

public class IdentifyActivity extends TaskActivity {
	@Override String getTaskName() { return "Identify"; }
	@Override int getContentView() { return R.layout.tsk_identify; }
	@Override void populateIntent(Intent i) { i.putExtra(SIMPRINTS_IDENTIFICATIONS, identifications()); }

//> CUSTOM EVENT LISTENERS

//> PRIVATE HELPERS
	private ArrayList<Identification> identifications() {
		return new ArrayList<>();
	}
}
