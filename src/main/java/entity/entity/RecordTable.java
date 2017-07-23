package entity.entity;

import java.util.Date;

/**
 * Created by lx on 2017/6/3.
 */
public class RecordTable {

    private String fieldType;
    private Object oldVal;
    private Object newVal;
    private Date creDate;
    private String action;

    public RecordTable() {
    }

    public RecordTable(String fieldType, Object oldVal, Object newVal, String action, Date creDate) {
        this.fieldType = fieldType;
        this.creDate = creDate;
        this.action = action;
        this.newVal = newVal;
        this.oldVal = oldVal;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Object getOldVal() {
        return oldVal;
    }

    public void setOldVal(Object oldVal) {
        this.oldVal = oldVal;
    }

    public Object getNewVal() {
        return newVal;
    }

    public void setNewVal(Object newVal) {
        this.newVal = newVal;
    }

    public Date getCreDate() {
        return creDate;
    }

    public void setCreDate(Date creDate) {
        this.creDate = creDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "RecordTable{" +
                "fieldType='" + fieldType + '\'' +
                ", oldVal=" + oldVal +
                ", newVal=" + newVal +
                ", creDate=" + creDate +
                ", action='" + action + '\'' +
                '}';
    }
}
