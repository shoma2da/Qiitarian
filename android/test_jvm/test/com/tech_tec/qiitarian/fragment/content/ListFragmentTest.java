package com.tech_tec.qiitarian.fragment.content;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.tech_tec.qiitarian.R;

import android.view.LayoutInflater;
import android.view.View;

public class ListFragmentTest {
    
    @Test
    public void 初期化処理のテスト() {
        View mockView = mock(View.class);
        LayoutInflater mockInflater = mock(LayoutInflater.class);
        when(mockInflater.inflate(R.layout.fragment_list, null)).thenReturn(mockView);
        
        ListFragment listFragment = new ListFragment();
        View result = listFragment.onCreateView(mockInflater, null, null);
        
        assertSame(mockView, result);
    }
    
}
