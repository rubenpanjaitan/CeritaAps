package tugas.develops.project.ceritaApps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import tugas.develops.project.ceritaApps.Model.CeritaModel;
import tugas.develops.project.ceritaApps.R;

/**
 * Created by Hita Do on 17/08/2016.
 */
public class CeritaAdapter extends ArrayAdapter<CeritaModel> {

    private Context mContext;
    ArrayList<CeritaModel> products;

    static class ViewHolder {
        public TextView judul;
        public ImageView gambar;
    }

    public CeritaAdapter(Context _context,ArrayList<CeritaModel> _mylist) {
        super(_context, R.layout.custom_buku, _mylist);
        mContext = _context;
        this.products = _mylist;
    }

    public void setProducts(ArrayList<CeritaModel> products) {
        this.products.clear();
        for (int i = 0; i < products.size(); i++) {
            this.products.add(products.get(i));
        }
        notifyDataSetChanged();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        CeritaModel product = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            //membuat baru item
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.custom_buku, parent, false);
            viewHolder.judul = (TextView) convertView.findViewById(R.id.namaResep);
            viewHolder.gambar = (ImageView) convertView.findViewById(R.id.gambar);
            convertView.setTag(viewHolder);
        } else {
            //menggunakan item yang sudah pernah dibuat
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set item dengan value dari objek
        Picasso.with(viewHolder.gambar.getContext())
                .load("http://192.168.43.65/kumpulancerita/"+product.getGambar())
                .into(viewHolder.gambar);

        viewHolder.judul.setText(product.getJudul());

        return convertView;
    }
}
