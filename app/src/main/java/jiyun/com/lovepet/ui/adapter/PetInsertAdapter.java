package jiyun.com.lovepet.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jiyun.com.lovepet.R;
import jiyun.com.lovepet.ui.CircleImageView;
import jiyun.com.lovepet.ui.wallet.activity.Student;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class PetInsertAdapter extends BaseAdapter {
    private ArrayList<Student> arrayList;
    private Context context;
    private ViewHolder viewHolder;

    public PetInsertAdapter(ArrayList<Student> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.petinsertiteam, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(arrayList.get(position).getImage()).into(viewHolder.insertImage);
        viewHolder.insertText.setText(arrayList.get(position).getName());
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public CircleImageView insertImage;
        public TextView insertText;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.insertImage = (CircleImageView) rootView.findViewById(R.id.insertImage);
            this.insertText = (TextView) rootView.findViewById(R.id.insertText);
        }

    }
}
