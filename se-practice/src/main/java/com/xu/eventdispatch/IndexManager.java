package com.xu.eventdispatch;

public class IndexManager implements EntryListener {

    @Override
    public void entryAdded(EntryEvent entryevent) {


        System.out.println("IndexManager 处理 博客文章被创建事件。");

    }

    @Override
    public void entryDeleted(EntryEvent entryevent) {
        // TODO Auto-generated method stub
        System.out.println("IndexManager 处理 博客文章被删除事件。");

    }

    @Override
    public void entryModified(EntryEvent entryevent) {
        // TODO Auto-generated method stub
        System.out.println("IndexManager 处理 博客文章被修改事件。");
    }
}
