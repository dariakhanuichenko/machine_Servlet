package ua.training.controller.command;

import ua.training.model.dto.BoxDTO;
import ua.training.model.dto.BoxWithProductNameDTO;
import ua.training.model.service.BoxService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagerEmptyBoxes implements Command {

    private BoxService boxService;

    public ManagerEmptyBoxes(BoxService boxService) {
        this.boxService = boxService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<BoxWithProductNameDTO> boxes = boxService.findBoxByCurrentLoad(0);
        request.setAttribute("boxes", boxes);
        request.setAttribute("boxDTO", new BoxDTO());
        return "/WEB-INF/manager/manager-empty-boxes.jsp";
    }
}
