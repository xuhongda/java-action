package com.xu.eventdispatch;

public interface EntryListener {

    /**
     * 博客文章被创建
     * @param entryevent
     */
    void entryAdded(EntryEvent entryevent);

    /**
     * 博客文章被删除
     * @param entryevent
     */

     void entryDeleted(EntryEvent entryevent);


    /**
     * 博客文章被修改
     * @param entryevent
     */
     void entryModified(EntryEvent entryevent);
}
