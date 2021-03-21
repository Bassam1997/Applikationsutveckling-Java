package se.miun.josd1802.antons;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ApiAdapter extends ArrayAdapter<Dinner>
{
    public static ArrayList<Dinner> overviewList_chef = new ArrayList<Dinner>();
    public static ArrayList<Dinner> l_dinner = new ArrayList<Dinner>();

    private Activity activity;
    private static LayoutInflater inflater = null;

    public ApiAdapter(Activity activity, int textviewresourceid, ArrayList<Dinner> l_dinner)
    {
        super(activity, textviewresourceid, l_dinner);

        try {
            this.activity = activity;
            this.l_dinner = l_dinner;
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public int getCount()
    {
        return l_dinner.size();
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        private TextView inc_decValue;
        private ImageButton button_increment;
        private ImageButton button_decrement;

        TextView dishname;
        EditText editText;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        ViewHolder holder;

        Dinner dinnerResponse = l_dinner.get(position);

        try
        {
            if(convertView == null)
            {
                view = inflater.inflate(R.layout.row_dishes, null);
                holder = new ViewHolder();
                holder.inc_decValue = view.findViewById(R.id.inc_decValue);
                holder.button_decrement = view.findViewById(R.id.b_decrement);
                holder.button_increment = view.findViewById(R.id.b_increase);

                holder.dishname = view.findViewById(R.id.dishname);
                holder.editText = view.findViewById(R.id.dishDescription);


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

                        dinnerResponse.setDescription(holder.editText.getText().toString());
                        holder.editText.setText("");
                        overviewList_chef.add(dinnerResponse);
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
                        }
                    }
                });
                view.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) view.getTag();
            }
            holder.dishname.setText(l_dinner.get(position).getName());

        }catch (Exception e)
        {
            System.out.println(e);
        }
        return view;
    }

    public void setData(ArrayList<Dinner> dinnerList)
    {
        l_dinner = dinnerList;
        notifyDataSetChanged();
    }
}
