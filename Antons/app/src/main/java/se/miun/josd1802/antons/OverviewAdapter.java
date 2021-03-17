package se.miun.josd1802.antons;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class OverviewAdapter extends ArrayAdapter<Dinner>
{
    private Activity activity;
    private ArrayList<Dinner> l_dinner;
    private static LayoutInflater inflater = null;

    public OverviewAdapter (Activity activity, int textViewResourceId, ArrayList<Dinner> l_dinner)
    {
        super(activity, textViewResourceId, l_dinner);

        try
        {
            this.activity = activity;
            this.l_dinner = l_dinner;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {

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
        public TextView overview_name;
        public TextView overview_description;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vi = convertView;
        final ViewHolder holder;
        try
        {
            if(convertView == null)
            {
                vi = inflater.inflate(R.layout.simple_list_item_2, null);
                holder = new ViewHolder();

                holder.overview_name = (TextView) vi.findViewById(R.id.overview_name);
                holder.overview_description = (TextView) vi.findViewById(R.id.overview_description);

                vi.setTag(holder);
            }else
            {
                holder = (ViewHolder) vi.getTag();
            }

            holder.overview_name.setText(l_dinner.get(position).getName());
            holder.overview_description.setText(l_dinner.get(position).getDetails());
        }catch (Exception e)
        {

        }
        return vi;
    }
}
