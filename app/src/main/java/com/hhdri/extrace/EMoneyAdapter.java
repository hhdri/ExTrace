package com.hhdri.extrace;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hhdri on 12/29/17.
 */

public class EMoneyAdapter extends RecyclerView.Adapter<EMoneyAdapter.ViewHolder>{

    private List<EMoney> list;
    private Context context;

    public Context getContext() {
        return context;
    }

    public EMoneyAdapter(Context context, List<EMoney> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public EMoneyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View eMoneyView = inflater.inflate(R.layout.item_emoney, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(eMoneyView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EMoneyAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        EMoney eMoney = list.get(position);

        // Set item views based on your views and data model
        TextView nameTextView = viewHolder.nameTextView;
        TextView sellPriceTextView = viewHolder.sellPriceTextView;
        TextView reserveTextView = viewHolder.reserveTextView;
        TextView buyPriceTextView = viewHolder.buyPriceTextView;
        ImageView imageView = viewHolder.imageView;

        nameTextView.setText(eMoney.getMoneyName());
        sellPriceTextView.setText(Float.toString(eMoney.getSellPrice()));
        buyPriceTextView.setText(Float.toString(eMoney.getBuyPrice()));
        reserveTextView.setText(Float.toString(eMoney.getReserve()));
        imageView.setImageResource(eMoney.getImageReference());

    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, buyPriceTextView, sellPriceTextView, reserveTextView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.emoney_name);
            buyPriceTextView = (TextView) itemView.findViewById(R.id.buy_price);
            sellPriceTextView = (TextView) itemView.findViewById(R.id.sell_price);
            reserveTextView = (TextView) itemView.findViewById(R.id.reserve);
            imageView = (ImageView) itemView.findViewById(R.id.emoney_image);
        }
    }
}
