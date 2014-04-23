package com.zstu.dail;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局文件
        setContentView(R.layout.activity_main);
        //找到按钮            google攻城狮     程序猿
        Button bt_dail = (Button) this.findViewById(R.id.bt_dail);
        //为按钮注册点击事件   4种1
        bt_dail.setOnClickListener(new MyLisener());
    }
    private class MyLisener implements OnClickListener{

		@Override
		public void onClick(View v) {
			EditText et_numberEditText = (EditText) MainActivity.this.findViewById(R.id.et_number);
			String numberString = et_numberEditText.getText().toString().trim();
			if(TextUtils.isEmpty(numberString)){
				Toast.makeText(MainActivity.this, "电话号码不能为空！", Toast.LENGTH_SHORT).show();
				return;
			}
			//Intent 意图 要干一件什么事情         喝   水     上  课     骑   马
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_CALL);
			//url统一资源定位符 http://www.baidu.com  uri统一资源标识符
			intent.setData(Uri.parse("tel:"+numberString));
			startActivity(intent);
		}
    }
}
