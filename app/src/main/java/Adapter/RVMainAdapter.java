package Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Entity.Persona;
import com.michell.servicio_rest_dswii.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MICHELL on 02/12/2017.
 */

public class RVMainAdapter extends RecyclerView.Adapter<RVMainAdapter.RVMainAdapterViewHolder> {

    private List<Persona> lstPersonas = new ArrayList<>();
    private RVMainAdapterListener mRVMainAdapterListener;

    public interface RVMainAdapterListener {
        void onClickItem(Persona persona);
    }

    public RVMainAdapter(RVMainAdapterListener rvMainAdapterListener) {
        this.mRVMainAdapterListener = rvMainAdapterListener;
    }

    public void add(Persona persona) {
        lstPersonas.add(persona);
        notifyItemInserted(lstPersonas.size() -1);
    }

    @Override
    public RVMainAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        RVMainAdapterViewHolder rvMainAdapterViewHolder = new RVMainAdapterViewHolder(view);
        return rvMainAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(RVMainAdapterViewHolder holder, int position) {
        Persona p = lstPersonas.get(position);
        holder.itemView.setOnClickListener(itemViewOnClickListener);

        holder.itemView.setTag(p);
        holder.tvMainItemNombreCompleto.setText(p.getNombre() + " " + p.getApellido());
        holder.tvMainItemEdad.setText(String.valueOf(p.getEdad()));
        holder.tvMainItemDNI.setText(p.getDni());
        holder.tvMainItemCelular.setText(String.valueOf(p.getCelular()));
        holder.tvMainItemDireccion.setText(p.getDireccion());
    }

    private View.OnClickListener itemViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Persona p = (Persona) view.getTag();
            if(mRVMainAdapterListener != null)
                mRVMainAdapterListener.onClickItem(p);
        }
    };

    @Override
    public int getItemCount() {
        return lstPersonas.size();
    }

    static class RVMainAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvMainItemEdad, tvMainItemNombreCompleto, tvMainItemDNI, tvMainItemCelular, tvMainItemDireccion;

        public RVMainAdapterViewHolder(View itemView) {
            super(itemView);
            tvMainItemEdad = (TextView) itemView.findViewById(R.id.tvMainItemEdad);
            tvMainItemNombreCompleto = (TextView) itemView.findViewById(R.id.tvMainItemNombreCompleto);
            tvMainItemDNI = (TextView) itemView.findViewById(R.id.tvMainItemDNI);
            tvMainItemCelular = (TextView) itemView.findViewById(R.id.tvMainItemCelular);
            tvMainItemDireccion = (TextView) itemView.findViewById(R.id.tvMainItemDireccion);
        }
    }

}
