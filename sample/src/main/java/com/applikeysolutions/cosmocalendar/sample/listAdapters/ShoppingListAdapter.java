package com.applikeysolutions.cosmocalendar.sample.listAdapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.applikeysolutions.cosmocalendar.sample.R;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.AdapterViewHolder>{

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        EditText productName;
        EditText productNumber;
        EditText productPrice;
        View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            this.productName = (EditText) itemView.findViewById(R.id.shopping_list_item_name);
            this.productName = (EditText) itemView.findViewById(R.id.shopping_list_item_number);
            this.productName = (EditText) itemView.findViewById(R.id.shopping_list_item_price);
        }
    }

}
