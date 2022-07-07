package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> {
    ConnectionPool pool = ConnectionPool.getInstance();

    T create(T entity);

    List<T> read();

    T update(T entity);

    void delete(int id);
}
