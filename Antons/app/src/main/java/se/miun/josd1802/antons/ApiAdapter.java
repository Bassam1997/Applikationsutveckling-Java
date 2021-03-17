package se.miun.josd1802.antons;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ApiAdapterVH>
{
    private ArrayList<Dinner> DatabaseDinnerList;
    public static ArrayList<Dinner> overviewList_chef = new ArrayList<Dinner>();
    public static ArrayList<Dinner> overViewList = new ArrayList<Dinner>();
    private Context context;

    public ApiAdapter()
    {

    }
    public void setData(ArrayList<Dinner> dinnerList)
    {
        this.DatabaseDinnerList = dinnerList;
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
        Dinner dinnerResponse = DatabaseDinnerList.get(position);

        String dish_name = dinnerResponse.getName();

        holder.dishname.setText(dish_name);

        holder.button_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int quantity =  0;
                try{
                    quantity = Integer.parseInt(holder.inc_decValue.getText().toString());
                }catch (Exception e)
                {
                    quantity = 0;
                }
                holder.inc_decValue.setText(String.valueOf(quantity+1));

                dinnerResponse.setDetails(holder.editText.getText().toString());
                holder.editText.setText("");

                overviewList_chef.add(dinnerResponse);
                overViewList.add(dinnerResponse);
            }
        });

        holder.button_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int quantity = 0;
                try{
                    quantity = Integer.parseInt(holder.inc_decValue.getText().toString());
                }catch (Exception e)
                {
                    quantity = 0;
                }
                if(quantity > 0)
                {
                    holder.inc_decValue.setText(String.valueOf(quantity - 1));

                    overviewList_chef.remove(dinnerResponse);
                    overViewList.remove(dinnerResponse);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return DatabaseDinnerList.size();
    }

    public class ApiAdapterVH extends RecyclerView.ViewHolder
    {
        private TextView inc_decValue;
        private ImageButton button_increment;
        private ImageButton button_decrement;

        TextView dishname;
        EditText editText;
        RecyclerView.ViewHolder holder;

        public ApiAdapterVH(@NonNull View itemView) {
            super(itemView);

            inc_decValue = itemView.findViewById(R.id.inc_decValue);
            button_decrement = itemView.findViewById(R.id.b_decrement);
            button_increment = itemView.findViewById(R.id.b_increase);

            dishname = itemView.findViewById(R.id.dishname);
            editText = itemView.findViewById(R.id.dishDescription);


            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View view, boolean b) {
                    if(b)
                    {
                        System.out.println("CHANGE FOCUS");
                    }
                    else
                    {
                        System.out.println("ELSE");
                        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }
            });
        }
    }
}
