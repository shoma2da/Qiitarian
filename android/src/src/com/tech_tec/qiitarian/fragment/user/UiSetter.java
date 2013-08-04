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
        TextView facebookText = (TextView)mView.findViewById(R.id.text_facebook);
        if (user.hasFacebookNmae() == false) {
            facebookText.setVisibility(View.GONE);
            return;
        }
        
        facebookText.setText("FACEBOOK:" + user.getFacebookName());
    }
    
    private void setToTwitterName(User user) {
        TextView twitterText = (TextView)mView.findViewById(R.id.text_twitter);
        if (user.hasTwitterName() == false) {
            twitterText.setVisibility(View.GONE);
            return;
        }
        
        twitterText.setText("TWITTER:" + user.getTwitterName());
    }
    
    private void setToGithubName(User user) {
        TextView githubText = (TextView)mView.findViewById(R.id.text_github);
        if (user.hasGithubName() == false) {
            githubText.setVisibility(View.GONE);
            return;
        }
        
        githubText.setText("GITHUB:" + user.getGithubName());
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
    }
    
}
