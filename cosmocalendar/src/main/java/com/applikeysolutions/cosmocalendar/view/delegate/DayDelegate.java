package com.applikeysolutions.cosmocalendar.view.delegate;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applikeysolutions.customizablecalendar.R;
import com.applikeysolutions.cosmocalendar.adapter.MonthAdapter;
import com.applikeysolutions.cosmocalendar.adapter.viewholder.DayHolder;
import com.applikeysolutions.cosmocalendar.model.Day;
import com.applikeysolutions.cosmocalendar.selection.BaseSelectionManager;
import com.applikeysolutions.cosmocalendar.selection.MultipleSelectionManager;
import com.applikeysolutions.cosmocalendar.view.CalendarView;

import java.io.Console;

public class DayDelegate extends BaseDelegate {

    private MonthAdapter monthAdapter;

    public DayDelegate(CalendarView calendarView, MonthAdapter monthAdapter) {
        this.calendarView = calendarView;
        this.monthAdapter = monthAdapter;
    }

    public DayHolder onCreateDayHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_day, parent, false);
        return new DayHolder(view, calendarView);
    }

    public void onBindDayHolder(final RecyclerView.Adapter daysAdapter, final Day day,
                                final DayHolder holder, final int position) {
        final BaseSelectionManager selectionManager = monthAdapter.getSelectionManager();
        holder.bind(day, selectionManager);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("a toni le gusta paola","estoy aprentando este boton");
                //AQUI SE HACE EL ONCLICK PARA LA SEMANA
                if (!day.isDisabled()) {
                    selectionManager.toggleDay(day);
                    if (selectionManager instanceof MultipleSelectionManager) {
                        daysAdapter.notifyItemChanged(position);
                    } else {
                        monthAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }
}
