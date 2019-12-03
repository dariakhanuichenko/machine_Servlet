package ua.training.controller.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ua.training.model.service.BoxService;

import javax.servlet.http.HttpServletRequest;

public class AddProductToBox implements Command {

    private static final Logger log = LogManager.getLogger(Login.class);
    private BoxService boxService;

    public AddProductToBox(BoxService boxService) {
        this.boxService = boxService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        boxService.findById(id).ifPresent(box -> {
            log.info(quantity);
            log.info("boxxxx:" + boxService.findById(id).get());
            if ((box.getCurrentLoad() + quantity) <= box.getTotalCapasity()) {
                boxService.updateBoxSetCurrentLoad((box.getCurrentLoad() + quantity), box.getId());
                log.info("current load for box " + id + " was updated, new current_load " + boxService.findById(id).get());
            } else {
                log.info("current load for box " + id + " wasn't updated\n number is too big");
            }
        });
        return "redirect:/app/user/empty-boxes";
    }
}
