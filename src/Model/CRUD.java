package Model;

import NodeData.NodeDataKamar;

public interface CRUD <T>{
    void create(T node);
    T read();
    void update(T node);
    boolean delete(int id);
}
