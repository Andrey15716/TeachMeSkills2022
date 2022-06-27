package commands;

import exceptions.CommandException;
import utils.PagesPathEnum;

import javax.servlet.http.HttpServletRequest;

public class RedirectRegistrationCommandImpl implements BaseCommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return PagesPathEnum.REGISTRATION_PAGE.getPath();
    }
}