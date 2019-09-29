package com.example.personalphoto;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final Integer[] Personal = {R.drawable.cynthia, R.drawable.drie, R.drawable.jessica, R.drawable.juan,
    R.drawable.karen, R.drawable.marvin, R.drawable.mere, R.drawable.rufis};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView) findViewById(R.id.gridView);
        final ArrayList<String> message = new ArrayList<>();
        message.add("Cynthia");
        message.add("Adriana");
        message.add("Jessica");
        message.add("Juan");
        message.add("Karen");
        message.add("Marvin");
        message.add("Mere");
        message.add("Rufina");
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mess = message.get(position);
                Toast.makeText(getBaseContext(), "" + mess, Toast.LENGTH_SHORT).show();
                pic.setImageResource(Personal[position]);

            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;


        public ImageAdapter(Context c) {
            context=c;
        }

        @Override
        public int getCount() {
            return Personal.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Personal[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }

}
