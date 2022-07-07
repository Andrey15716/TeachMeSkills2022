package repositories;

import entities.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> getUserByLoginAndPass(String login, String password);

    void addUser(User user);
}
