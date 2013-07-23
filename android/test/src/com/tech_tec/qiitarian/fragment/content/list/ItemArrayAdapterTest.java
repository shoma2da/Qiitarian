package com.tech_tec.qiitarian.fragment.content.list;

import static org.mockito.Mockito.*;
import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_tec.qiitarian.R;
import com.tech_tec.qiitarian.model.items.Item;

public class ItemArrayAdapterTest extends AndroidTestCase {
    
    private ItemArrayAdapter mItemArrayAdapter;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        mItemArrayAdapter = new ItemArrayAdapter(getContext()) {
            @Override
            void setIcon(ImageView iconImage, Item item) {
                //何もしない
            }
        };
    }
    
    public void test要素が正しく取得できるか() {
        Item item = mock(Item.class);
        when(item.getArticleTitle()).thenReturn("テストタイトル");
        when(item.getUserName()).thenReturn("テストユーザ名");
        when(item.getCreatedAt()).thenReturn("しばらく前");
        when(item.getTagsText()).thenReturn("タグタグタグ");
        when(item.getStockCount()).thenReturn(10);
        when(item.getCommentCount()).thenReturn(100);
        
        mItemArrayAdapter.add(item);
        
        //初回
        View resultView = mItemArrayAdapter.getView(0, null, null);
        checkView(null, resultView, item);
        
        //再利用時
        View initialView = LayoutInflater.from(getContext()).inflate(R.layout.listraw_item, null);
        checkView(initialView, mItemArrayAdapter.getView(0, initialView, null), item);
    }
    
    private void checkView(View initialView, View resultView, Item item) {
        if (initialView != null) {
            assertSame(initialView, resultView);
        }
        
        TextView titleText = (TextView)resultView.findViewById(R.id.text_item_title);
        TextView usernameText = (TextView)resultView.findViewById(R.id.text_item_username);
        TextView createdAtText = (TextView)resultView.findViewById(R.id.text_item_created_at);
        TextView tagsText = (TextView)resultView.findViewById(R.id.text_item_tags);
        TextView stockCountText = (TextView)resultView.findViewById(R.id.text_item_stock_count);
        TextView commentCountText = (TextView)resultView.findViewById(R.id.text_item_comment_count);
        
        assertEquals(titleText.getText().toString(), item.getArticleTitle());
        assertEquals(usernameText.getText().toString(), item.getUserName());
        assertEquals(createdAtText.getText().toString(), item.getCreatedAt());
        assertEquals(tagsText.getText().toString(), item.getTagsText());
        assertEquals(stockCountText.getText().toString(), "ストック数：" + item.getStockCount());
        assertEquals(commentCountText.getText().toString(), "コメント数：" + item.getCommentCount());
    }
}
