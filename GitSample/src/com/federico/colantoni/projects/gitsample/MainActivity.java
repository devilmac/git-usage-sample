package com.federico.colantoni.projects.gitsample;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.action_button1) {

			Toast.makeText(this, "You pressed \"Button 1\"", Toast.LENGTH_SHORT)
					.show();

			startActivity(new Intent(this, SecondActivity.class));
			return true;
		} else if (id == R.id.action_button2) {

			Toast.makeText(this, "You pressed \"Button 2\"", Toast.LENGTH_SHORT)
					.show();

			AlertDialog.Builder builder = new Builder(this);

			builder.setCancelable(false);
			builder.setMessage("You pressed \"Button 2\"");
			builder.setTitle("Warning!");
			builder.setPositiveButton("OK", this);
			builder.setNegativeButton("Cancel", this);

			builder.create().show();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {

		finish();

		System.exit(0);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			finish();

			System.exit(0);
		}

		return super.onKeyDown(keyCode, event);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {

		dialog.dismiss();
	}

}
