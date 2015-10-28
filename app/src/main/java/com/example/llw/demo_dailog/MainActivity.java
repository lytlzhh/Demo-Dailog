package com.example.llw.demo_dailog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout linear1;
    private Button btn1;
    private Button btn2;
    private FrameLayout framelayout;
    private LinearLayout linear2;
    private Button btn3;
    private Button btn4;

    private boolean[] checkdeditems;
    private String[] arrary4;

    private void assignViews() {
        linear1 = (LinearLayout) findViewById(R.id.linear_1);
        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        framelayout = (FrameLayout) findViewById(R.id.framelayout);
        linear2 = (LinearLayout) findViewById(R.id.linear_2);
        btn3 = (Button) findViewById(R.id.btn_3);
        btn4 = (Button) findViewById(R.id.btn_4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignViews();


        //只有按钮的对话框 最多只有：确定，中立，取消三个按钮            只有按钮的对话框 最多只有：确定，中立，取消三个按钮
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                //  AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("系统提示：：：：：");
                alertDialog.setMessage("hello 你好！这是带确定，中立，取消功能的对话框！！！");
                alertDialog.setIcon(R.mipmap.ic_launcher);

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你好！你点击的是取消按钮", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你好！你点击的是确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你好！中立", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.show();
            }
        });


        /*带列表的对话框  ********************带列表的对话框       带列表的对话框      带列表的对话框     带列表的对话框  */
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setTitle("汪峰，，章子怡");
                // builder2.setMessage("是吗是AlertDialog.Builder和Dialog和Builder是什么关系!!!");
                //注意：如果这里设置了setMessage那么后面的数组arrary中的内容不会显示，因为一个对话框中只能有一个setMessage （至少俺还没遇到）
                builder2.setIcon(R.mipmap.ya);

                final String[] arrary = new String[]{"法拉利", "奔驰", "保时捷", "兰博基尼", "劳斯莱斯"};
                //如果不是仅仅在对话框中设置按钮那么需要实现：setitems 即：设置小项目items   此外对话框中有多少item是根据你自己定义的内容数量 这里是arrary
                builder2.setItems(arrary, new DialogInterface.OnClickListener() {
                    @Override //which是指你要监听item的id号
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "你选择是：" + arrary[which], Toast.LENGTH_SHORT).show();
                    }
                });
                builder2.create().show();
            }
        });


        //带单选列表项和N个按钮的对话框 带单选列表项和N个按钮的对话框     带单选列表项和N个按钮的对话框     带单选列表项和N个按钮的对话框
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
                builder3.setTitle("带多个单选列表项和N个按钮对话框");
                builder3.setIcon(R.mipmap.a);

                final String[] arrary3 = new String[]{"温泉", "旅游", "骑行", "农家乐", "酒店", "旅社", "英超", "西甲", "欧冠", "NBA", "电影院", "网吧", "KTV", "ATM", "生活"};
                //为了要显示自己定义的数据，这里就不能实现setMessage（）这个方法了

                builder3.setSingleChoiceItems(arrary3, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "先生，女士你选择的是：" + arrary3[which], Toast.LENGTH_SHORT).show();
                    }
                });
                //这里需要添加按钮，如果没有则对话框不能退出
                builder3.setPositiveButton("确定", null);
                builder3.setNegativeButton("取消", null);
                builder3.setNeutralButton("中立", null);
                //着三个按钮都可以根据需要建立监听，以扩展点击后想做的事情 如：将所选中的信息传给需要的xx
                builder3.create().show();//没有这个，对话框就不能显示
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(MainActivity.this);
                builder4.setTitle("这是带复选列表先和N个按钮的对话框");
                builder4.setIcon(R.mipmap.a);
                //checkeditems是记录items被是否选中的状态
                checkdeditems = new boolean[]{false, true, false, true, false, true, false, true, false, true, false, true, false, true, false};
                arrary4 = new String[]{"我", "小瑞", "小蕊", "小艾", "小婊子", "小美", "小娟", "小梅", "小花", "小姐", "小丽", "小芬", "小英", "小敏", "小明"};

                builder4.setMultiChoiceItems(arrary4, checkdeditems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkdeditems[which] = isChecked;//改变被操作列表的状态 ?????????????????????????????
                        //isChecked官方解释：isChecked - True if the click checked the item, else false
                    }
                });

                builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";//用于保存选择的结果
                        for (int i = 0; i < checkdeditems.length; i++) {
                            //???????????????????????????????????????
                            if (checkdeditems[i] != false) {
                                result += arrary4[i] + "  ";
                            }
                        }

                        if (!"".equals(result)) {
                            Toast.makeText(MainActivity.this, "你选择了[" + result + "]", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                builder4.create().show();
            }
        });

    }

}
