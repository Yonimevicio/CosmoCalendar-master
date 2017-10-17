package com.applikeysolutions.cosmocalendar.sample.listAdapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.applikeysolutions.customizablecalendar.R;

import java.util.ArrayList;

enum itemType{Day,Task,Event}
class WeekItems{
    String description = "";
    itemType type;
    WeekItems(String desc, itemType tipo){
        type = tipo;
        description = desc;
    }
    public int rtype(){
        int number = 0;
        switch (type){
            case Day: number = 0;
            break;
            case Task: number = 1;
            break;
            case Event: number = 2;
            break;
        }
        return number;
    }
}
public class ListDayAdapter extends RecyclerView.Adapter<ListDayAdapter.AdapterViewHolder> {
        private ArrayList<WeekItems> tareas = new ArrayList<>();
        public ListDayAdapter(){
        tareas.add(new WeekItems("Monday",itemType.Day));
        tareas.add(new WeekItems("Putivuelta",itemType.Event));
        tareas.add(new WeekItems("Tarea importante",itemType.Task));
        tareas.add(new WeekItems("Putivuelta2",itemType.Event));
        tareas.add(new WeekItems("Tarea importante2",itemType.Task));
       //CAMBIAR POR BUCLE DE FIREBASE

    }

    @Override
    public ListDayAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Instancia un layout XML en la correspondiente vista.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Inflamos en la vista el layout para cada
        View view;
        switch (getItemViewType(i)){
            case 0: view = inflater.inflate(R.layout.day_view_layout, viewGroup, false);
                break;
            case 1: view = inflater.inflate(R.layout.task_view_layout, viewGroup, false);
                break;
            default: view = inflater.inflate(R.layout.event_view_layout, viewGroup, false);
                break;
        }
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListDayAdapter.AdapterViewHolder adapterViewholder, int position) {
        adapterViewholder.task.setText(tareas.get(position).description);
        switch (getItemViewType(position)){
            case 0:
                break;
            case 1:  adapterViewholder.img.setImageResource(R.mipmap.task);
                break;
            default:  adapterViewholder.img.setImageResource(R.mipmap.event);
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return tareas.get(position).rtype();
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView task;
        ImageView img;
        View v;
        private AdapterViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            this.task = (TextView) itemView.findViewById(R.id.task);
            this.img = (ImageView) itemView.findViewById(R.id.task_even_icon);
        }
    }



}
