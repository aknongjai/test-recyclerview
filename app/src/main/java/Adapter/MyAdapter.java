package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tabasumgroupofcompanies.recyclerview.DetailsActivity;
import com.tabasumgroupofcompanies.recyclerview.R;
import java.util.List;
import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context mContext;
    private List<ListItem> mListItems;
    public MyAdapter(Context context, List list) {
        this.mContext=context;
        this.mListItems=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_adapter,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        ListItem item=mListItems.get(i);
        viewHolder.name.setText(item.getName());
        viewHolder.description.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Making each itemview able to listen to events
            itemView.setOnClickListener(this);
            //linking the TextView to xml in constructor
            name=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View v) {
          //get position of item clicked
          int position=getAdapterPosition();

          ListItem item=mListItems.get(position);
          Toast.makeText(mContext,item.getName(),Toast.LENGTH_LONG).show();
            Intent intent=new Intent(mContext,DetailsActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            mContext.startActivity(intent);
        }
    }
}
