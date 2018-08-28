package com.example.basics.cryptoticker.ui.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.basics.cryptoticker.App;
import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.db.entity.AlarmEntity;

import java.util.List;
import java.util.Objects;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {

    private List<AlarmEntity> malarmList;

    public void setAlarmList(final List<AlarmEntity> alarmList) {
        if (malarmList == null) {
            malarmList = alarmList;
            notifyItemRangeInserted(0, alarmList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() { return malarmList.size(); }

                @Override
                public int getNewListSize() { return alarmList.size(); }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) { return malarmList.get(oldItemPosition).getDate().equals(alarmList.get(newItemPosition).getDate()); }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    AlarmEntity newAlarm = alarmList.get(newItemPosition);
                    AlarmEntity oldAlarm = malarmList.get(oldItemPosition);
                    return newAlarm.getDate() == oldAlarm.getDate()
                            && Objects.equals(newAlarm.getPrice(), oldAlarm.getPrice());
                }
            });
            malarmList = alarmList;
            result.dispatchUpdatesTo(this);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView alarmPriceTV, alarmDateTV;
        public Button deleteBTN;

        public ViewHolder(View view) {
            super(view);
            alarmPriceTV = view.findViewById(R.id.alarm_price_text);
            alarmDateTV = view.findViewById(R.id.alarm_date_text);
            deleteBTN = view.findViewById(R.id.alarm_delete_button);
        }
    }

    @Override
    public AlarmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_list_item, parent, false);
        return new AlarmAdapter.ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.alarmPriceTV.setText(String.valueOf(malarmList.get(position).getPrice()));
        holder.deleteBTN.setOnClickListener(v -> App.cryptoDatabase.alarmDao().deleteAlarm(malarmList.get(position)));
        holder.alarmDateTV.setText(malarmList.get(position).getDate().substring(0,15));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(malarmList != null)
            return malarmList.size();
        else
            return 0;
    }
}