package com.example.testwelcome.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.testwelcome.R;
import com.github.vipulasri.timelineview.TimelineView;

import butterknife.BindView;

public class TimeLineViewHolder extends RecyclerView.ViewHolder {
    public TimelineView mTimelineView;
    // @BindView(R.id.text_timeline_date)
    public TextView mDate;
   // @BindView(R.id.text_timeline_title)
    public TextView mMessage;


    public TimeLineViewHolder(View itemView, int viewType) {
        super(itemView);
        mDate=(TextView) itemView.findViewById(R.id.text_timeline_date);
        mMessage=(TextView) itemView.findViewById(R.id.text_timeline_title);
        mTimelineView = (TimelineView) itemView.findViewById(R.id.time_marker);
        mTimelineView.initLine(viewType);

    }
}
