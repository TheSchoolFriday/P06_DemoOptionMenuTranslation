package sg.edu.rp.c346.id20046797.demooptionmenutranslation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslated = findViewById(R.id.textViewTranslatedText);

        registerForContextMenu(tvTranslated);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.EnglishSelection:
                tvTranslated.setText("Hello");
                Toast.makeText(this, "English is Selected. (Option Menu)", Toast.LENGTH_SHORT).show();
                break;

            case R.id.FrenchSelection:
                tvTranslated.setText("Bonjour");
                Toast.makeText(this, "French is Selected (Option Menu)", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ItalianSelection:
                tvTranslated.setText("Ciao");
                Toast.makeText(this, "Italian is Selected (Option Menu)", Toast.LENGTH_SHORT).show();
                break;
                
            default:
                tvTranslated.setText("Something went wrong.");
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Grabs and Inflate the ContextMenu from the Menu_Main.XML without manually invoking:
        menu.add(0, 4, 4, "Additional (Empty)"); // This is for the Manual Add

        getMenuInflater().inflate(R.menu.menu_main, menu); // This is Adding using menu_main.xml
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.EnglishSelection:
                tvTranslated.setText("Hello");
                Toast.makeText(this, "English is Selected. (Context Menu)", Toast.LENGTH_SHORT).show();
                break;

            case R.id.FrenchSelection:
                tvTranslated.setText("Bonjour");
                Toast.makeText(this, "French is Selected (Context Menu)", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ItalianSelection:
                tvTranslated.setText("Ciao");
                Toast.makeText(this, "Italian is Selected (Context Menu)", Toast.LENGTH_SHORT).show();
                break;

            case 4:
                tvTranslated.setText("This is Just for Testing");
                Toast.makeText(this, "Additional is Selected (Context Menu)", Toast.LENGTH_SHORT).show();
                break;

            default:
                tvTranslated.setText("Something went wrong.");
                break;
        }

        return super.onContextItemSelected(item);
    }
}