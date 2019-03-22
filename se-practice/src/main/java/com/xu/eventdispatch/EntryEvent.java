package com.xu.eventdispatch;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class EntryEvent {
    /**
     * 事件类型:博客文章被创建
     */
    public static final int ENTRY_ADDED = 100;
    /**
     * 事件类型:博客文章被删除
     */
    public static final int ENTRY_DELETED = 101;
    /**
     * 事件类型:博客文章被修改
     */
    public static final int ENTRY_MODIFIED = 102;
    /**
     * 事件类型
     */
    private int eventType;
    /**
     * 博客文章对象
     */
    private Entry entry;
    /**
     * 事件触发日期
     */
    private Date date;
    /**
     * 事件辅助参数
     */
    private Map params;

    public EntryEvent(int eventType, Entry entry, Map params) {
        this.eventType = eventType;
        this.entry = entry;
        this.params = params != null ? Collections.unmodifiableMap(params)
                : null;
        date = new Date();
    }

    public int getEventType() {
        return eventType;
    }

    public Entry getEntry() {
        return entry;
    }

    public Map getParams() {
        return params;
    }

    public Date getDate() {
        return date;
    }

}
