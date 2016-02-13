/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tojsq.mode;

import java.io.Serializable;

/**
 *
 * @author tanglin
 */
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -595691168517465151L;

    private Long id;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[entityId=" + getId() + "]";
    }
}
