package commands;

import entities.User;
import exceptions.CommandException;
import exceptions.RequestParamNullException;
import repositories.UserRepository;
import repositories.impl.UserRepositoryImpl;
import utils.PagesPathEnum;
import utils.RequestParamsEnum;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConfirmRegistrationCommandImpl implements BaseCommand {
    UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public String execute(HttpServletRequest req) throws CommandException, RequestParamNullException {
        String name = req.getParameter(RequestParamsEnum.NAME.getValue());
        String surname = req.getParameter(RequestParamsEnum.SURNAME.getValue());
        String password = req.getParameter(RequestParamsEnum.PASSWORD.getValue());
        String dateBorn = req.getParameter(RequestParamsEnum.DATE_BORN.getValue());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateBorn, formatter);
        req.setAttribute(RequestParamsEnum.LOGIN.getValue(), name);
        User userRegistered = new User(name, surname, password, date);

        if (userRepository.getUserByLoginAndPass(name, password).isEmpty()) {
            userRepository.addUser(userRegistered);
            return PagesPathEnum.REGISTRATION_SUCCESS.getPath();
        } else {
            return PagesPathEnum.REGISTRATION_PAGE.getPath();
        }
    }
}