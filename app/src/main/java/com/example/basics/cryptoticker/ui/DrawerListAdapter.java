package com.example.basics.cryptoticker.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.model.ListItem;

import java.util.List;

public class DrawerListAdapter extends ArrayAdapter<ListItem> {

    private final Context context;
    private final List<ListItem> items;

    public DrawerListAdapter(Context context, List<ListItem> items) {
        super(context, -1, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.drawer_list_item, parent, false);

        TextView nameTV = rowView.findViewById(R.id.name_text);
        TextView priceTV = rowView.findViewById(R.id.price_text);
        ImageView iconIV = rowView.findViewById(R.id.icon_image);

        nameTV.setText(items.get(position).getName());
        priceTV.setText(items.get(position).getPrice());
        iconIV.setImageResource(items.get(position).getIcon());

        return rowView;
    }
}


