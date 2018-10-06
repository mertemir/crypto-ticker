package com.example.basics.cryptoticker.ui.News;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.basics.cryptoticker.R;
import com.example.basics.cryptoticker.data.model.News;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import okhttp3.OkHttpClient;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    // TODO: Inject Picasso
    Picasso picasso;
    OkHttp3Downloader okHttp3Downloader;
    OkHttpClient okHttpClient;

    private List<News.Article> mnewsList;

    public void setNewsList(final List<News.Article> newsList, Context context) {

        okHttpClient = new OkHttpClient.Builder().build();
        okHttp3Downloader = new OkHttp3Downloader(okHttpClient);
        picasso = new Picasso.Builder(context).downloader(okHttp3Downloader).build();

        if (mnewsList == null) {
            mnewsList = newsList;
            notifyItemRangeInserted(0, newsList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() { return mnewsList.size(); }

                @Override
                public int getNewListSize() { return newsList.size(); }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) { return mnewsList.get(oldItemPosition).getTitle().equals(newsList.get(newItemPosition).getTitle()); }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    News.Article newArticle = newsList.get(newItemPosition);
                    News.Article oldArticle = mnewsList.get(oldItemPosition);
                    return newArticle.getTitle() == oldArticle.getTitle()
                            && Objects.equals(newArticle.getDescription(), oldArticle.getDescription())
                            && Objects.equals(newArticle.getUrlToImage(), oldArticle.getUrlToImage());
                }
            });
            mnewsList = newsList;
            result.dispatchUpdatesTo(this);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView newsTitleTV, newsDescTV;
        public ImageView thumbNailIV;

        public ViewHolder(View view) {
            super(view);
            newsTitleTV = view.findViewById(R.id.news_title_text);
            newsDescTV = view.findViewById(R.id.news_description_text);
            thumbNailIV = view.findViewById(R.id.news_thumbnail_image);
        }
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new NewsAdapter.ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.newsTitleTV.setText(mnewsList.get(position).getTitle());
        holder.newsDescTV.setText(mnewsList.get(position).getDescription());

        picasso.with(holder.thumbNailIV.getContext())
                .load(mnewsList.get(position).getUrlToImage())
                .placeholder(R.color.colorPrimary)
                .fit().centerCrop()
                .into(holder.thumbNailIV);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if(mnewsList != null)
            return mnewsList.size();
        else
            return 0;
    }
}