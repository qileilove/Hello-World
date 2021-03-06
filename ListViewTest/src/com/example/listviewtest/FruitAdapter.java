package com.example.listviewtest;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FruitAdapter extends ArrayAdapter<Fruit>{
	
	private int resourceId;
	
	public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 获取当前项的Fruit实例
		Fruit fruit = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView ==null)
		{
			 view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			 viewHolder = new ViewHolder();
			 viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
			 viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
			 // 将viewHolder存储在View中
			 view.setTag(viewHolder);
		}
		else
		{
		view = convertView;
		// 重新获取ViewHolder
		viewHolder = (ViewHolder) view.getTag();
		}
/*		ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
		TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
		fruitImage.setImageResource(fruit.getImageId());
		fruitName.setText(fruit.getName());*/
		viewHolder.fruitImage.setImageResource(fruit.getImageId());
		viewHolder.fruitName.setText(fruit.getName());
		return view;
		
	}
	
	class ViewHolder{
		ImageView fruitImage;
		
		TextView fruitName;
	}
}
