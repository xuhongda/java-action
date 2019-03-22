package com.xu.eventdispatch;

public class EmailManager implements EntryListener {
    @Override
    public void entryAdded(EntryEvent entryevent) {
        System.out.println("EmailManager 处理 博客文章被创建事件。");
    }

    @Override
    public void entryDeleted(EntryEvent entryevent) {
        System.out.println("EmailManager 处理 博客文章被删除事件。");
    }

    @Override
    public void entryModified(EntryEvent entryevent) {
        System.out.println("EmailManager 处理 博客文章被修改事件。");
    }

}
