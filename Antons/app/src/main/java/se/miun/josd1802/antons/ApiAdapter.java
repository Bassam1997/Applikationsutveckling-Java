package se.miun.josd1802.antons;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiAdapterVH>
{

    private List<Dinner> dinnerList;
    private Context context;

    public ApiAdapter()
    {

    }
    public void setData(List<Dinner> dinnerList)
    {
        this.dinnerList = dinnerList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ApiAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ApiAdapter.ApiAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_dishes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ApiAdapterVH holder, int position)
    {
        Dinner dinnerResponse = dinnerList.get(position);

        // VILKA VI VILL VISA I LISTAN
        String dishname = dinnerResponse.getName();

        holder.dishname.setText(dishname);
    }

    @Override
    public int getItemCount() {
        return dinnerList.size();
    }

    public class ApiAdapterVH extends RecyclerView.ViewHolder
    {
        TextView dishname;

        public ApiAdapterVH(@NonNull View itemView) {
            super(itemView);

            dishname = itemView.findViewById(R.id.dishname);
        }
    }
}
