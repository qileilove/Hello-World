package com.example.uibestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView msgListView;
	
	private EditText inputText;
	
	private Button send;
	
	private MsgAdapter adapter;
	
	private List<Msg> msgList = new ArrayList<Msg>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// ��ʼ����Ϣ����
		initMsgs();
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item, msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if(!"".equals(content)){
					Msg msg = new Msg(content, Msg.TYPE_SENT);
					msgList.add(msg);
					// ��������Ϣʱ,ˢ��ListView�е���ʾ
					adapter.notifyDataSetChanged();
					// ��ListView��λ�����һ��
					msgListView.setSelection(msgList.size());
					// ���������е�����
					inputText.setText("");
				}
			}
		});
	}

	private void initMsgs(){
		Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
		msgList.add(msg1);
		Msg msg2 = new Msg("Hello. Who is that?", Msg.TYPE_SENT);
		msgList.add(msg2);
		Msg msg3 = new Msg("This is Tom. Nice talking to you.", Msg.TYPE_RECEIVED);
		msgList.add(msg3);
		Msg msg4 = new Msg("fuck you", Msg.TYPE_RECEIVED);
		msgList.add(msg4);
		Msg msg5 = new Msg("Me too", Msg.TYPE_SENT);
		msgList.add(msg5);
		Msg msg6 = new Msg("��֪����,����ȥgoogle.", Msg.TYPE_RECEIVED);
		msgList.add(msg6);
		Msg msg7 = new Msg("�Ǿ�Ŭ����.", Msg.TYPE_SENT);
		msgList.add(msg7);
		Msg msg8 = new Msg("��", Msg.TYPE_RECEIVED);
		msgList.add(msg8);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}