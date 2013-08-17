package com.tech_tec.qiitarian.fragment.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.user.User;
import com.tech_tec.qiitarian.task.icon.FetchIconTask;

public class UiSetter {
    
    private View mView;
    
    public UiSetter(View view) {
        mView = view;
    }
    
    void showErrorView() {
        Toast.makeText(mView.getContext(), "通信エラー", Toast.LENGTH_SHORT).show();
    }
    
    void showView(User user) {
        setToNameText(user);
        setToDescText(user);
        setToIconImage(user);
        setToFacebookName(user);
        setToTwitterName(user);
        setToGithubName(user);
        setToFollowingCount(user);
        setToFollowerCount(user);
        setToItemCount(user);
        setToStock(user);
    }
    
    private void setToNameText(User user) {
        TextView nameText = (TextView)mView.findViewById(R.id.text_user_name);
        nameText.setText(user.getNameStr());
    }
    
    private void setToDescText(User user) {
        TextView descText = (TextView)mView.findViewById(R.id.text_description);
        if (user.hasDescription() == false) {
            descText.setVisibility(View.GONE);
            return;
        }
        
        descText.setText(user.getDescription());
    }
    
    private void setToIconImage(User user) {
        ImageView iconImage = (ImageView)mView.findViewById(R.id.image_user_icon);
        new FetchIconTask(iconImage, user).execute();
    }
    
    private void setToFacebookName(User user) {
        View facebookView = mView.findViewById(R.id.image_facebook);
        if (user.hasFacebookNmae() == false) {
            facebookView.setVisibility(View.GONE);
            return;
        }
        facebookView.setOnClickListener(new GotoFacebookPageListener(user, mView.getContext()));
    }
    
    private void setToTwitterName(User user) {
        View twitterView = mView.findViewById(R.id.image_twitter);
        if (user.hasTwitterName() == false) {
            twitterView.setVisibility(View.GONE);
            return;
        }
        twitterView.setOnClickListener(new GotoTwitterPageListener(user, mView.getContext()));
    }
    
    private void setToGithubName(User user) {
        View githubView = mView.findViewById(R.id.image_github);
        if (user.hasGithubName() == false) {
            githubView.setVisibility(View.GONE);
            return;
        }
        githubView.setOnClickListener(new GotoGithubPageListener(user, mView.getContext()));
    }
    
    private void setToFollowingCount(User user) {
        TextView followingCountText = (TextView)mView.findViewById(R.id.text_following);
        followingCountText.setText("following:" + user.getFollowingCount());
    }
    
    private void setToFollowerCount(User user) {
        TextView followerCountText = (TextView)mView.findViewById(R.id.text_follower);
        followerCountText.setText("follower:" + user.getFollowerCount());
    }
    
    private void setToItemCount(User user) {
        TextView itemCountText = (TextView)mView.findViewById(R.id.text_item_count);
        itemCountText.setText("投稿数:" + user.getItemCount());
        
        itemCountText.setOnClickListener(new GotoUsersItemActivityListener(mView.getContext(), user));
    }
    
    private void setToStock(User user) {
        View stockView = (TextView)mView.findViewById(R.id.text_stock);
        stockView.setOnClickListener(new GotoUserStocksActivityListener(mView.getContext(), user));
    }
    
}
