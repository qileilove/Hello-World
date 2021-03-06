package com.example.fragmentbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnClickListener {

	private ListView newsTitleListView;
	
	private List<News> newsList;
	
	private NewsAdapter adapter;
	
	private boolean isTwoPane;
	
	public void onAttch(Activity activity) {
		super.onAttach(activity);
		// 初始化新闻数据
		newsList = getNews();
		adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.news_title_frag, container, false);
		newsTitleListView = (ListView) view.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnClickListener(this);
		return view;
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_layout) != null){
			// 可以找到news_content_layout布局时,为双页模式
			isTwoPane = true;
			// 找不到news_content_layout布局时,为单页模式
			isTwoPane = false;
		}
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
		News news = newsList.get(position);
		if(isTwoPane){
			// 如果是双页模式,则刷新NewsContentFragment中的内容
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		}else {
			// 如果是单页模式,则直接启动NewsContentActivity
			NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
		}
	}
	
	private List<News> getNews(){
		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("Succeed in College as a Learning Disabled Student");
		news1.setContent("College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-thanstellar" 
				+ "dining hall food.Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
		newsList.add(news1);
		
		News news2 = new News();
		news2.setTitle("Google Android exec poached by China's Xiaomi");
		news2.setContent("China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
		newsList.add(news2);
		
		return newsList;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
}
