package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    Panel P;
    Paint tlo_pola = new Paint();
    Paint tlo_pola2 = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(P = new Panel(this));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflacja = getMenuInflater();
        inflacja.inflate(R.menu.main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            int itemId = item.getItemId();

            if (itemId == R.id.tworca) {
                Context context = getApplicationContext();
                CharSequence text = "Tworca: Marcel Litwin";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                return true;
            } else if (itemId == R.id.wyjscie) {
                finish();
                return true;
            } else if (itemId == R.id.kolor1) {
                tlo_pola.setColor(Color.BLACK);
                tlo_pola2.setColor(Color.WHITE);
                P.postInvalidate();
                return true;
            } else if (itemId == R.id.kolor2) {
                tlo_pola.setColor(Color.RED);
                tlo_pola2.setColor(Color.YELLOW);
                P.postInvalidate();
                return true;
            } else {
                return super.onOptionsItemSelected(item);
            }
        }
    class Panel extends View{
        public Panel(Context context){
            super(context);
            tlo_pola.setColor(Color.WHITE);
            tlo_pola2.setColor(Color.BLACK);
        }
        public void onDraw(Canvas canvas){
            canvas.drawColor(Color.GRAY);
            float width = P.getWidth();
            float height = P.getHeight();
            float smallsize = Math.min(width, height);

            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if((i+j)%2==0) {
                        canvas.drawRect(i*smallsize/8, j*smallsize/8, (i+1)*smallsize/8, (j+1)*smallsize/8, tlo_pola );
                    } else {
                        canvas.drawRect(i*smallsize/8, j*smallsize/8, (i+1)*smallsize/8, (j+1)*smallsize/8, tlo_pola2 );
                    }
                }
            }
        }
    }


}