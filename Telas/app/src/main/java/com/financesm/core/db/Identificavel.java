package com.financesm.core.db;

import java.io.Serializable;

/**
 * Created by diogo.coelho on 21/03/2017.
 */

public interface Identificavel extends Serializable {

    Long getId();
    void setId(Long id);

}
