package com.example.lenovo.stockdarahindonesia;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class StockRvAdapter extends RecyclerView.Adapter<StockRvAdapter.StockRvHolder> {
    private List<DataDarah> datanyaa;
    private Activity activity;

    public StockRvAdapter(List<DataDarah> datanyaa, Activity activity) {
        this.datanyaa = datanyaa;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StockRvAdapter.StockRvHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item,viewGroup,false);
        return new StockRvHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockRvAdapter.StockRvHolder stockRvHolder, int position) {
        stockRvHolder.unit.setText(datanyaa.get(position).getUnit().toString());
        stockRvHolder.jumlah.setText(datanyaa.get(position).getStok().toString());

    }

    @Override
    public int getItemCount() {
        return datanyaa.size();
    }

    public class StockRvHolder extends RecyclerView.ViewHolder {
        TextView unit,jumlah;
        public StockRvHolder(View itemView) {
            super(itemView);
            unit=(TextView) itemView.findViewById(R.id.unit);
            jumlah=(TextView) itemView.findViewById(R.id.jumlah);

        }
    }
}
