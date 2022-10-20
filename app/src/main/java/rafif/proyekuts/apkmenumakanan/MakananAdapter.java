package rafif.proyekuts.apkmenumakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apkmenumakanan.R;

import java.util.ArrayList;

class holder extends RecyclerView.ViewHolder{
    ImageView imgFoto;
    TextView txtNama, txtHarga;

    public holder(@NonNull View itemView) {
        super(itemView);

        imgFoto = itemView.findViewById(R.id.imgFoto);
        txtNama = itemView.findViewById(R.id.txtNama);
        txtHarga = itemView.findViewById(R.id.txtHarga);
    }
}
public class MakananAdapter extends RecyclerView.Adapter<holder> {
    Context context;

    ArrayList<Makanan> listMakanan;

    public MakananAdapter(Context context, ArrayList<Makanan> listMakanan) {
        this.context = context;
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_menu,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        holder.txtNama.setText(makanan.getNamaMakanan());
        String harga = "Rp " +String.format("%,d", makanan.getHarga());
        holder.txtHarga.setText(harga);
        holder.imgFoto.setImageResource(makanan.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(holder.itemView.getContext(),makanan.getNamaMakanan(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("nama_makanan", makanan.getNamaMakanan());
                intent.putExtra("deskripsi_makanan", makanan.getDeskripsiMakanan());
                intent.putExtra("harga_makanan", harga);
                intent.putExtra("gambar_makanan", makanan.getImage());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }
}
