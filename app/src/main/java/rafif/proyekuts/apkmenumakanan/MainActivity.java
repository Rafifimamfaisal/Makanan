package rafif.proyekuts.apkmenumakanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apkmenumakanan.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recMakanan;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Makanan> listMakanan;

    void dataMakanan(){
        listMakanan = new ArrayList<>();
        listMakanan.add(new Makanan("Pecel lele","Pecel lele kriuk dan gurih",15000, R.drawable.pecel));
        listMakanan.add(new Makanan("Nasi goreng mercon","Nasi goreng pedesnya sampe ke perut",14500,R.drawable.nsgoreng));
        listMakanan.add(new Makanan("Ayam geprek keju","Ayam geprek ditambah taburan keju",20000,R.drawable.geprek));
        listMakanan.add(new Makanan("Kari ayam","Kari ayam sedep pol",17500,R.drawable.kari));
        listMakanan.add(new Makanan("Tahu bulat","Tahu bulat garansi anti kempes",500,R.drawable.tahu));
        listMakanan.add(new Makanan("Salad buah","Salad buah-buahan yang sangat fresh",12000,R.drawable.salad));
        data();
    }
    void data(){
        recMakanan = findViewById(R.id.recMenu);
        adapter = new MakananAdapter(this,listMakanan);
        layoutManager = new LinearLayoutManager(this);
        recMakanan.setLayoutManager(layoutManager);
        recMakanan.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataMakanan();

    }
}