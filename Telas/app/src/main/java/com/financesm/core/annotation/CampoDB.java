package com.financesm.core.annotation;

/**
 * Created by diogo.coelho on 19/03/2017.
 */

public @interface CampoDB {

    public String alias() default "";
    public TipoCampo tipo() default TipoCampo.TEXT;
    public int size() default 10;

    public enum TipoCampo{
        TEXT("TEXT"), INTEIRO("INT"), DECIMAL("DECIMAL"), DATE("DATE");

        String field;
        TipoCampo(String field) {
            this.field = field;
        }
        public String field(){
            return this.field;
        }
    }
}
