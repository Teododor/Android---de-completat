package com.example.bagproject.Models;

        import androidx.room.ColumnInfo;
        import androidx.room.Entity;
        import androidx.room.PrimaryKey;

        import java.io.Serializable;

@Entity(tableName = "items")
public class Items implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int ID = 0;

    @ColumnInfo(name = "itemname")
    String itemName;

    @ColumnInfo(name = "category")
    String category;

    @ColumnInfo(name = "addedby")
    String addedby;

    @ColumnInfo(name = "checked")
    Boolean checked = false;

    public Items() {
        // Empty constructor
    }

    public Items(String itemName){
        this.itemName = itemName;
    }

    public Items(String itemName, String category){
        this.itemName = itemName;
        this.category = category;
    }

    public Items(String itemName, String category, Boolean checked) {
        this.addedby = "system";
        this.itemName = itemName;
        this.category = category;
        this.checked = checked;
    }


    public Items(String itemName, String category, String addedby, Boolean checked){
        this.itemName = itemName;
        this.category = category;
        this.addedby = addedby;
        this.checked = checked;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }


}
