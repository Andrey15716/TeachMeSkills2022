package commands;

import exceptions.CommandException;
import exceptions.RequestParamNullException;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {
    String execute(HttpServletRequest request) throws CommandException, RequestParamNullException;
}