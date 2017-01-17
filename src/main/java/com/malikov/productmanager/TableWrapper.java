package com.malikov.productmanager;

import com.malikov.productmanager.model.Product;
import org.displaytag.decorator.TableDecorator;

public class TableWrapper extends TableDecorator {
    public TableWrapper() {
        super();
    }

    public String getLinkEdit() {
        Product lObject = (Product) getCurrentRowObject();
        int lId = lObject.getId();

        return "<a href=\"" + "edit/" + lId + "\">Edit</a>";
    }

    public String getLinkDelete() {
        Product lObject = (Product) getCurrentRowObject();
        int lId = lObject.getId();

        return "<a href=\"" + "remove/" + lId + "\">Delete</a>";
    }

    public String getLinkName() {
        Product lObject = (Product) getCurrentRowObject();
        int lId = lObject.getId();

        return "<a href=\"" + "productdata/" + lId + "\" target=\"_self\">" + lObject.getName() + "</a>";
    }

}