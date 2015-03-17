/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.diogopcoelho.finances.dao;

import java.util.List;
import net.diogopcoelho.finances.entities.Area;

/**
 *
 * @author coelho
 */
public interface AreaDAO {
    public Area find(Integer id);

    public List<Area> listAll();
    
    public List<Area> list(int paginacao, String descricao);

    public void add(Area area);

    public Area refresh(Area area);

    public void update(Area area);

    public void remove(Area area);

}
