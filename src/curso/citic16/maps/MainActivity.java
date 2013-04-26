package curso.citic16.maps;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends Activity {
  static final LatLng CITIC = new LatLng(43.332627, -8.408017);
  static final LatLng CITIC_EXT = new LatLng(43.332700, -8.408023);
  private GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    if (map != null) {
    	Marker citic = map.addMarker(new MarkerOptions().position(CITIC)
    			.title("CITIC"));
    	Marker citic_ex = map.addMarker(new MarkerOptions()
        		.position(CITIC_EXT)
        		.title("CITIC")
        		.snippet("Centro de Informaci—n ....")
        		.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));

    	// Move the camera instantly to hamburg with a zoom of 15.
    	map.moveCamera(CameraUpdateFactory.newLatLngZoom(CITIC, 15));

    	// Zoom in, animating the camera.
    	map.animateCamera(CameraUpdateFactory.zoomTo(23), 2000, null);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    //getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
  }

} 