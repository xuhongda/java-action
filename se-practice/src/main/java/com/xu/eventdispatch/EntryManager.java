package com.xu.eventdispatch;

public class EntryManager {

    /**
     * @param args
     */
    public static void main(String[] args) {


        EntryManager eventManager=new EntryManager();
        Entry entry=new Entry();
        entry.setId(1L);
        entry.setName("test");
        //创建
        eventManager.addEntry(entry);
        //修改
        eventManager.modifyEntry(entry);
        //删除
        eventManager.deleteEntry(entry);
    }

    public void addEntry(Entry entry) {
        System.out.println("add entry ...id="+entry.getId());

        // 事件分发
        EntryEvent event = new EntryEvent(EntryEvent.ENTRY_ADDED, entry, null);
        EntryEventDispatcher.getInstance().dispatchEvent(event);

    }

    public void deleteEntry(Entry entry) {
        System.out.println("delete entry ...id="+entry.getId());

        // 事件分发
        EntryEvent event = new EntryEvent(EntryEvent.ENTRY_DELETED, entry, null);
        EntryEventDispatcher.getInstance().dispatchEvent(event);

    }

    public void modifyEntry(Entry entry) {
        System.out.println("modify entry ...id="+entry.getId());
        // 事件分发
        EntryEvent event = new EntryEvent(EntryEvent.ENTRY_MODIFIED, entry, null);
        EntryEventDispatcher.getInstance().dispatchEvent(event);

    }
}
