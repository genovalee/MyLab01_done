package view;

import javax.faces.event.ActionEvent;

import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ViewObjectImpl;

import view.utils.ADFUtils;

public class DupRow {
    public DupRow() {
    }
    //Oracle ADF ActionEvent to duplicate a row
    public void duplicateRowLine(ActionEvent e) {
        ViewObject vo = (ViewObjectImpl) ADFUtils.findIterator("EmployeesView3Iterator").getViewObject();
        Row currentRow = vo.getCurrentRow();
        //        System.out.println(currentRow.getAttribute(1));
        Row duplicatedRow = vo.createRow();
        AttributeDef[] voKeyAttributes = vo.getKeyAttributeDefs(); //List of the primary keys that need to be unique
        String[] currentRowAttributes = currentRow.getAttributeNames();
        for (String attributeName : currentRowAttributes) {
            int attributeIndex = duplicatedRow.getAttributeIndexOf(attributeName); //複製索引值
            //            System.out.println(attributeName);
            //Check if the attribute is updatable
            if (duplicatedRow.isAttributeUpdateable(attributeIndex)) {
                //Check if the attribute is a Primary Key
                if (!this.attributeIsPrimaryKey(voKeyAttributes, attributeName)) {
                    //If it's not, copy the attribute value to the duplicated row
                    duplicatedRow.setAttribute(attributeName, currentRow.getAttribute(attributeName));
                }
            }
        }
        //Add the duplicated row to your View Object
        vo.insertRow(duplicatedRow);
    }

    private boolean attributeIsPrimaryKey(AttributeDef[] voKeyAttributes, String currentAttributeName) {
        for (AttributeDef voKeyAttribute : voKeyAttributes) {
            if (voKeyAttribute.isPrimaryKey() && currentAttributeName.equals(voKeyAttribute.getName())) {
                //If one of the primaryKey attribute is the current attribute
                return true;
            }
        }
        return false;
    }
}
