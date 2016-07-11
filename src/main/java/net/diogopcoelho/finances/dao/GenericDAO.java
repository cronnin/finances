/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diogo.coelho
 * @param <T>
 * @param <Pk>
 */
public interface GenericDAO<T extends Serializable, Pk extends Serializable> {
    T find(Pk id);
    List<T> listAll();
    void add(T registro);
    T refresh(T registro);
    void update(T registro);
    void remove(T registro);
}
