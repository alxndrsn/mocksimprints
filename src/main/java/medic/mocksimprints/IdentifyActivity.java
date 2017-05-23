package medic.mocksimprints;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.simprints.libsimprints.Identification;
import com.simprints.libsimprints.Tier;

import java.util.ArrayList;
import java.util.Random;

import static com.simprints.libsimprints.Constants.SIMPRINTS_IDENTIFICATIONS;

public class IdentifyActivity extends TaskActivity {
	private Random r = new Random();

	@Override String getTaskName() { return "Identify"; }
	@Override int getContentView() { return R.layout.tsk_identify; }
	@Override void populateIntent(Intent i) { i.putExtra(SIMPRINTS_IDENTIFICATIONS, identifications()); }

//> CUSTOM EVENT LISTENERS

//> PRIVATE HELPERS
	private ArrayList<Identification> identifications() {
		ArrayList<Identification> ids = new ArrayList<>();
		for(String id : getTextFrom(R.id.txtIds).split("\\s")) {
			if(id.length() > 0) ids.add(new Identification(id, randomConfidence(), randomTier()));
		}
		return ids;
	}

	private int randomConfidence() {
		return r.nextInt(99) + 1;
	}

	private Tier randomTier() {
		int n = r.nextInt(Tier.values().length);
		return Tier.values()[n];
	}
}
