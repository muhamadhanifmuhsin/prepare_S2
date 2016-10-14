/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entities.Sekolah;
import java.util.List;

/**
 *
 * @author hanif
 */
public interface SekolahIF {
    public void save(Sekolah b);
    public void update(Sekolah b);
    public void delete(Sekolah b);
    public List<Sekolah> read();
    public List<Sekolah> find(String key);
    
    
    
}
