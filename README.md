标签的多选、删除、添加为一体
重写了两个布局文件，第一个实现的是多选，第二个实现的是添加以及删除

实现标签的多选
 mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
                //Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });


        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener()
        {
            @Override
            public void onSelected(Set<Integer> selectPosSet)
            {
                //这里的代码中mFlowLayout.getSelectedList()是获取选择的个数
                setTitle("choose:" + selectPosSet.toString()+"   "+mFlowLayout.getSelectedList().toString());
                Log.e("pp",mFlowLayout.getSelectedList().toString());
            }
        });
        
        但是一个TagFlowLayout和一个FlowAddLayout两个自定义流式布局
