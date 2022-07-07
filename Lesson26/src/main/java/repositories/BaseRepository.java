package repositories;

import entities.BaseEntity;
import repositories.utils.ConnectionPool;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {
    ConnectionPool pool = ConnectionPool.getInstance();

    T create(T entity);

    List<T> read();

    T update(T entity);

    void delete(int id);
}
