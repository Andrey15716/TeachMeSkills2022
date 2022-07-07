package commands;

import exceptions.CommandException;
import exceptions.RequestParamNullException;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

public class HomePageCommand implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException, RequestParamNullException {
        return PagesPathEnum.HOME_PAGE.getPath();
    }
}