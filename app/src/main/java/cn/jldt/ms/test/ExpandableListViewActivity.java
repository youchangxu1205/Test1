package cn.jldt.ms.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandableListViewActivity extends AppCompatActivity {

    private ExpandableListView expandableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);

        expandableList = (ExpandableListView) findViewById(R.id.expandable_list);
        //定义一个list该list是为一级条目提供数据
        List<Map<String, String>> groups = new ArrayList<Map<String, String>>();
        Map<String, String> group1 = new HashMap<String, String>();
        group1.put("group1", "group1-1");
        group1.put("group2", "group2-1");
        group1.put("group3", "group3-1");
        Map<String, String> group2 = new HashMap<String, String>();
        group2.put("group1", "group1-2");
        group2.put("group2", "group2-2");
        group2.put("group3", "group3-2");
        groups.add(group1);
        groups.add(group2);
        //定义一个list该list是为第一个一级条目提供二级条目数据
        List<Map<String, String>> child1 = new ArrayList<Map<String, String>>();
        Map<String, String> child1Date1 = new HashMap<String, String>();
        child1Date1.put("child", "child1Date1");
        Map<String, String> child1Date2 = new HashMap<String, String>();
        child1Date2.put("child", "child1Date2");
        child1.add(child1Date1);
        child1.add(child1Date2);
        //定义一个list该list是为第二个一级条目提供二级条目数据
        List<Map<String, String>> child2 = new ArrayList<Map<String, String>>();
        Map<String, String> child2Date1 = new HashMap<String, String>();
        child2Date1.put("child", "child2Date1");
        Map<String, String> child2Date2 = new HashMap<String, String>();
        child2Date2.put("child", "child2Date2");
        child2.add(child2Date1);
        child2.add(child2Date2);
        //定义一个list，该list用于存放所有的二级条目的数据
        List<List<Map<String, String>>> childs = new ArrayList<List<Map<String, String>>>();
        childs.add(child1);
        childs.add(child2);

        //生成一个SimpleExpandableListAdapter对象
        //1.context,2.以及条目的数据3.用来设置以及条目样式的布局文件4.指定以及条目的key
        //5.指定一级条目数据显示控件的id6.指定二级条目的数据7.设置二级条目样式的布局文件8.指定二级条目数据的key9.指定二级条目数据显示的id
        MyExpandableListViewAdapter simpleExpandableListAdapter = new MyExpandableListViewAdapter(this,
                groups,
                R.layout.layout_group,
                new String[]{"group1","group2","group3"},
                new int[]{R.id.group_1,R.id.group_2,R.id.group_3},
                childs,
                R.layout.layout_group,
                new String[]{"child"},
                new int[]{R.id.group_2});

        expandableList.setAdapter(simpleExpandableListAdapter);
    }

    private class MyExpandableListViewAdapter extends SimpleExpandableListAdapter {
        /**
         * Constructor
         *
         * @param context     The context where the {@link ExpandableListView}
         *                    associated with this {@link SimpleExpandableListAdapter} is
         *                    running
         * @param groupData   A List of Maps. Each entry in the List corresponds to
         *                    one group in the list. The Maps contain the data for each
         *                    group, and should include all the entries specified in
         *                    "groupFrom"
         * @param groupLayout resource identifier of a view layout that defines the
         *                    views for a group. The layout file should include at least
         *                    those named views defined in "groupTo"
         * @param groupFrom   A list of keys that will be fetched from the Map
         *                    associated with each group.
         * @param groupTo     The group views that should display column in the
         *                    "groupFrom" parameter. These should all be TextViews. The
         *                    first N views in this list are given the values of the first N
         *                    columns in the groupFrom parameter.
         * @param childData   A List of List of Maps. Each entry in the outer List
         *                    corresponds to a group (index by group position), each entry
         *                    in the inner List corresponds to a child within the group
         *                    (index by child position), and the Map corresponds to the data
         *                    for a child (index by values in the childFrom array). The Map
         *                    contains the data for each child, and should include all the
         *                    entries specified in "childFrom"
         * @param childLayout resource identifier of a view layout that defines the
         *                    views for a child. The layout file should include at least
         * @param childFrom   A list of keys that will be fetched from the Map
         *                    associated with each child.
         * @param childTo     The child views that should display column in the
         *                    "childFrom" parameter. These should all be TextViews. The
         *                    first N views in this list are given the values of the first N
         *                    columns in the childFrom parameter.
         */
        public MyExpandableListViewAdapter(Context context, List<? extends Map<String, ?>> groupData, int groupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
            super(context, groupData, groupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
        }

        /**
         * Constructor
         *
         * @param context              The context where the {@link ExpandableListView}
         *                             associated with this {@link SimpleExpandableListAdapter} is
         *                             running
         * @param groupData            A List of Maps. Each entry in the List corresponds to
         *                             one group in the list. The Maps contain the data for each
         *                             group, and should include all the entries specified in
         *                             "groupFrom"
         * @param expandedGroupLayout  resource identifier of a view layout that
         *                             defines the views for an expanded group. The layout file
         *                             should include at least those named views defined in "groupTo"
         * @param collapsedGroupLayout resource identifier of a view layout that
         *                             defines the views for a collapsed group. The layout file
         *                             should include at least those named views defined in "groupTo"
         * @param groupFrom            A list of keys that will be fetched from the Map
         *                             associated with each group.
         * @param groupTo              The group views that should display column in the
         *                             "groupFrom" parameter. These should all be TextViews. The
         *                             first N views in this list are given the values of the first N
         *                             columns in the groupFrom parameter.
         * @param childData            A List of List of Maps. Each entry in the outer List
         *                             corresponds to a group (index by group position), each entry
         *                             in the inner List corresponds to a child within the group
         *                             (index by child position), and the Map corresponds to the data
         *                             for a child (index by values in the childFrom array). The Map
         *                             contains the data for each child, and should include all the
         *                             entries specified in "childFrom"
         * @param childLayout          resource identifier of a view layout that defines the
         *                             views for a child. The layout file should include at least
         * @param childFrom            A list of keys that will be fetched from the Map
         *                             associated with each child.
         * @param childTo              The child views that should display column in the
         *                             "childFrom" parameter. These should all be TextViews. The
         *                             first N views in this list are given the values of the first N
         *                             columns in the childFrom parameter.
         */
        public MyExpandableListViewAdapter(Context context, List<? extends Map<String, ?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
            super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
        }

        /**
         * Constructor
         *
         * @param context              The context where the {@link ExpandableListView}
         *                             associated with this {@link SimpleExpandableListAdapter} is
         *                             running
         * @param groupData            A List of Maps. Each entry in the List corresponds to
         *                             one group in the list. The Maps contain the data for each
         *                             group, and should include all the entries specified in
         *                             "groupFrom"
         * @param expandedGroupLayout  resource identifier of a view layout that
         *                             defines the views for an expanded group. The layout file
         *                             should include at least those named views defined in "groupTo"
         * @param collapsedGroupLayout resource identifier of a view layout that
         *                             defines the views for a collapsed group. The layout file
         *                             should include at least those named views defined in "groupTo"
         * @param groupFrom            A list of keys that will be fetched from the Map
         *                             associated with each group.
         * @param groupTo              The group views that should display column in the
         *                             "groupFrom" parameter. These should all be TextViews. The
         *                             first N views in this list are given the values of the first N
         *                             columns in the groupFrom parameter.
         * @param childData            A List of List of Maps. Each entry in the outer List
         *                             corresponds to a group (index by group position), each entry
         *                             in the inner List corresponds to a child within the group
         *                             (index by child position), and the Map corresponds to the data
         *                             for a child (index by values in the childFrom array). The Map
         *                             contains the data for each child, and should include all the
         *                             entries specified in "childFrom"
         * @param childLayout          resource identifier of a view layout that defines the
         *                             views for a child (unless it is the last child within a group,
         *                             in which case the lastChildLayout is used). The layout file
         *                             should include at least those named views defined in "childTo"
         * @param lastChildLayout      resource identifier of a view layout that defines
         *                             the views for the last child within each group. The layout
         *                             file should include at least those named views defined in
         * @param childFrom            A list of keys that will be fetched from the Map
         *                             associated with each child.
         * @param childTo              The child views that should display column in the
         *                             "childFrom" parameter. These should all be TextViews. The
         *                             first N views in this list are given the values of the first N
         *                             columns in the childFrom parameter.
         */
        public MyExpandableListViewAdapter(Context context, List<? extends Map<String, ?>> groupData, int expandedGroupLayout, int collapsedGroupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData, int childLayout, int lastChildLayout, String[] childFrom, int[] childTo) {
            super(context, groupData, expandedGroupLayout, collapsedGroupLayout, groupFrom, groupTo, childData, childLayout, lastChildLayout, childFrom, childTo);
        }
    }


    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, ExpandableListViewActivity.class);
        activity.startActivity(intent);
    }
}
