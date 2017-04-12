package com.financesm.core;

import com.financesm.core.annotation.CampoDB;

/**
 * Created by diogo.coelho on 12/04/2017.
 */

public class CampoForm {

    public CampoForm (CampoDB campoDB, String fieldName){
        this.alias = campoDB.alias().isEmpty() ? fieldName : campoDB.alias();
        this.fieldName = fieldName;
        this.campoDB = campoDB;
    }

    private String alias;
    private String fieldName;
    private CampoDB campoDB;

    public String getAlias() {
        return alias;
    }

    public String getFieldName() {
        return fieldName;
    }

    public CampoDB getCampoDB() {
        return campoDB;
    }
}
