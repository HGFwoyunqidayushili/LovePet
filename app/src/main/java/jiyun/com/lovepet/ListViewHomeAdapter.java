package jiyun.com.lovepet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jiyun.com.lovepet.ui.HomeActivity;
import jiyun.com.lovepet.utils.CircleImageView;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class ListViewHomeAdapter extends BaseAdapter {

    private ViewHolder viewHolder;


    private List<jiyun.com.lovepet.HomeBean.DescBean> descBeanList;
    private Context context;
    public ListViewHomeAdapter(List<jiyun.com.lovepet.HomeBean.DescBean> desc, HomeActivity context) {
           this.descBeanList=desc;
           this.context=context;
    }

    @Override
    public int getCount() {
        return descBeanList.size();
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
            convertView = View.inflate(context, R.layout.homedata, null);
            viewHolder =  new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(descBeanList.get(position)

                .getUserImage())


                .error(R.drawable.jiazai)

                .into(viewHolder.imageHome);
        viewHolder.titleHome.setText(descBeanList.get(position).getFamily());
        viewHolder.contentHome.setText(descBeanList.get(position).getAddress());
        viewHolder.textView3.setText("￥"+descBeanList.get(position).getPrice()+"");

        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public RatingBar ratingBar2;
        public TextView contentHome;
        public TextView titleHome;
        public CircleImageView imageHome;
        public TextView textView3;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ratingBar2 = (RatingBar) rootView.findViewById(R.id.ratingBar2);
            this.contentHome = (TextView) rootView.findViewById(R.id.contentHome);
            this.titleHome = (TextView) rootView.findViewById(R.id.titleHome);
            this.imageHome = (CircleImageView) rootView.findViewById(R.id.imageHome);
            this.textView3 = (TextView) rootView.findViewById(R.id.priceHome);
        }

    }
}
